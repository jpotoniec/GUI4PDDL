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
package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;

/**
 * A control for custom arguments in Run Configuration window.
 *
 */
public class PlannerArgumentsBlock extends AbstractLaunchConfigurationTab {

	private Text argumentsText;
	private int argumentsComboIndex;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		Font font = parent.getFont();

		Group group = new Group(parent, SWT.NONE);
		group.setFont(font);
		GridLayout gridLayout = new GridLayout();
		group.setLayout(gridLayout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		String controlName = "Planner arguments: ";
		group.setText(controlName);

		argumentsText = new Text(group, SWT.MULTI | SWT.WRAP | SWT.BORDER
				| SWT.V_SCROLL);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 80;
		gd.widthHint = 100;
		gd.horizontalAlignment = 4;
		argumentsText.setLayoutData(gd);
		argumentsText.setFont(font);
		argumentsText.setEnabled(false);
		argumentsText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	public Text getArgumentText() {
		return argumentsText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Planner arguments";
	}
	
	public void setDisabledDependsOnArgumentsComboIndex(int index) {
		if (index > 0 || index < 0) {
			argumentsText.setEnabled(false);
		} else if (index == 0) {
			argumentsText.setEnabled(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {

			String text = configuration.getAttribute(
					Constants.PLANNER_ARGUMENTS, "");
			argumentsText.setText(text);

		} catch (CoreException e) {
			setErrorMessage("Exception occurred reading configuration"
					+ e.getStatus().getMessage());
			Log.log(e);
		}
	}
	
	public void setArgumentsComboIndex(int index) {
		argumentsComboIndex = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Constants.PLANNER_ARGUMENTS, argumentsText
				.getText().trim());
		if (argumentsComboIndex == 0) {
			configuration.setAttribute(Constants.ARGUMENTS_NAME, argumentsText.getText().trim());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// No defaults to set
	}
}
