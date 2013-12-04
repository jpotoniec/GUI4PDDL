package pl.poznan.put.cs.gui4pddl.planview.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.MultiPartInitException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.helpers.DesktopApi;
import pl.poznan.put.cs.gui4pddl.planview.helpers.FileNameRegexProcessor;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class PlanView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "pl.poznan.put.cs.gui4pddl.views.PlanView";

	private static final String CLEAR_SELECTED_PLANS_TEXT = "Delete (delete)";
	private static final String CLEAR_SELECTED_PLANS_TOOLTIP = "Delete (delete)";
	private static final String CLEAR_ALL_FINISHED_PLANS_TEXT = "Clear all plans";
	private static final String CLEAR_ALL_FINISHED_PLANS_TOOLTIP = "Clear all plans";
	private static final String OPEN_READY_PLANS_IN_EDITOR_TEXT = "Open plan in the editor";
	private static final String OPEN_READY_PLANS_IN_EDITOR_TOOLTIP = "Open plan in the editor";
	private static final String OPEN_PLAN_WORKING_DIR_TEXT = "Open this folder";
	private static final String OPEN_PLAN_WORKING_DIR_TOOLTIP = "Open this folder";
	private static final String OPEN_PLANS_IN_EXTERNAL_EDITOR_TEXT = "Open plan in external editor";
	private static final String OPEN_PLANS_IN_EXTERNAL_EDITOR_TOOLTIP = "Open plan in external editor";

	private static final String PROJECT = "Project";
	private static final String DOMAIN_LABEL = "Domain";
	private static final String PROBLEM_LABEL = "Problem";
	private static final String ID_LABEL = "Id";
	private static final String PLAN_FILE_NAMES_LABEL = "Plan files";
	private static final String PLANNER_NAME_LABEL = "Planner name";

	private static final String PLANNER_ARGUMENTS_LABEL = "Planner arguments";

	private static final String[] columnTitles = { PROJECT, DOMAIN_LABEL,
			PROBLEM_LABEL, ID_LABEL, PLAN_FILE_NAMES_LABEL, PLANNER_NAME_LABEL,
			PLANNER_ARGUMENTS_LABEL };

	public static final int NOT_ACTIVATE_VIEW_AFTER_DATA_UPDATE = 0;
	public static final int ACTIVATE_VIEW_AFTER_DATA_UPDATE = 1;
	private static boolean showViewAfterRefresh;
	private static int focusMode;

	private TableViewer viewer;
	private IAction clearSelectedPlanAction;
	private IAction clearAllPlansAction;
	private IAction openPlanFileInEdtiorAction;
	private IAction doubleClickAction;
	private IAction contextMenuGlobalDeleteAction;
	private IAction contextMenuGlobalRefreshAction;
	private IAction refreshAllProjectsAction;
	private IAction openPlanWorkingDirAction;
	private IAction openPlanFileInExternalEditor;

	/**
	 * The constructor.
	 */
	public PlanView() {

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	@SuppressWarnings("deprecation")
	public void createPartControl(Composite parent) {

		TableColumnLayout layout = new TableColumnLayout();
		parent.setLayout(layout);
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(layout, parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(new PlanViewContentProvider());

		ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);

		getSite().setSelectionProvider(viewer);

		// define layout for the viewer
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);

		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(viewer.getControl(),
						"pl.poznan.put.cs.gui4pddl.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();

		contextMenuGlobalDeleteAction = ActionFactory.DELETE
				.create(getViewSite().getWorkbenchWindow());
		contextMenuGlobalRefreshAction = ActionFactory.REFRESH
				.create(getViewSite().getWorkbenchWindow());

		IActionBars bars = getViewSite().getActionBars();
		bars.setGlobalActionHandler(IWorkbenchActionConstants.DELETE,
				clearSelectedPlanAction);
		bars.setGlobalActionHandler(IWorkbenchActionConstants.REFRESH,
				refreshAllProjectsAction);

		viewer.setInput(PlanViewDataManager.getManager());

	}

	private void createColumns(TableColumnLayout layout,
			final Composite parent, final TableViewer viewer) {

		TableViewerColumn col = createTableViewerColumn(layout,
				columnTitles[0], 0);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getProjectName();
			}
		});

		col = createTableViewerColumn(layout, columnTitles[1], 1);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getDomain();
			}
		});

		col = createTableViewerColumn(layout, columnTitles[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getProblem();
			}
		});

		col = createTableViewerColumn(layout, columnTitles[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getId();
			}
		});

		col = createTableViewerColumn(layout, columnTitles[4], 4);
		col.setLabelProvider(new StyledCellLabelProvider() {

			public int getToolTipDisplayDelayTime(Object object) {
				return 700;
			}

			public String getToolTipText(Object element) {
				PlanViewDataRow row = (PlanViewDataRow) element;
				List<String> files = row.getPlanFileNames();
				IFolder workingDir = row.getWorkingFolder();
				StringBuilder sb = new StringBuilder();
				if (files != null) {
					for (String file : files) {
						if (!workingDir.getFile(file).exists()) {
							sb.append(file + ", ");
						}
					}
				}
				if (sb.length() >= 2) {
					sb.delete(sb.length() - 2, sb.length());
				}

				return sb.length() > 0 ? "Files " + sb.toString()
						+ " don't exists"
						: "Double click the row to open files";
			}

			public void update(ViewerCell cell) {
				PlanViewDataRow row = (PlanViewDataRow) cell.getElement();
				StringBuilder sb = new StringBuilder();
				List<String> files = row.getPlanFileNames();
				IFolder workingDir = row.getWorkingFolder();
				List<StyleRange> styles = new ArrayList<StyleRange>();
				if (files != null) {
					if (files.size() > 1) {
						for (int i = 0; i < files.size() - 1; i++) {
							if (!workingDir.getFile(files.get(i)).exists()) {
								int begin = sb.length();
								sb.append(files.get(i) + ", ");
								int end = sb.length() - 2;
								StyleRange range = new StyleRange(begin, end
										- begin, Display.getCurrent()
										.getSystemColor(SWT.COLOR_RED), null);
								styles.add(range);
							} else {
								sb.append(files.get(i) + ", ");
							}
						}
					}
					if (files.size() > 0) {
						if (!workingDir.getFile(files.get(files.size() - 1))
								.exists()) {
							int begin = sb.length();
							sb.append(files.get(files.size() - 1));
							int end = sb.length();
							StyleRange range = new StyleRange(begin, end
									- begin, Display.getCurrent()
									.getSystemColor(SWT.COLOR_RED), null);
							styles.add(range);
						} else {
							sb.append(files.get(files.size() - 1));
						}
					}
				}
				cell.setText(sb.toString());
				if (files == null || files.size() == 0) {
					cell.setText("No plan files");
				}
				StyleRange[] range = styles.toArray(new StyleRange[0]);
				cell.setStyleRanges(range);
				super.update(cell);
			}

		});

		col = createTableViewerColumn(layout, columnTitles[5], 5);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getPlannerName();
			}

		});

		col = createTableViewerColumn(layout, columnTitles[6], 6);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewDataRow p = (PlanViewDataRow) element;
				return p.getPlannerArguments();
			}

		});
	}

	private TableViewerColumn createTableViewerColumn(TableColumnLayout layout,
			String title, final int colNumber) {

		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		layout.setColumnData(column, new ColumnWeightData(
				100 / columnTitles.length));
		column.setText(title);
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}

	private void makeActions() {

		clearSelectedPlanAction = new Action() {
			public void run() {
				clearSelectedPlans();
			}
		};
		clearSelectedPlanAction.setText(CLEAR_SELECTED_PLANS_TEXT);
		clearSelectedPlanAction.setToolTipText(CLEAR_SELECTED_PLANS_TOOLTIP);
		clearSelectedPlanAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		clearAllPlansAction = new Action() {
			public void run() {
				clearAllPlans();
			}
		};
		clearAllPlansAction.setText(CLEAR_ALL_FINISHED_PLANS_TEXT);
		clearAllPlansAction.setToolTipText(CLEAR_ALL_FINISHED_PLANS_TOOLTIP);
		clearAllPlansAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

		refreshAllProjectsAction = new Action() {
			public void run() {
				refreshAllProjectsFromPlanView();
			}
		};

		openPlanWorkingDirAction = new Action() {
			public void run() {
				openPlansFolder();
			}
		};
		openPlanWorkingDirAction.setText(OPEN_PLAN_WORKING_DIR_TEXT);
		openPlanWorkingDirAction.setToolTipText(OPEN_PLAN_WORKING_DIR_TOOLTIP);
		openPlanWorkingDirAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER));

		openPlanFileInExternalEditor = new Action() {
			public void run() {
				openSelectedPlanFiles(true);
			}
		};
		openPlanFileInExternalEditor
				.setText(OPEN_PLANS_IN_EXTERNAL_EDITOR_TEXT);
		openPlanFileInExternalEditor
				.setToolTipText(OPEN_PLANS_IN_EXTERNAL_EDITOR_TOOLTIP);

		openPlanFileInEdtiorAction = new Action() {
			public void run() {
				openSelectedPlanFiles(false);
			}
		};
		openPlanFileInEdtiorAction.setText(OPEN_READY_PLANS_IN_EDITOR_TEXT);
		openPlanFileInEdtiorAction
				.setToolTipText(OPEN_READY_PLANS_IN_EDITOR_TOOLTIP);
		openPlanFileInEdtiorAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));

		doubleClickAction = new Action() {
			public void run() {
				openSelectedPlanFiles(false);
			}
		};

		openPlanFileInEdtiorAction.setEnabled(false);
		clearSelectedPlanAction.setEnabled(false);
		openPlanWorkingDirAction.setEnabled(false);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				setActionsDisabledDependsOnStatus(selection);

			}
		});
	}

	private void clearSelectedPlans() {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		if (selection.size() > 0) {
			PlanViewDataRow[] input = Arrays.copyOf(selection.toArray(),
					selection.toArray().length, PlanViewDataRow[].class);
			if (removeConfirmDialog()) {
				removePlansFoldersAndRowsFromListAsBackgroundJob(input);
			}
		}
	}

	private boolean removeConfirmDialog() {
		return MessageDialog.openConfirm(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), "Remove plans",
				"This operation cannot be undone. Are you sure?");
	}

	private void removePlansFoldersAndRowsFromListAsBackgroundJob(
			final PlanViewDataRow[] input) {
		Job job = new Job("Removing Plans") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Removing plans", 10000);
				for (PlanViewDataRow row : input) {
					try {
						if (row.getWorkingFolder() != null
								&& row.getWorkingFolder().exists()) {
							row.getWorkingFolder().refreshLocal(
									IResource.DEPTH_INFINITE, monitor);
							row.getWorkingFolder().delete(true, true, monitor);
						}
						PlanViewDataManager.getManager().removePlanViewDataRow(
								row);

					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					monitor.worked(10000 / (input.length));
				}

				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();

	}

	private void clearAllPlans() {
		PlanViewDataManager input = (PlanViewDataManager) viewer.getInput();
		List<PlanViewDataRow> list = input.getPlanViewDataRows();
		if (removeConfirmDialog()) {
			removePlansFoldersAndRowsFromListAsBackgroundJob(list
					.toArray(new PlanViewDataRow[0]));
		}
	}

	private void refreshAllProjectsFromPlanView() {
		Job job = new Job("Refresh all projects") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {

				List<PlanViewDataRow> list = PlanViewDataManager.getManager()
						.getPlanViewDataRows();
				List<PlanViewDataRow> toRemove = new ArrayList<PlanViewDataRow>();
				monitor.beginTask("Refresh all projects", 100);
				for (PlanViewDataRow row : list) {
					try {
						monitor.subTask("Refreshing " + row.getProjectName());
						row.getWorkingFolder().refreshLocal(
								IResource.DEPTH_INFINITE, monitor);
						if (!row.getWorkingFolder().exists()) {
							toRemove.add(row);
						}
					} catch (CoreException e) {
						Log.log("Error while refreshing projects", e);
					}
					monitor.worked(100 / list.size());
				}
				PlanViewDataManager.getManager().removePlanViewDataRows(
						toRemove);

				monitor.done();
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						refresh();
					}
				});
				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	private void openPlansFolder() {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		if (selection.size() > 0) {
			for (Object o : selection.toArray()) {
				PlanViewDataRow row = (PlanViewDataRow) o;
				File file = row.getWorkingFolder().getRawLocation().toFile();
				if (file.exists() && file.isDirectory()) {
					DesktopApi.open(file);
				} else {
					infoDialog("Opening folder", "There is no such folder "
							+ row.getWorkingFolder().getFullPath().toOSString()
							+ " in the file system. Refresh Plan Browser.");
				}
			}
		}
	}

	private void infoDialog(String title, String text) {
		MessageDialog.openInformation(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), title, text);
	}

	private void openSelectedPlanFiles(boolean externalEditor) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Iterator<?> itr = selection.iterator();
		while (itr.hasNext()) {
			PlanViewDataRow pvdr = (PlanViewDataRow) itr.next();
			List<String> files = pvdr.getPlanFileNames();
			if (files != null) {
				if (files.size() == 1) {
					IFile file = pvdr.getWorkingFolder().getFile(files.get(0));
					if (file.exists()) {
						if (externalEditor) {
							openExistingFileInExternalEditor(file);
						} else {
							openFileInDefaultEditor(file);
						}
					} else {
						infoDialog("Opening plan file",
								"This file (" + file.getFullPath()
										+ ") does not exist.");
					}
				} else if (files.size() > 1) {
					selectFilesAndOpenInEditor(files, pvdr.getProjectName(),
							pvdr.getDomain(), pvdr.getProblem(), pvdr.getId(),
							pvdr.getWorkingFolder(), externalEditor);

				} else if (files.size() == 0) {
					infoDialog("Opening plan file",
							"There is no plan files to open.");
				}
			} else {
				infoDialog("Opening plan file",
						"There is no plan files to open.");
			}
		}
	}

	private void openExistingFileInExternalEditor(IFile file) {
		File f = file.getRawLocation().toFile();
		if (f.exists() && f.isFile()) {
			DesktopApi.open(f);
		} else {
			infoDialog("Opening plan file", "This file ( "
					+ file.getFullPath().toOSString()
					+ ") does not exist. Refresh Plan Browser.");
		}
	}

	private void openFileInDefaultEditor(IFile file) {
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		try {
			IDE.openEditor(page, file);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void selectFilesAndOpenInEditor(List<String> files, String project,
			String domain, String problem, String id, IFolder workingDir,
			boolean externalEditor) {
		List<IFile> ifileList = new ArrayList<IFile>();
		for (String fileName : files) {
			IFile f = workingDir.getFile(fileName);
			if (f.exists())
				ifileList.add(f);
		}

		if (ifileList.size() > 0) {
			Object[] toOpen = getSelectionDialogResult(
					ifileList.toArray(new IFile[0]), "Pick a plan file",
					"Choose a plan file to open.\n" + "Project: " + project
							+ "\nDomain: " + domain + "\nProblem: " + problem
							+ "\nId: " + id);
			IFile[] toOpenFiles = Arrays.copyOf(toOpen, toOpen.length,
					IFile[].class);
			if (externalEditor) {
				for (IFile f : toOpenFiles) {
					openExistingFileInExternalEditor(f);
				}
			} else {
				openFilesInDefaultEditor(toOpenFiles);
			}
		} else {
			infoDialog("Opening plan file",
					"There is no existing plan files in "
							+ workingDir.getFullPath().toOSString() + " folder");
		}
	}

	private Object[] getSelectionDialogResult(Object[] elements, String title,
			String message) {
		final ILabelProvider labelProvider = DebugUITools
				.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				Display.getDefault().getActiveShell(), new ILabelProvider() {
					public Image getImage(Object element) {
						return labelProvider.getImage(element);
					}

					public String getText(Object element) {
						return labelProvider.getText(element);
					}

					public boolean isLabelProperty(Object element,
							String property) {
						return labelProvider.isLabelProperty(element, property);
					}

					public void addListener(ILabelProviderListener listener) {
						labelProvider.addListener(listener);
					}

					public void removeListener(ILabelProviderListener listener) {
						labelProvider.removeListener(listener);
					}

					public void dispose() {
						labelProvider.dispose();
					}
				});
		dialog.setElements(elements);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setMultipleSelection(true);
		int result = dialog.open();
		labelProvider.dispose();
		if (result == Window.OK) {
			return dialog.getResult();
		}
		return null;
	}

	private void openFilesInDefaultEditor(IFile[] files) {
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		try {
			IDE.openEditors(page, files);
		} catch (MultiPartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setActionsDisabledDependsOnStatus(
			IStructuredSelection selection) {
		if (selection.size() > 0) {
			openPlanFileInEdtiorAction.setEnabled(true);
			clearSelectedPlanAction.setEnabled(true);
			openPlanWorkingDirAction.setEnabled(true);
		} else {
			openPlanFileInEdtiorAction.setEnabled(false);
			clearSelectedPlanAction.setEnabled(false);
			openPlanWorkingDirAction.setEnabled(false);
		}
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(openPlanFileInEdtiorAction);
		manager.add(contextMenuGlobalDeleteAction);
		manager.add(new Separator());
		manager.add(clearAllPlansAction);
		manager.add(openPlanWorkingDirAction);
		manager.add(openPlanFileInExternalEditor);
		manager.add(new Separator());
		manager.add(contextMenuGlobalRefreshAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		for (TableColumn tableColumn : viewer.getTable().getColumns()) {
			createShowHideColumnAction(tableColumn, manager, viewer);
		}
	}

	private void createShowHideColumnAction(final TableColumn column,
			IMenuManager manager, final TableViewer viewer) {

		Action action = new Action(column.getText(), IAction.AS_CHECK_BOX) {
			public void run() {
				if (isChecked()) {
					column.setWidth(viewer.getTable().getSize().x
							/ columnTitles.length);
					column.setResizable(true);
				} else {
					column.setWidth(0);
					column.setResizable(false);
				}
			}
		};
		action.setChecked(true);
		manager.add(action);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(openPlanFileInEdtiorAction);
		manager.add(openPlanWorkingDirAction);
		manager.add(clearSelectedPlanAction);
		manager.add(clearAllPlansAction);
	}

	public static void createRowAndActivateView(ILaunchConfiguration config,
			IFolder workingDir) {

		try {
			PlanViewDataRow planViewRowData = null;
			String domainAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							Constants.DOMAIN_FILE, ""));

			String problemAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							Constants.PROBLEM_FILE, ""));

			String regexp = config.getAttribute(
					Constants.FILE_NAME_REGEXP, "");

			List<String> planFiles = FileNameRegexProcessor
					.getMatchedFilesNames(regexp, workingDir.getRawLocation()
							.toFile(), config);

			planViewRowData = new PlanViewDataRow(
					config.getAttribute(Constants.PROJECT, ""),
					ProjectFilesPathsHelpers
							.getPDDLFileNameWithoutExtension(domainAbsolutePath),
					ProjectFilesPathsHelpers
							.getPDDLFileNameWithoutExtension(problemAbsolutePath),
					workingDir.getName(), config.getAttribute(
							Constants.PLANNER_NAME, ""),
					domainAbsolutePath, problemAbsolutePath, planFiles, config
							.getAttribute(Constants.ARGUMENTS_NAME, ""));
			PlanViewDataManager.getManager()
					.addPlanViewDataRow(planViewRowData);
			activateView();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void refreshView() {
	 * PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() { public
	 * void run() { IViewPart foundView = PlatformUI.getWorkbench()
	 * .getActiveWorkbenchWindow().getActivePage() .findView(ID); PlanView
	 * thisView = (PlanView) foundView; if (thisView != null)
	 * thisView.refresh();
	 * 
	 * } }); }
	 */

	private void refresh() {
		if (viewer != null)
			viewer.refresh();
	}

	private static void activateView() {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					if (showViewAfterRefresh) {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().showView(ID, null, focusMode);
					}
				} catch (PartInitException e) { // TODO Auto-generated catch
												// block
					e.printStackTrace();
				}
			}
		});
	}

	public static synchronized void setActivateMode(int mode) {
		if (mode == NOT_ACTIVATE_VIEW_AFTER_DATA_UPDATE) {
			showViewAfterRefresh = false;
			focusMode = IWorkbenchPage.VIEW_VISIBLE;
		} else if (mode == ACTIVATE_VIEW_AFTER_DATA_UPDATE) {
			showViewAfterRefresh = true;
			focusMode = IWorkbenchPage.VIEW_ACTIVATE;
		} else {
			Log.log("There is no such refresh mode");
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}