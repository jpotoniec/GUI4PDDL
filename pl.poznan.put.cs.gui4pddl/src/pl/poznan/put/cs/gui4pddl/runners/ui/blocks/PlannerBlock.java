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
import org.eclipse.swt.widgets.Text;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

public class PlannerBlock extends AbstractLaunchConfigurationTab {

	private Combo plannerCombo;
	private Combo argumentsCombo;

	@Override
	public void createControl(Composite parent) {
		Group plannerGroup = createPlannerGroup(parent);

		plannerCombo = createCombo(plannerGroup);
		argumentsCombo = createCombo(plannerGroup);

		Map<String, PlannerPreferences> preferencesMap = PlannerPreferencesManager
				.getManager().getPlannerPreferences();
		for (String key : preferencesMap.keySet()) {
			PlannerPreferences preferences = preferencesMap.get(key);
			plannerCombo.add(preferences.getPlannerName());
		}

		plannerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				plannerArgumentsComboUpdate();
			}
		});

	}

	private void plannerArgumentsComboUpdate() {
		if (plannerCombo.getSelectionIndex() >= 0) {
			PlannerPreferences preferences = PlannerPreferencesManager
					.getManager()
					.getPlannerPreferences()
					.get(plannerCombo.getItem(plannerCombo.getSelectionIndex()));
			updateLaunchConfigurationDialog();
			argumentsCombo.removeAll();
			for (String key : preferences.getArgumentsMap().keySet()) {
				argumentsCombo.add(key);
			}
		}
	}

	private Group createPlannerGroup(Composite parent) {
		Font font = parent.getFont();
		Group plannerGroup = initializeGroup(parent, font, 4);

		Label label = new Label(plannerGroup, SWT.NONE);
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		label.setText("Planner:");

		return plannerGroup;
	}

	private Combo createCombo(Group plannerGroup) {
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		Combo combo = new Combo(plannerGroup, SWT.READ_ONLY);
		combo.setLayoutData(gd);
		return combo;
	}

	public void addSelectionListenerToArgumentsCombo(final PlannerArgumentsBlock block) {

		argumentsCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (argumentsCombo.getSelectionIndex() >= 0) {
					Map<String, String> preferences = PlannerPreferencesManager
							.getManager()
							.getPlannerPreferences()
							.get(plannerCombo.getItem(plannerCombo
									.getSelectionIndex())).getArgumentsMap();
					String argument = preferences.get(argumentsCombo
							.getItem(argumentsCombo.getSelectionIndex()));
					/*arguments.setText(argument);
					arguments.update();*/
					block.setArgumentText(argument);
				}
			}

		});
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

			if (plannerCombo.getItemCount() > 0 && plannerCombo.getSelectionIndex() > -1) {
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
			plannerArguments = conf.getAttribute(
					Constants.ARGUMENTS_NAME, "");
		} catch (CoreException e) {
		}

		String[] items = plannerCombo.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(plannerName)) {
				plannerCombo.select(i);
			}
		}

		plannerArgumentsComboUpdate();

		if (plannerCombo.getSelectionIndex() >= 0) {
			String[] items2 = argumentsCombo.getItems();
			for (int i = 0; i < items2.length; i++) {
				if (items2[i].equals(plannerArguments)) {
					argumentsCombo.select(i);
				}
			}
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

		}
		if (argumentsCombo.getSelectionIndex() >= 0) {
			conf.setAttribute(Constants.ARGUMENTS_NAME,
					argumentsCombo.getItem(argumentsCombo.getSelectionIndex()));
		}
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
