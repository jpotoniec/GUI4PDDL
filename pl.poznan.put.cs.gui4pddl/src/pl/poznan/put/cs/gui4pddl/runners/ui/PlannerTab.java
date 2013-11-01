package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.PlannerArgumentsBlock;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.PlannerBlock;

public class PlannerTab extends AbstractLaunchConfigurationTab {

	private PlannerBlock plannerBlock;
	private PlannerArgumentsBlock plannerArgumentsBlock;

	public PlannerTab() {
		plannerBlock = new PlannerBlock();
		plannerArgumentsBlock = new PlannerArgumentsBlock();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		plannerBlock.createControl(composite);
		plannerArgumentsBlock.createControl(composite);
		plannerBlock.addSelectionListenerToArgumentsCombo(plannerArgumentsBlock.getArgumentText());

	}

	@Override
	public String getErrorMessage() {
		String result = super.getErrorMessage();

		if (result == null) {
			result = plannerBlock.getErrorMessage();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getMessage()
	 */
	@Override
	public String getMessage() {
		String result = super.getMessage();

		if (result == null) {
			result = plannerBlock.getMessage();
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean result = super.isValid(launchConfig);

		if (result) {
			result = plannerBlock.isValid(launchConfig);
		}
		return result;
	}

	@Override
	public String getName() {
		return "Planner";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {
		plannerBlock.initializeFrom(conf);
		plannerArgumentsBlock.initializeFrom(conf);

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy conf) {
		plannerBlock.performApply(conf);
		plannerArgumentsBlock.performApply(conf);

	}

	@Override
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		super.setLaunchConfigurationDialog(dialog);

		plannerBlock.setLaunchConfigurationDialog(dialog);
		plannerArgumentsBlock.setLaunchConfigurationDialog(dialog);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
