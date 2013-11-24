package pl.poznan.put.cs.gui4pddl.planview.ui;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataProvider;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewRowData;

public class PlanView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "pl.poznan.put.cs.gui4pddl.views.PlanView";

	private static final String CLEAR_SELECTED_PLANS_TEXT = "Clear selected finished plans";
	private static final String CLEAR_SELECTED_PLANS_TOOLTIP = "Clear selected finished plans";
	private static final String CLEAR_ALL_FINISHED_PLANS_TEXT = "Clear all finished plans";
	private static final String CLEAR_ALL_FINISHED_PLANS_TOOLTIP = "Clear all finished plans";
	private static final String OPEN_READY_PLANS_IN_EDITOR_TEXT = "Open an existing plan in the editor";
	private static final String OPEN_READY_PLANS_IN_EDITOR_TOOLTIP = "Open an existing plan in the editor";

	private static final String PROJECT = "Project";
	private static final String DOMAIN_LABEL = "Domain";
	private static final String PROBLEM_LABEL = "Problem";
	private static final String ID_LABEL = "Id";
	private static final String STATUS_LABEL = "Status";
	private static final String PLANNER_ARGUMENTS_LABEL = "Planner arguments";

	private TableViewer viewer;
	private Action clearSelectedPlanAction;
	private Action clearAllPlansAction;
	private Action openPlanInEdtiorAction;
	private Action doubleClickAction;

	public class ColorStatusColumnLabelProvider extends ColumnLabelProvider
			implements IColorProvider {

		private Color color;

		@Override
		public Color getBackground(Object element) {
			return null;
		}

		@Override
		public Color getForeground(Object element) {
			return color;
		}

		@Override
		public String getText(Object element) {
			PlanViewRowData p = (PlanViewRowData) element;
			if (p.getStatus() == PlanViewRowData.Status.RUNNING) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
			} else if (p.getStatus() == PlanViewRowData.Status.OK) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
			} else if (p.getStatus() == PlanViewRowData.Status.WRONG) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
			}

			IStructuredSelection selection = (IStructuredSelection) viewer
					.getSelection();
			setActionsDisabledDependsOnStatus(selection);

			return p.getStatus().toString();
		}

	}

	/**
	 * The constructor.
	 */
	public PlanView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		TableColumnLayout layout = new TableColumnLayout();
		parent.setLayout(layout);
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		createColumns(layout, parent, viewer);
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());

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
	}

	private void createColumns(TableColumnLayout layout,
			final Composite parent, final TableViewer viewer) {
		String[] titles = { PROJECT, DOMAIN_LABEL, PROBLEM_LABEL, ID_LABEL,
				STATUS_LABEL, PLANNER_ARGUMENTS_LABEL };

		TableViewerColumn col = createTableViewerColumn(layout, titles[0], 0);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewRowData p = (PlanViewRowData) element;
				return p.getProjectName();
			}
		});

		col = createTableViewerColumn(layout, titles[1], 1);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewRowData p = (PlanViewRowData) element;
				return p.getDomain();
			}
		});

		col = createTableViewerColumn(layout, titles[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewRowData p = (PlanViewRowData) element;
				return p.getProblem();
			}
		});

		col = createTableViewerColumn(layout, titles[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewRowData p = (PlanViewRowData) element;
				return p.getId();
			}
		});

		col = createTableViewerColumn(layout, titles[4], 4);
		col.setLabelProvider(new ColorStatusColumnLabelProvider());

		col = createTableViewerColumn(layout, titles[5], 5);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewRowData p = (PlanViewRowData) element;
				return p.getPlannerArguments();
			}

		});
	}

	private TableViewerColumn createTableViewerColumn(TableColumnLayout layout,
			String title, final int colNumber) {

		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		layout.setColumnData(column, new ColumnWeightData(100 / 6));
		column.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				if (column.getWidth() < 5)
					column.setWidth(5);
			}
		});
		column.setText(title);
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}

	private void makeActions() {
		clearSelectedPlanAction = new Action() {
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				PlanViewRowData[] input = Arrays.copyOf(selection.toArray(),
						selection.toArray().length, PlanViewRowData[].class);
				if (MessageDialog.openConfirm(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						CLEAR_SELECTED_PLANS_TEXT,
						"This operation cannot be undone. Are you sure?")) {
					removeNotRunningRows(input);
				}
			}
		};
		clearSelectedPlanAction.setText(CLEAR_SELECTED_PLANS_TEXT);
		clearSelectedPlanAction.setToolTipText(CLEAR_SELECTED_PLANS_TOOLTIP);
		clearSelectedPlanAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVE));

		clearAllPlansAction = new Action() {
			public void run() {
				@SuppressWarnings("unchecked")
				Vector<PlanViewRowData> input = (Vector<PlanViewRowData>) viewer
						.getInput();
				if (MessageDialog.openConfirm(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						CLEAR_ALL_FINISHED_PLANS_TEXT,
						"This operation cannot be undone. Are you sure?")) {
					removeNotRunningRows(input.toArray(new PlanViewRowData[0]));
				}
			}
		};
		clearAllPlansAction.setText(CLEAR_ALL_FINISHED_PLANS_TEXT);
		clearAllPlansAction.setToolTipText(CLEAR_ALL_FINISHED_PLANS_TOOLTIP);
		clearAllPlansAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ELCL_REMOVEALL));

		openPlanInEdtiorAction = new Action() {
			public void run() {
				openSelectedPlanFiles();
			}
		};
		openPlanInEdtiorAction.setText(OPEN_READY_PLANS_IN_EDITOR_TEXT);
		openPlanInEdtiorAction
				.setToolTipText(OPEN_READY_PLANS_IN_EDITOR_TOOLTIP);
		openPlanInEdtiorAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FILE));

		doubleClickAction = new Action() {
			public void run() {
				openSelectedPlanFiles();
			}
		};

		openPlanInEdtiorAction.setEnabled(false);
		clearSelectedPlanAction.setEnabled(false);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				setActionsDisabledDependsOnStatus(selection);

			}
		});
	}

	private void removeNotRunningRows(PlanViewRowData[] input) {
		Vector<PlanViewRowData> notRunning = new Vector<PlanViewRowData>();

		for (PlanViewRowData row : input) {
			if (row.getStatus() != PlanViewRowData.Status.RUNNING) {
				notRunning.add(row);
				if (row.getPlanFilePath() != null) {
					deleteFile(new File(row.getPlanFilePath()));
				}
				
				Activator.refreshProject(row.getProjectName());
			}
		}

		PlanViewDataProvider dataProvider = PlanViewDataProvider.getInstance();
		dataProvider.getPlanViewDataList().removeAll(notRunning);
		PlanViewDataProvider.savePlanBrowserData();
		setData(dataProvider);
		deleteEmptyDirs(notRunning);
	}


	private boolean deleteFile(File file) {
		if (file.exists() && file.isFile()) {
			return file.delete();
		}
		return false;
	}
	
	private void deleteEmptyDirs(Vector<PlanViewRowData> notRunning) {

		PlanViewDataProvider dataProvider = PlanViewDataProvider.getInstance();
		for (PlanViewRowData external : notRunning) {
			boolean deleteDir = true;
			for (PlanViewRowData internal : dataProvider.getPlanViewDataList()) {
				if (external.getProjectName().equals(internal.getProjectName())
						&& external.getDomain().equals(internal.getDomain())
						&& external.getProblem().equals(internal.getProblem())
						&& external.getId().equals(internal.getId())) {
					deleteDir = false;
				}
			}
			if (deleteDir) {
				deleteDir(new File(external.getWorkingDirPath()));
				Activator.refreshProject(external.getProjectName());
			}
		}
	}

	private boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		return dir.delete(); // The directory is empty now and can be deleted.
	}

	private void openSelectedPlanFiles() {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Iterator<?> itr = selection.iterator();
		while (itr.hasNext()) {
			PlanViewRowData pvd = (PlanViewRowData) itr.next();
			if (pvd.getPlanFilePath() != null) {
				File fileToOpen = new File(pvd.getPlanFilePath());
				if (fileToOpen.exists() && fileToOpen.isFile()) {
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(
							fileToOpen.toURI());
					IWorkbenchPage page = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();
					try {
						IDE.openEditorOnFileStore(page, fileStore);
					} catch (PartInitException e) {
						// Put your exception handler here if you wish to
					}
				} else {
					refreshPlanView();
				}
			} else {
				refreshPlanView();
			}
		}
	}

	public static void refreshPlanView() {
		PlanViewDataProvider dataProvider = PlanViewDataProvider.getInstance();
		dataProvider.refreshPlanBrowserData();
		setData(dataProvider);
		PlanViewDataProvider.savePlanBrowserData();
	}

	private void setActionsDisabledDependsOnStatus(
			IStructuredSelection selection) {

		openPlanInEdtiorAction.setEnabled(true);
		clearSelectedPlanAction.setEnabled(true);

		int wrongStatus = 0;
		int runningStatus = 0;

		PlanViewRowData rows[] = Arrays.copyOf(selection.toArray(),
				selection.toArray().length, PlanViewRowData[].class);
		for (PlanViewRowData row : rows) {
			if (row.getStatus() == PlanViewRowData.Status.RUNNING) {
				runningStatus++;
			} else if (row.getStatus() == PlanViewRowData.Status.WRONG) {
				wrongStatus++;
			}
		}

		if ((wrongStatus + runningStatus) == rows.length) {
			openPlanInEdtiorAction.setEnabled(false);
		}
		if ((runningStatus) == rows.length) {
			clearSelectedPlanAction.setEnabled(false);
		}
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				PlanView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(openPlanInEdtiorAction);
		manager.add(clearSelectedPlanAction);
		manager.add(new Separator());
		manager.add(clearAllPlansAction);
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
		// fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	/*
	 * private void fillLocalPullDown(IMenuManager manager) {
	 * manager.add(clearSelectedPlanAction); manager.add(new Separator());
	 * manager.add(clearAllPlansAction); manager.add(openPlanInEdtiorAction); }
	 */

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(openPlanInEdtiorAction);
		manager.add(clearSelectedPlanAction);
		manager.add(clearAllPlansAction);
	}

	public static PlanViewRowData updatePlanViewBeforePlanningProcess(
			ILaunchConfiguration configuration, File workingDir) {
		final PlanViewDataProvider dataProvider = PlanViewDataProvider
				.getInstance();
		PlanViewRowData pvd = dataProvider.addPlanViewDataOfRunningProcess(
				configuration, workingDir);
		setData(dataProvider);
		return pvd;
	}

	public static void updatePlanViewAfterPlanningProcess(
			ILaunchConfiguration configuration, File workingDir,
			PlanViewRowData pvd) {
		final PlanViewDataProvider dataProvider = PlanViewDataProvider
				.getInstance();
		dataProvider.setPlanFilesPathsAndMarkAsEnded(configuration, workingDir,
				pvd);
		setData(dataProvider);
	}

	public static void setData(final PlanViewDataProvider dataProvider) {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					PlanView view = (PlanView) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.showView(ID);
					view.setInput(dataProvider.getPlanViewDataList());
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	private void setInput(List<PlanViewRowData> list) {
		viewer.setInput(list);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}