package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;

public class PDDLApplicationTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog arg0, String arg1) {
		  MainTab mainModuleTab = new MainTab();
		  PlannerTab plannerTab = new PlannerTab();
	        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { mainModuleTab, plannerTab,
	        		new RefreshTab(), new EnvironmentTab(), new CommonTab()};
	        setTabs(tabs);
		
	}

}
