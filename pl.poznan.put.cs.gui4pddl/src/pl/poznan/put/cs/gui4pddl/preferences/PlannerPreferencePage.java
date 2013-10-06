package pl.poznan.put.cs.gui4pddl.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.preferences.helpers.PlannerPreferencesStore;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.ui.PlannerPreferencesPageTabItem;

public class PlannerPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Button newPlannerButton;

	private List<PlannerPreferencesPageTabItem> tabsList;

	public PlannerPreferencePage() {
		noDefaultAndApplyButton();
		tabsList = new ArrayList<PlannerPreferencesPageTabItem>();
	}

	public String getTitle() {
		return "PDDL Planners";
	}

	@Override
	public boolean performOk() {

		return super.performOk();
	}

	@Override
	protected Control createContents(Composite parent) {

		Composite pageComposite = createPageComposite(parent);
		newPlannerButton = createNewPlannerButton(pageComposite);
		final TabFolder plannerTabFolder = createPlannerTabFolder(pageComposite);

		addPlannersToTabFolder(plannerTabFolder);

		newPlannerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				addPlannerTab(plannerTabFolder);
				plannerTabFolder.setSelection(plannerTabFolder.getItemCount() - 1);
			}

		});
		
		// refresh save button while tab selection
		plannerTabFolder.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (tabsList.size() > plannerTabFolder.getSelectionIndex()) {
					tabsList.get(plannerTabFolder.getSelectionIndex())
					.setSavePlannerButtonEnabledIfConfigurationValid();
				}
				
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		return pageComposite;
	}

	private Composite createPageComposite(Composite parent) {
		Composite pageComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		pageComposite.setLayout(gridLayout);
		pageComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return pageComposite;
	}

	private Button createNewPlannerButton(Composite parent) {
		Button newPlannerButton = new Button(parent, SWT.PUSH);
		newPlannerButton.setText("New Planner");
		GridData buttonGrid = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonGrid.horizontalSpan = 1;
		newPlannerButton.setLayoutData(buttonGrid);
		return newPlannerButton;
	}

	private TabFolder createPlannerTabFolder(Composite parent) {
		final TabFolder tabFolder = new TabFolder(parent, SWT.NONE);
		GridData tabFolderGrid = new GridData(GridData.FILL_BOTH);
		tabFolderGrid.horizontalSpan = 3;
		tabFolder.setLayoutData(tabFolderGrid);

		//tabFolder.setVisible(false);
		return tabFolder;
	}

	private void addPlannerTab(final TabFolder tabFolder) {
		tabFolder.setVisible(true);

		PlannerPreferences preferences = new PlannerPreferences("New Planner "
				+ (tabFolder.getItemCount() + 1), "", null);

		PlannerPreferencesPageTabItem plannerPreferencesPageTab = new PlannerPreferencesPageTabItem(
				preferences, this, tabFolder);
		
		plannerPreferencesPageTab.setSavePlannerButtonEnabledIfConfigurationValid();

		tabsList.add(plannerPreferencesPageTab);
	}

	private void addPlannersToTabFolder(final TabFolder tabFolder) {
		for (String key : PlannerPreferencesStore.getPlannerPreferences()
				.keySet()) {
			PlannerPreferences preferences = PlannerPreferencesStore
					.getPlannerPreferences().get(key);

			PlannerPreferencesPageTabItem plannerPreferencesPageTab = new PlannerPreferencesPageTabItem(
					preferences, this, tabFolder);
			
			plannerPreferencesPageTab.setSavePlannerButtonEnabledIfConfigurationValid();

			tabsList.add(plannerPreferencesPageTab);

		}
		tabFolder.setVisible(PlannerPreferencesStore.getPlannerPreferences()
				.size() > 0);

	}

	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub

	}

}
