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

	public final ProjectBlock projectBlock;
	public final DomainAndProblemFilesBlock domainAndProblemFilesBlock;


	public MainTab() {
		projectBlock = new ProjectBlock();
		domainAndProblemFilesBlock = new DomainAndProblemFilesBlock();
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);

		projectBlock.createControl(composite);
		domainAndProblemFilesBlock.createControl(composite);
	    projectBlock.addModifyListener(domainAndProblemFilesBlock.getProjectModifyListener());
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
            result = projectBlock.getMessage();
        }

        if (result == null) {
            result = domainAndProblemFilesBlock.getMessage();
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
            result = projectBlock.isValid(launchConfig);
        }

        if (result) {
            result = domainAndProblemFilesBlock.isValid(launchConfig);
        }
        return result;
    }

	@Override
	public String getName() {
		return "Main";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {
		projectBlock.initializeFrom(conf);
		domainAndProblemFilesBlock.initializeFrom(conf);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		projectBlock.performApply(configuration);
		domainAndProblemFilesBlock.performApply(configuration);
	}

	@Override
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		super.setLaunchConfigurationDialog(dialog);

		projectBlock.setLaunchConfigurationDialog(dialog);
		domainAndProblemFilesBlock.setLaunchConfigurationDialog(dialog);
	
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub

	}

}
