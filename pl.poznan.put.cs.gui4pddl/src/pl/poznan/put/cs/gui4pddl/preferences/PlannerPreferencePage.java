package pl.poznan.put.cs.gui4pddl.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.helpers.PlannerPreferencesStore;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.ui.PlannerPreferencesPageTab;

public class PlannerPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Button newPlannerButton;
	
	private List<PlannerPreferencesPageTab> tabsList;

	public PlannerPreferencePage() {
		noDefaultAndApplyButton();
		tabsList = new ArrayList<PlannerPreferencesPageTab>();
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

		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		newPlannerButton = new Button(composite, SWT.PUSH);
		newPlannerButton.setText("New Planner");
		GridData buttonGrid = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		buttonGrid.horizontalSpan = 1;
		newPlannerButton.setLayoutData(buttonGrid);

	

		final TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		GridData tabFolderGrid = new GridData(GridData.FILL_BOTH);
		tabFolderGrid.horizontalSpan = 3;
		tabFolder.setLayoutData(tabFolderGrid);

		addPlannersFromPreferencesList(tabFolder);

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == newPlannerButton) {

					tabFolder.setSelection(addPlannerTab(tabFolder));

				} }};
		newPlannerButton.addListener(SWT.Selection, listener);
		
		


		return composite;
	}

	private TabItem addPlannerTab(final TabFolder tabFolder) {

		TabItem item = new TabItem(tabFolder, SWT.NULL);
		item.setText("New Planner " + tabFolder.getItemCount());

		Composite tabFolderComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout tabFolderGridLayout = new GridLayout();
		tabFolderGridLayout.numColumns = 3;
		tabFolderComposite.setLayout(tabFolderGridLayout);
		tabFolderComposite
				.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		PlannerPreferences preferences = new PlannerPreferences(item.getText(),
				"", null);
		final PlannerPreferencesPageTab argumentsComponent = new PlannerPreferencesPageTab(
				tabFolderComposite, preferences, this, tabFolder, SWT.BORDER);
				
		
		tabsList.add(argumentsComponent);

		item.setControl(tabFolderComposite);

		return item;

	}

	private void addPlannersFromPreferencesList(final TabFolder tabFolder) {
		for (String key : PlannerPreferencesStore.getPlannerPreferences().keySet()) {
			PlannerPreferences preferences = PlannerPreferencesStore.getPlannerPreferences()
					.get(key);

			TabItem item = new TabItem(tabFolder, SWT.NULL);
			item.setText(preferences.getPlannerName());
			Composite tabFolderComposite = new Composite(tabFolder, SWT.NONE);
			GridLayout tabFolderGridLayout = new GridLayout();
			tabFolderGridLayout.numColumns = 3;
			tabFolderComposite.setLayout(tabFolderGridLayout);
			tabFolderComposite.setLayoutData(new GridData(
					GridData.FILL_HORIZONTAL));

			final PlannerPreferencesPageTab argumentsComponent = new PlannerPreferencesPageTab(
					tabFolderComposite, preferences, this, tabFolder, SWT.BORDER); 
			
			
			tabsList.add(argumentsComponent);
			item.setControl(tabFolderComposite);
		}

	}

	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub

	}

}
