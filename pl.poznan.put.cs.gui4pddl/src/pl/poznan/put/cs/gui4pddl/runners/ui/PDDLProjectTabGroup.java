package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;

public class PDDLProjectTabGroup extends AbstractLaunchConfigurationTabGroup {

	private MainTab mainModuleTab;
	/*private PlannerTab plannerTab;*/
	
	@Override
	public void createTabs(ILaunchConfigurationDialog arg0, String arg1) {
		// plannerTab = new PlannerTab();
		mainModuleTab = new MainTab();
		 
	        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { mainModuleTab, /*plannerTab,*/
	        		new RefreshTab(), new EnvironmentTab(), new CommonTab()};
	        setTabs(tabs);
		
	}

}
