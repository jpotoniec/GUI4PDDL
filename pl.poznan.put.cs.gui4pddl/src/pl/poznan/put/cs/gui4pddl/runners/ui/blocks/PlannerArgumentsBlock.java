package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class PlannerArgumentsBlock extends AbstractLaunchConfigurationTab {

	private Text argumentsText;
	private String argument = "";

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
		group.setLayoutData(new GridData(GridData.FILL_BOTH));

		String controlName = "Planner arguments: ";
		group.setText(controlName);

		argumentsText = new Text(group, SWT.MULTI | SWT.WRAP | SWT.BORDER
				| SWT.V_SCROLL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 40;
		gd.widthHint = 100;
		argumentsText.setLayoutData(gd);
		argumentsText.setFont(font);
		argumentsText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

		String buttonLabel = "Variables...";
		Button argumentsVariablesButton = createPushButton(group, buttonLabel,
				null);

		argumentsVariablesButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_END));
		argumentsVariablesButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				StringVariableSelectionDialog dialog = new StringVariableSelectionDialog(
						getShell());
				dialog.open();
				String variable = dialog.getVariableExpression();
				if (variable != null) {
					argumentsText.insert(variable);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public void setArgumentText(String text) {
		this.argument = text;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {

			if (argument == null || argument.isEmpty()) {
				String text = configuration.getAttribute(
						Constants.PLANNER_ARGUMENTS, "");
				argumentsText.setText(text);

			} else {

				argumentsText.setText(argument);
			}
		} catch (CoreException e) {
			setErrorMessage("Exception occurred reading configuration"
					+ e.getStatus().getMessage());
			Log.log(e);
		}
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
