package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import pl.poznan.put.cs.gui4pddl.preferences.helpers.PlannerPreferencesStore;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;

public class PlannerBlock extends AbstractLaunchConfigurationTab {

	private Combo plannerCombo;
	private Combo argumentsCombo;

	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();

		Group plannerGroup = initializeGroup(parent, font, 4);

		Label label = new Label(plannerGroup, SWT.NONE);
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		label.setText("Planner:");

		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		plannerCombo = new Combo(plannerGroup, SWT.READ_ONLY);
		plannerCombo.setLayoutData(gd);
		final Map<String, PlannerPreferences> preferencesMap = PlannerPreferencesStore
				.getPlannerPreferences();
		for (String key : preferencesMap.keySet()) {
			PlannerPreferences preferences = preferencesMap.get(key);
			plannerCombo.add(preferences.getPlannerName());
		}

		argumentsCombo = new Combo(plannerGroup, SWT.READ_ONLY);
		argumentsCombo.setLayoutData(gd);

		plannerCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (plannerCombo.getSelectionIndex() >= 0) {
					PlannerPreferences preferences = preferencesMap
							.get(plannerCombo.getItem(plannerCombo
									.getSelectionIndex()));
					argumentsCombo.removeAll();
					for (String key : preferences.getArgumentsMap().keySet()) {
						argumentsCombo.add(key);
					}

				}
			}
		});

	}

	public void addSelectionListenerToArgumentsCombo(final Text argumentsText) {

		argumentsCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (argumentsCombo.getSelectionIndex() >= 0) {
					Map<String, String> preferences = PlannerPreferencesStore
							.getPlannerPreferences()
							.get(plannerCombo.getItem(plannerCombo
									.getSelectionIndex())).getArgumentsMap();
					String argument = preferences.get(argumentsCombo
							.getItem(argumentsCombo.getSelectionIndex()));
					argumentsText.setText(argument);
					argumentsText.update();

				}
			}

		});
	}

	public Group initializeGroup(Composite parent, Font font, int columns) {
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

	public Text createFileText(String labelText, Group group, Font font) {

		final Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		label.setText(labelText);

		Text text = new Text(group, SWT.SINGLE | SWT.BORDER);

		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.setFont(font);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

		return text;

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
				setErrorMessage("Go to Window->Preferences->PDDL->Planners and configure PDDL Planner");
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
			plannerName = conf.getAttribute(RunnerConstants.PLANNER_NAME, "");
			plannerArguments = conf.getAttribute(
					RunnerConstants.ARGUMENTS_NAME, "");
		} catch (CoreException e) {
		}

		String[] items = plannerCombo.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(plannerName)) {
				plannerCombo.select(i);
			}
		}

		if (plannerCombo.getSelectionIndex() >= 0) {
			PlannerPreferences preferences = PlannerPreferencesStore
					.getPlannerPreferences().get(
							plannerCombo.getItem(plannerCombo
									.getSelectionIndex()));
			argumentsCombo.removeAll();
			for (String key : preferences.getArgumentsMap().keySet()) {
				argumentsCombo.add(key);
			}

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
			PlannerPreferences preferences = PlannerPreferencesStore
					.getPlannerPreferences().get(
							plannerCombo.getItem(plannerCombo
									.getSelectionIndex()));

			conf.setAttribute(RunnerConstants.PLANNER_NAME,
					preferences.getPlannerName());
			
			conf.setAttribute(RunnerConstants.PLANNER,
					preferences.getPlannerFilePath());
		}
		if (argumentsCombo.getSelectionIndex() >= 0) {
			conf.setAttribute(RunnerConstants.ARGUMENTS_NAME,
					argumentsCombo.getItem(argumentsCombo.getSelectionIndex()));
		}
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
