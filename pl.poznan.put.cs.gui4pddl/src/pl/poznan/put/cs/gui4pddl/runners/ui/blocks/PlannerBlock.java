package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import java.io.File;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

public class PlannerBlock extends AbstractLaunchConfigurationTab {

	private Combo plannerCombo;
	private Combo argumentsCombo;
	private int argumentsComboIndex;

	@Override
	public void createControl(Composite parent) {
		Group plannerGroup = createPlannerGroup(parent);

		plannerCombo = createCombo(plannerGroup);
		argumentsCombo = createCombo(plannerGroup);

		Map<String, PlannerPreferences> preferencesMap = PlannerPreferencesManager
				.getManager().getPlannerPreferences();
		if (preferencesMap.keySet().size() > 0) {
			plannerCombo.setEnabled(true);
			for (String key : preferencesMap.keySet()) {
				PlannerPreferences preferences = preferencesMap.get(key);
				plannerCombo.add(preferences.getPlannerName());
			}
		} else {
			plannerCombo.setEnabled(false);
		}
		argumentsCombo.setEnabled(false);

		plannerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				plannerArgumentsComboUpdate();
			}
		});

	}

	private Group createPlannerGroup(Composite parent) {
		Font font = parent.getFont();
		Group plannerGroup = initializeGroup(parent, font, 5);

		Label label = new Label(plannerGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 1;
		label.setLayoutData(gd);
		label.setText("Planner:");

		return plannerGroup;
	}

	private Group initializeGroup(Composite parent, Font font, int columns) {
		Group group = new Group(parent, SWT.NONE);
		setControl(group);

		GridLayout topLayout = new GridLayout();
		topLayout.numColumns = columns;
		group.setLayout(topLayout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		group.setFont(font);
		group.setText("Planner");

		return group;
	}

	private Combo createCombo(Group plannerGroup) {
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 2;
		Combo combo = new Combo(plannerGroup, SWT.READ_ONLY);
		combo.setLayoutData(gd);
		return combo;
	}

	private void plannerArgumentsComboUpdate() {
		if (plannerCombo.getSelectionIndex() >= 0) {
			PlannerPreferences preferences = PlannerPreferencesManager
					.getManager()
					.getPlannerPreferences()
					.get(plannerCombo.getItem(plannerCombo.getSelectionIndex()));
			updateLaunchConfigurationDialog();
			argumentsCombo.removeAll();
			argumentsCombo.add("No specified argument");
			if (preferences.getArgumentsMap().keySet().size() > 0) {
				argumentsCombo.setEnabled(true);
				for (String key : preferences.getArgumentsMap().keySet()) {
					argumentsCombo.add(key);
				}
			}
		}
	}

	public void addSelectionListenerToArgumentsCombo(
			final PlannerArgumentsBlock block) {

		argumentsCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (argumentsCombo.getSelectionIndex() > 0) {
					Map<String, String> preferences = PlannerPreferencesManager
							.getManager()
							.getPlannerPreferences()
							.get(plannerCombo.getItem(plannerCombo
									.getSelectionIndex())).getArgumentsMap();
					String argument = preferences.get(argumentsCombo
							.getItem(argumentsCombo.getSelectionIndex()));

					block.getArgumentText().setText(argument);
					block.getArgumentText().setEnabled(false);
					argumentsComboIndex = argumentsCombo.getSelectionIndex();
				} else {
					block.getArgumentText().setText("");
					block.getArgumentText().setEnabled(true);
					argumentsComboIndex = argumentsCombo.getSelectionIndex();
				}
			}
		});
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean result = super.isValid(launchConfig);

		if (result) {
			setMessage(null);
			setErrorMessage(null);

			int plannerComboIndex = plannerCombo.getSelectionIndex();

			if (plannerComboIndex < 0) {
				setErrorMessage("The planner is not choosen.");
				result = false;
			}
			if (plannerCombo.getItemCount() == 0) {
				setErrorMessage("Go to Window->Preferences->PDDL->Planners and configure PDDL Planner.");
			}

			if (plannerCombo.getItemCount() > 0
					&& plannerCombo.getSelectionIndex() > -1) {
				PlannerPreferences preferences = PlannerPreferencesManager
						.getManager()
						.getPlannerPreferences()
						.get(plannerCombo.getItem(plannerCombo
								.getSelectionIndex()));

				if (preferences.getPlannerFilePath() != null
						&& !preferences.getPlannerFilePath().isEmpty()) {
					File file = new File(preferences.getPlannerFilePath());
					if (!file.exists() || !file.isFile()) {
						setErrorMessage("There is no such file "
								+ file.getAbsolutePath()
								+ ". Go to Window->Preferences->PDDL->Planners and configure PDDL Planner.");
						result = false;
					}
				} else {
					setErrorMessage("There is no planner file specified in this configuration. Go to Window->Preferences->PDDL->Planners and configure PDDL Planner.");
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {
		String plannerName = "";
		String plannerArguments = "";
		try {
			plannerName = conf.getAttribute(Constants.PLANNER_NAME, "");
			plannerArguments = conf.getAttribute(Constants.ARGUMENTS_NAME, "");
		} catch (CoreException e) {
		}

		String[] items = plannerCombo.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(plannerName)) {
				plannerCombo.select(i);
			}
		}

		plannerArgumentsComboUpdate();

		boolean found = false;
		if (plannerCombo.getSelectionIndex() >= 0) {
			String[] items2 = argumentsCombo.getItems();
			for (int i = 1; i < items2.length; i++) {
				if (items2[i].equals(plannerArguments)) {
					argumentsCombo.select(i);
					argumentsComboIndex = i;
					found = true;
				}
			}
		}
		if (!found) {
			argumentsCombo.select(0);
		}

	}

	public int getArgumentsComboIndex() {
		if (argumentsCombo.isEnabled()) {
			return argumentsComboIndex;
		} else {
			return -1;
		}

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy conf) {
		if (plannerCombo.getSelectionIndex() >= 0) {
			PlannerPreferences preferences = PlannerPreferencesManager
					.getManager()
					.getPlannerPreferences()
					.get(plannerCombo.getItem(plannerCombo.getSelectionIndex()));

			conf.setAttribute(Constants.PLANNER_NAME,
					preferences.getPlannerName());

			conf.setAttribute(Constants.PLANNER,
					preferences.getPlannerFilePath());

			conf.setAttribute(Constants.FILE_NAME_REGEXP,
					preferences.getPlanViewFilePattern());
			if (argumentsCombo.getSelectionIndex() > 0) {
				conf.setAttribute(Constants.ARGUMENTS_NAME, argumentsCombo
						.getItem(argumentsCombo.getSelectionIndex()));
			}

		}

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
