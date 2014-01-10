package pl.poznan.put.cs.gui4pddl.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;
import pl.poznan.put.cs.gui4pddl.preferences.ui.PlannerPreferencesPageTabItem;

public class PlannerPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private static final String SAVE_DIALOG_TITLE = "Save Planner Preferences";
	private static final String SAVE_DIALOG_TEXT = "Do you want to save this configuration?";

	private Button newPlannerButton;

	private Button defaultPlannerCheckBox;

	private Combo defaultPlannerCombo;
	private Combo defaultArgumentCombo;

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

		boolean preferencesChanged = false;
		for (PlannerPreferencesPageTabItem item : tabsList) {
			preferencesChanged = (preferencesChanged || item
					.preferencesChanged());
		}
		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		if (preferencesChanged
				|| preferenceStore.getBoolean(Activator.PREF_DEFAULT_PLANNER) != defaultPlannerCheckBox
						.getSelection()
				|| (defaultPlannerCombo.getSelectionIndex() >= 0 && !preferenceStore
						.getString(Activator.PREF_DEFAULT_PLANNER_NAME).equals(
								defaultPlannerCombo.getItem(defaultPlannerCombo
										.getSelectionIndex())))
				|| (defaultArgumentCombo.getSelectionIndex() > 0 && !preferenceStore
						.getString(Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME)
						.equals(defaultArgumentCombo
								.getItem(defaultArgumentCombo
										.getSelectionIndex())))
				|| (defaultArgumentCombo.getSelectionIndex() == 0 && !preferenceStore
						.getString(Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME)
						.equals(""))) {
			if (MessageDialog.openQuestion(getShell(), SAVE_DIALOG_TITLE,
					SAVE_DIALOG_TEXT)) {
				for (PlannerPreferencesPageTabItem item : tabsList) {
					boolean saveOk = item.savePlannerPreferences();
					preferenceStore.setValue(Activator.PREF_DEFAULT_PLANNER,
							defaultPlannerCheckBox.getSelection());

					if (defaultPlannerCombo.getSelectionIndex() >= 0) {
						preferenceStore.setValue(
								Activator.PREF_DEFAULT_PLANNER_NAME,
								defaultPlannerCombo.getItem(defaultPlannerCombo
										.getSelectionIndex()));
					}

					if (defaultArgumentCombo.getSelectionIndex() > 0) {
						preferenceStore.setValue(
								Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME,
								defaultArgumentCombo
										.getItem(defaultArgumentCombo
												.getSelectionIndex()));
					} else {
						preferenceStore.setValue(
								Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME,
								"");
					}
					if (!saveOk) {
						MessageDialog
								.openError(getShell(), "Error while saving",
										"Could not save planner preferences. Restart Eclipse and try again.");
						throw new RuntimeException(
								"Could not save planner preferences");
					}
				}
			}
		}

		return super.performOk();
	}

	@Override
	protected Control createContents(Composite parent) {

		defaultPlannerCheckBox = new Button(parent, SWT.CHECK);
		defaultPlannerCheckBox.setText("&Default planner");

		Composite defaultPlannerComboComposite = createComboComposite(parent);

		defaultPlannerCombo = createDefaultPlannerCombo(defaultPlannerComboComposite);
		defaultArgumentCombo = createDefaultPlannerCombo(defaultPlannerComboComposite);

		defaultPlannerCheckBox.setSelection(Activator.getDefault()
				.getPreferenceStore()
				.getBoolean(Activator.PREF_DEFAULT_PLANNER));

		setCombosDisabledOrEnabled();

		defaultPlannerCheckBox.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				setCombosDisabledOrEnabled();
			}
		});

		defaultPlannerCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				addPlannerArgumentsToCombo();
			}
		});

		Composite pageComposite = createPageComposite(parent);
		newPlannerButton = createNewPlannerButton(pageComposite);

		final TabFolder plannerTabFolder = createPlannerTabFolder(pageComposite);

		addPlannersToTabFolder(plannerTabFolder);

		newPlannerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				addPlannerTab(plannerTabFolder);
				plannerTabFolder.setSelection(plannerTabFolder.getItemCount() - 1);
				updateDefaultPlannerCombos();
			}

		});

		// refresh save button while tab selection
		plannerTabFolder.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (tabsList.size() > plannerTabFolder.getSelectionIndex()) {
					checkIfAllPageTabItemsAreValid();
				}

			}

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		updateDefaultPlannerCombos();

		return pageComposite;
	}

	private Composite createComboComposite(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout grid = new GridLayout();
		grid.numColumns = 2;
		grid.makeColumnsEqualWidth = true;
		comp.setLayout(grid);
		comp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return comp;
	}

	private Combo createDefaultPlannerCombo(Composite comp) {
		final Combo combo = new Combo(comp, SWT.READ_ONLY);
		GridData data = new GridData();
		data.horizontalSpan = 1;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		data.widthHint = 300;
		combo.setLayoutData(data);
		return combo;
	}

	private void setCombosDisabledOrEnabled() {
		if (defaultPlannerCheckBox.getSelection()) {
			defaultPlannerCombo.setEnabled(true);
			defaultArgumentCombo.setEnabled(true);

		} else {
			defaultPlannerCombo.setEnabled(false);
			defaultArgumentCombo.setEnabled(false);
		}
	}

	public void updateDefaultPlannerCombos() {
		addPlannersToCombo();
		selectPlannerFromPreferenceStore();
		addPlannerArgumentsToCombo();
		selectArgumentFromPreferenceStore();
	}

	private void addPlannersToCombo() {

		defaultPlannerCombo.removeAll();
		if (tabsList.size() > 0) {
			for (PlannerPreferencesPageTabItem tabItem : tabsList) {
				defaultPlannerCombo.add(tabItem.getPlannerName());
			}
		} else {
			defaultPlannerCombo.setEnabled(false);
			defaultArgumentCombo.removeAll();
		}
	}

	private void selectPlannerFromPreferenceStore() {
		for (int i = 0; i < defaultPlannerCombo.getItems().length; i++) {
			if (defaultPlannerCombo.getItems()[i].equals(Activator.getDefault()
					.getPreferenceStore()
					.getString(Activator.PREF_DEFAULT_PLANNER_NAME))) {
				defaultPlannerCombo.select(i);
				break;
			}
		}
	}

	private void addPlannerArgumentsToCombo() {
		if (defaultPlannerCombo.getSelectionIndex() >= 0) {
			defaultArgumentCombo.removeAll();
			if (tabsList.size() > 0) {
				defaultArgumentCombo.add("No specified argument");
				if (tabsList.get(defaultPlannerCombo.getSelectionIndex())
						.getArguments().keySet().size() > 0) {
					for (String key : tabsList
							.get(defaultPlannerCombo.getSelectionIndex())
							.getArguments().keySet()) {
						defaultArgumentCombo.add(key);
					}
				}
			}
			defaultArgumentCombo.select(0);
		}
	}

	private void selectArgumentFromPreferenceStore() {
		for (int i = 0; i < defaultArgumentCombo.getItems().length; i++) {
			if (defaultArgumentCombo.getItems()[i].equals(Activator
					.getDefault().getPreferenceStore()
					.getString(Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME))) {
				defaultArgumentCombo.select(i);
				break;
			}
		}
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

		return tabFolder;
	}

	private void addPlannerTab(final TabFolder tabFolder) {
		tabFolder.setVisible(true);

		PlannerPreferences preferences = new PlannerPreferences("New Planner "
				+ (tabFolder.getItemCount() + 1), "", null, "");

		PlannerPreferencesPageTabItem plannerPreferencesPageTab = new PlannerPreferencesPageTabItem(
				preferences, this, tabFolder);

		checkIfAllPageTabItemsAreValid();

		tabsList.add(plannerPreferencesPageTab);
	}

	private void addPlannersToTabFolder(final TabFolder tabFolder) {
		for (String key : PlannerPreferencesManager.getManager()
				.getPlannerPreferences().keySet()) {
			PlannerPreferences preferences = PlannerPreferencesManager
					.getManager().getPlannerPreferences().get(key);

			PlannerPreferencesPageTabItem plannerPreferencesPageTab = new PlannerPreferencesPageTabItem(
					preferences, this, tabFolder);

			tabsList.add(plannerPreferencesPageTab);

		}
		checkIfAllPageTabItemsAreValid();
		tabFolder.setVisible(PlannerPreferencesManager.getManager()
				.getPlannerPreferences().size() > 0);

	}

	public void checkIfAllPageTabItemsAreValid() {
		for (PlannerPreferencesPageTabItem item : tabsList) {
			if (!item.checkIfTabItemIsValidAndSetErrorMessages()) {
				setValid(false);
				break;
			}
		}
	}

	public List<PlannerPreferencesPageTabItem> getTabsList() {
		return tabsList;
	}

	@Override
	public void init(IWorkbench arg0) {

	}

}
