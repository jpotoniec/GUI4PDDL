package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.DomainAndProblemFilesBlock;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.PlannerArgumentsBlock;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.PlannerBlock;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.ProjectBlock;

public class MainTab extends AbstractLaunchConfigurationTab {

	public final ProjectBlock projectBlock;
	public final DomainAndProblemFilesBlock domainAndProblemFilesBlock;
	public final PlannerBlock plannerBlock;
	private final PlannerArgumentsBlock argumentsBlock;

	public MainTab() {
		projectBlock = new ProjectBlock();
		domainAndProblemFilesBlock = new DomainAndProblemFilesBlock();
		plannerBlock = new PlannerBlock();
		argumentsBlock = new PlannerArgumentsBlock();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		projectBlock.createControl(composite);
		domainAndProblemFilesBlock.createControl(composite);
		plannerBlock.createControl(composite);
		argumentsBlock.createControl(composite);
		projectBlock.addModifyListener(domainAndProblemFilesBlock
				.getProjectModifyListener());

		plannerBlock.addSelectionListenerToArgumentsCombo(argumentsBlock);
	}

	@Override
	public String getErrorMessage() {
		String result = super.getErrorMessage();

		if (result == null) {
			result = projectBlock.getErrorMessage();
		}

		if (result == null) {
			result = domainAndProblemFilesBlock.getErrorMessage();
		}

		if (result == null) {
			result = plannerBlock.getErrorMessage();
		}

		if (result == null) {
			result = argumentsBlock.getErrorMessage();
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
			result = projectBlock.getMessage();
		}

		if (result == null) {
			result = domainAndProblemFilesBlock.getMessage();
		}

		if (result == null) {
			result = plannerBlock.getMessage();
		}

		if (result == null) {
			result = argumentsBlock.getMessage();
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
			result = projectBlock.isValid(launchConfig);
		}

		if (result) {
			result = domainAndProblemFilesBlock.isValid(launchConfig);
		}

		if (result) {
			result = plannerBlock.isValid(launchConfig);
		}

		if (result) {
			result = argumentsBlock.isValid(launchConfig);
		}

		return result;
	}

	@Override
	public String getName() {
		return "Main";
	}

	@Override
	public Image getImage() {
		return Activator.getImageCache().get(Constants.MAIN_ICON);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {

		projectBlock.initializeFrom(conf);
		domainAndProblemFilesBlock.initializeFrom(conf);
		plannerBlock.initializeFrom(conf);
		int index = plannerBlock.getArgumentsComboIndex();
		argumentsBlock.initializeFrom(conf);
		argumentsBlock.setDisabledDependsOnArgumentsComboIndex(index);

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (isValid(configuration)) {
			projectBlock.performApply(configuration);
			domainAndProblemFilesBlock.performApply(configuration);
			plannerBlock.performApply(configuration);
			int index = plannerBlock.getArgumentsComboIndex();
			argumentsBlock.setArgumentsComboIndex(index);
			argumentsBlock.performApply(configuration);
		}
	}

	@Override
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		super.setLaunchConfigurationDialog(dialog);

		projectBlock.setLaunchConfigurationDialog(dialog);
		domainAndProblemFilesBlock.setLaunchConfigurationDialog(dialog);
		plannerBlock.setLaunchConfigurationDialog(dialog);
		argumentsBlock.setLaunchConfigurationDialog(dialog);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
