/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.runners.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;

/**
 * Run configuration window tabs
 *
 */
public class PDDLProjectTabGroup extends AbstractLaunchConfigurationTabGroup {

	private MainTab mainModuleTab;

	@Override
	public void createTabs(ILaunchConfigurationDialog arg0, String arg1) {
		mainModuleTab = new MainTab();

		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				mainModuleTab, new RefreshTab(), new EnvironmentTab(),
				new CommonTab() };
		setTabs(tabs);

	}

}
