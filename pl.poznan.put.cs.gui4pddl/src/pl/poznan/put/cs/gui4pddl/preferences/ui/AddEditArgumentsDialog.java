package pl.poznan.put.cs.gui4pddl.preferences.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddEditArgumentsDialog extends Dialog {

	private String argumentName;
	private String argumentText;
	private Text argumentNameTextField;
	private Text argumentTextTextField;

	protected AddEditArgumentsDialog(Shell parentShell) {
		super(parentShell);
	}

	protected String getTitle() {
		return "Modify arguments";
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 190);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Arguments");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);
		Label lbtArgumentName = new Label(container, SWT.NONE);
		lbtArgumentName.setText("Argument Name");

		GridData dataArgumentName = new GridData();
		dataArgumentName.grabExcessHorizontalSpace = true;
		dataArgumentName.horizontalAlignment = GridData.FILL;

		argumentNameTextField = new Text(container, SWT.BORDER);
		argumentNameTextField.setLayoutData(dataArgumentName);
		if (argumentName != null)
			argumentNameTextField.setText(argumentName);

		Label lbtArgumentText = new Label(container, SWT.NONE);
		lbtArgumentText.setText("Argument Text");

		GridData dataArgumentText = new GridData();
		dataArgumentText.grabExcessHorizontalSpace = true;
		dataArgumentText.horizontalAlignment = GridData.FILL;
		argumentTextTextField = new Text(container, SWT.BORDER);
		argumentTextTextField.setLayoutData(dataArgumentText);
		if (argumentText != null)
			argumentTextTextField.setText(argumentText);

		addTextListeners();

		return area;
	}

	private void addTextListeners() {
		argumentNameTextField.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				if (argumentNameTextField.getText().trim().length() > 0
						&& argumentTextTextField.getText().trim().length() > 0) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}

			}
		});

		argumentTextTextField.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				if (argumentNameTextField.getText().trim().length() > 0
						&& argumentTextTextField.getText().trim().length() > 0) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}

			}
		});

		argumentNameTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (argumentNameTextField.getText().trim().length() > 0
						&& argumentTextTextField.getText().trim().length() > 0) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});

		argumentTextTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (argumentNameTextField.getText().trim().length() > 0
						&& argumentTextTextField.getText().trim().length() > 0) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// We need to save the values of the Text fields into Strings because the UI
	// gets disposed
	// and the Text fields are not accessible any more.
	private void saveInput() {
		argumentName = argumentNameTextField.getText();
		argumentText = argumentTextTextField.getText();

	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getName() {
		return argumentName;
	}

	public String getText() {
		return argumentText;
	}

	public void setName(String argumentName) {
		this.argumentName = argumentName;
	}

	public void setText(String argumentText) {
		this.argumentText = argumentText;
	}

}
