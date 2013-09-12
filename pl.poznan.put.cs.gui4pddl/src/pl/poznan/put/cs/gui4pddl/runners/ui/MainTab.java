package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.DomainAndProblemFilesBlock;
import pl.poznan.put.cs.gui4pddl.runners.ui.blocks.ProjectBlock;

public class MainTab extends AbstractLaunchConfigurationTab {

	public final ProjectBlock fProjectBlock;
	public final DomainAndProblemFilesBlock fMainModuleBlock;


	public MainTab() {
		fProjectBlock = new ProjectBlock();
		fMainModuleBlock = new DomainAndProblemFilesBlock();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		fProjectBlock.createControl(composite);
		fMainModuleBlock.createControl(composite);
	    fProjectBlock.addModifyListener(fMainModuleBlock.getProjectModifyListener());
	}
	
    @Override
    public String getErrorMessage() {
        String result = super.getErrorMessage();

        if (result == null) {
            result = fProjectBlock.getErrorMessage();
        }

        if (result == null) {
            result = fMainModuleBlock.getErrorMessage();
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getMessage()
     */
    @Override
    public String getMessage() {
        String result = super.getMessage();

        if (result == null) {
            result = fProjectBlock.getMessage();
        }

        if (result == null) {
            result = fMainModuleBlock.getMessage();
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
     */
    @Override
    public boolean isValid(ILaunchConfiguration launchConfig) {
        boolean result = super.isValid(launchConfig);

        if (result) {
            result = fProjectBlock.isValid(launchConfig);
        }

        if (result) {
            result = fMainModuleBlock.isValid(launchConfig);
        }
        return result;
    }

	@Override
	public String getName() {
		return "Main";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {
		fProjectBlock.initializeFrom(conf);
		fMainModuleBlock.initializeFrom(conf);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		fProjectBlock.performApply(configuration);
		fMainModuleBlock.performApply(configuration);
	}

	@Override
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		super.setLaunchConfigurationDialog(dialog);

		fProjectBlock.setLaunchConfigurationDialog(dialog);
		fMainModuleBlock.setLaunchConfigurationDialog(dialog);
	
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}