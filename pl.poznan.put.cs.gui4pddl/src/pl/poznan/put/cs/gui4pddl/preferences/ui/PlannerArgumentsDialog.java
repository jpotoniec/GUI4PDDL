package pl.poznan.put.cs.gui4pddl.preferences.ui;


import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
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

public class PlannerArgumentsDialog extends Dialog {

	private String argumentName;
	private String argumentText;
	private Text argumentNameTextField;
	private Text argumentTextTextField;

	protected PlannerArgumentsDialog(Shell parentShell) {
		super(parentShell);
	}

	protected String getTitle() {
		return "Modify planner arguments";
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 250);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Arguments");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite parentComposite = (Composite) super.createDialogArea(parent);
		Composite dialogComposite = createComposite(parentComposite);
		argumentNameTextField = createArgumentName(dialogComposite);
		argumentTextTextField = createArgumentText(dialogComposite);

		addModifyAndFocusListenersToTextFields();

		return dialogArea;
	}

	private Composite createComposite(Composite parent) {
		Composite dialogComposite = new Composite(parent, SWT.NONE);
		dialogComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		dialogComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		dialogComposite.setLayout(layout);
		return dialogComposite;
	}

	private Text createArgumentName(Composite dialogComposite) {
		Label argumentNameLabel = new Label(dialogComposite, SWT.NONE);
		argumentNameLabel.setText("Argument Name");

		GridData argumentNameGridData = new GridData();
		argumentNameGridData.grabExcessHorizontalSpace = true;
		argumentNameGridData.horizontalAlignment = GridData.FILL;

		Text argumentNameTextField = new Text(dialogComposite, SWT.BORDER);
		argumentNameTextField.setLayoutData(argumentNameGridData);
		if (argumentName != null)
			argumentNameTextField.setText(argumentName);
		return argumentNameTextField;
	}

	private Text createArgumentText(Composite dialogComposite) {
		Label argumentTextLabel = new Label(dialogComposite, SWT.NONE);
		argumentTextLabel.setText("Argument Text");

		GridData argumentTextGridData = new GridData(GridData.FILL_BOTH);
		Text argumentTextTextField = new Text(dialogComposite, SWT.MULTI
				| SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		argumentTextTextField.setLayoutData(argumentTextGridData);

		if (argumentText != null)
			argumentTextTextField.setText(argumentText);
		return argumentTextTextField;
	}

	private void addModifyAndFocusListenersToTextFields() {
		argumentNameTextField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setOKButtonEnabledIfTextFieldsValid();
			}
		});
		
		argumentNameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				setOKButtonEnabledIfTextFieldsValid();
			}
		});

		argumentTextTextField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				setOKButtonEnabledIfTextFieldsValid();
			}
		});

		argumentTextTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				setOKButtonEnabledIfTextFieldsValid();
			}
		});
	}

	private void setOKButtonEnabledIfTextFieldsValid() {
		if (argumentNameTextField.getText().trim().length() > 0
				&& argumentTextTextField.getText().trim().length() > 0) {
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		} else {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
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
