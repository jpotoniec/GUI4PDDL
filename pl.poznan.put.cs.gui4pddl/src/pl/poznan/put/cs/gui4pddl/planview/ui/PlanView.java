package pl.poznan.put.cs.gui4pddl.planview.ui;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewModel;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewModelProvider;

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
		//viewer.setInput(PlanViewModelProvider.getPlanViewModel());
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
	
	public void setInput(List<PlanViewModel> list) {
		viewer.setInput(list);
	}

	// create the columns for the table
	private void createColumns(TableColumnLayout layout,
			final Composite parent, final TableViewer viewer) {
		String[] titles = { DOMAIN_LABEL, PROBLEM_LABEL, ID_LABEL,
				STATUS_LABEL, PLANNER_ARGUMENTS_LABEL };

		// first column is for the first name
		TableViewerColumn col = createTableViewerColumn(layout, titles[0], 0);

		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewModel p = (PlanViewModel) element;
				System.out.println("DOMAIN " + p.getDomain());
				return p.getDomain();
			}
		});

		// second column is for the last name
		col = createTableViewerColumn(layout, titles[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewModel p = (PlanViewModel) element;
				return p.getProblem();
			}
		});

		// now the gender
		col = createTableViewerColumn(layout, titles[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				PlanViewModel p = (PlanViewModel) element;
				return p.getId();
			}
		});

		// now the status married
		col = createTableViewerColumn(layout, titles[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewModel p = (PlanViewModel) element;
				return p.getStatus().toString();
			}

		});

		col = createTableViewerColumn(layout, titles[4], 4);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PlanViewModel p = (PlanViewModel) element;
				return p.getPlannerArguments();
			}

		});

	}

	private TableViewerColumn createTableViewerColumn(TableColumnLayout layout,
			String title, final int colNumber) {
		
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		layout.setColumnData(column, new ColumnWeightData(20));
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
		clearSelectedPlanAction.setText("Clear selected plan");
		clearSelectedPlanAction.setToolTipText("Clear selected plan tooltip");
		clearSelectedPlanAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		clearAllPlansAction = new Action() {
			public void run() {
				showMessage("Clear all plans executed");
			}
		};
		clearAllPlansAction.setText("Clear all plans");
		clearAllPlansAction.setToolTipText("Clear all plans tooltip");
		clearAllPlansAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		openPlanInEdtiorAction = new Action() {
			public void run() {
				showMessage("Open plan in editor executed");
			}
		};
		openPlanInEdtiorAction.setText("Open plan in editor");
		openPlanInEdtiorAction.setToolTipText("Open plan in editor tooltip");
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