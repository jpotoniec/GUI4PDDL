package pl.poznan.put.cs.gui4pddl.planview.ui;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.*;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewData;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataProvider;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class PlanView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "pl.poznan.put.cs.gui4pddl.views.PlanView";

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
			PlanViewData p = (PlanViewData) element;
			if (p.getStatus() == PlanViewData.Status.RUNNING) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
			} else if (p.getStatus() == PlanViewData.Status.OK) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
			} else if (p.getStatus() == PlanViewData.Status.WRONG) {

				color = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
			}
			
			IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
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
		// get the content for the viewer, setInput will call getElements in the
		// contentProvider
		// viewer.setInput(PlanViewModelProvider.getPlanViewModel());
		// make the selection available to other views

		getSite().setSelectionProvider(viewer);
		// set the sorter for the table

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

	public static int updatePlanViewBeforePlanningProcess(
			ILaunchConfiguration configuration, File workingDir) {
		final PlanViewDataProvider dataProvider = PlanViewDataProvider
				.getInstance();
		int index = dataProvider.addPlanViewDataOfRunningProcess(configuration,
				workingDir);
		setData(dataProvider);
		return index;
	}

	public static void updatePlanViewAfterPlanningProcess(
			ILaunchConfiguration configuration, File workingDir,
			int insertedRowIndex) {
		final PlanViewDataProvider dataProvider = PlanViewDataProvider
				.getInstance();
		dataProvider.setPlanFilesPathsAndMarkAsEnded(configuration, workingDir,
				insertedRowIndex);
		setData(dataProvider);
	}

	private static void setData(final PlanViewDataProvider dataProvider) {
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

	private void setInput(List<PlanViewData> list) {
		viewer.setInput(list);
	}

	// create the columns for the table
	private void createColumns(TableColumnLayout layout,
			final Composite parent, final TableViewer viewer) {
		String[] titles = { PROJECT, DOMAIN_LABEL, PROBLEM_LABEL, ID_LABEL,
				STATUS_LABEL, PLANNER_ARGUMENTS_LABEL };

		TableViewerColumn col = createTableViewerColumn(layout, titles[0], 0);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewData p = (PlanViewData) element;
				return p.getProjectName();
			}
		});

		col = createTableViewerColumn(layout, titles[1], 1);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewData p = (PlanViewData) element;
				return p.getDomain();
			}
		});

		// second column is for the last name
		col = createTableViewerColumn(layout, titles[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewData p = (PlanViewData) element;
				return p.getProblem();
			}
		});

		// now the gender
		col = createTableViewerColumn(layout, titles[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewData p = (PlanViewData) element;
				return p.getId();
			}
		});

		// now the status married
		col = createTableViewerColumn(layout, titles[4], 4);
		col.setLabelProvider(new ColorStatusColumnLabelProvider());

		col = createTableViewerColumn(layout, titles[5], 5);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewData p = (PlanViewData) element;
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

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		// fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(clearSelectedPlanAction);
		manager.add(new Separator());
		manager.add(clearAllPlansAction);
		manager.add(openPlanInEdtiorAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(clearSelectedPlanAction);
		manager.add(openPlanInEdtiorAction);
		manager.add(new Separator());
		manager.add(clearAllPlansAction);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(clearSelectedPlanAction);
		manager.add(clearAllPlansAction);
		manager.add(openPlanInEdtiorAction);
	}

	private void makeActions() {
		clearSelectedPlanAction = new Action() {
			public void run() {
				showMessage("Clear selected plan executed");
			}
		};

		clearSelectedPlanAction.setText("Clear selected finished plan");
		clearSelectedPlanAction
				.setToolTipText("Clear selected finished plan tooltip");
		clearSelectedPlanAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		clearAllPlansAction = new Action() {
			public void run() {
				showMessage("Clear all plans executed");
			}
		};
		clearAllPlansAction.setText("Clear all finished plans");
		clearAllPlansAction.setToolTipText("Clear all finished plans tooltip");
		clearAllPlansAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		openPlanInEdtiorAction = new Action() {
			public void run() {
				showMessage("Open OK plans in editor executed");
			}
		};
		openPlanInEdtiorAction.setText("Open OK plans in editor");
		openPlanInEdtiorAction
				.setToolTipText("Open OK plans in editor tooltip");
		openPlanInEdtiorAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
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
	
	private void setActionsDisabledDependsOnStatus(IStructuredSelection selection) {
		
		openPlanInEdtiorAction.setEnabled(true);
		clearSelectedPlanAction.setEnabled(true);

		int okStatus = 0;
		int wrongStatus = 0;
		int runningStatus = 0;

		PlanViewData rows[] = Arrays.copyOf(selection.toArray(), selection.toArray().length, PlanViewData[].class);
		for (PlanViewData row : rows) {
			if (row.getStatus() == PlanViewData.Status.RUNNING) {
				runningStatus++;
			} else if (row.getStatus() == PlanViewData.Status.WRONG) {
				wrongStatus++;
			} else if (row.getStatus() == PlanViewData.Status.OK) {
				okStatus++;
			}
		}

		if ((wrongStatus + runningStatus) == rows.length) {
			openPlanInEdtiorAction.setEnabled(false);
		}
		if ((runningStatus) == rows.length) {
			clearSelectedPlanAction.setEnabled(false);
		}
	}
	

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(), "Plan",
				message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}