package pl.poznan.put.cs.gui4pddl.preferences.ui;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

public class PlanViewDialog extends TitleAreaDialog {

	private Text regexpText;
	private String regexp;
	private Button workingDirButton;
	private Button projectNameButton;
	private Button domainFileNameButton;
	private Button problemFileNameButton;

	private final static String INFO_TEXT = "Enter regular expression of file which will be opened at the end of the planning process";

	public PlanViewDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Plan View Configuration");
		setMessage(INFO_TEXT, IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		//container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		container.setLayout(layout);

		createRegexpText(container);
		createRegexSpecialWordsButtons(area);

		regexpText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				Button okButton = getButton(IDialogConstants.OK_ID);
				setMessage(INFO_TEXT, IMessageProvider.INFORMATION);
				okButton.setEnabled(true);
				try {
					Pattern.compile(regexpText.getText());
				} catch (PatternSyntaxException exception) {
					setMessage("Regexp is not valid", IMessageProvider.ERROR);

					okButton.setEnabled(false);
				}
			}
		});

		return area;
	}

	private void createRegexpText(Composite container) {
		Label regexpLabel = new Label(container, SWT.NONE);
		regexpLabel.setText("Regular Expression of file name");

		GridData regexpGridData = new GridData();
		regexpGridData.grabExcessHorizontalSpace = true;
		regexpGridData.horizontalAlignment = GridData.FILL;

		regexpText = new Text(container, SWT.BORDER);
		regexpText.setLayoutData(regexpGridData);
		regexpText.setText(regexp);
	}
	
	private void createRegexSpecialWordsButtons(Composite container) {
		Composite buttonsComposite = new Composite(container, SWT.NONE);
		RowLayout layout = new RowLayout();
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		buttonsComposite.setLayout(layout);
		
		workingDirButton = new Button(buttonsComposite, SWT.PUSH);
		workingDirButton.setText("Working directory");
		projectNameButton = new Button(buttonsComposite, SWT.PUSH);
		projectNameButton.setText("Project name");
		domainFileNameButton = new Button(buttonsComposite, SWT.PUSH);
		domainFileNameButton.setText("Domain file name");
		problemFileNameButton = new Button(buttonsComposite, SWT.PUSH);
		problemFileNameButton.setText("Problem file name");
		
		workingDirButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent arg0) {
				appendTextInSelection(Constants.REGEXP_WORKING_DIRECTORY);			
			}
		});
		projectNameButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent arg0) {
				appendTextInSelection(Constants.REGEXP_PROJECT_NAME);			
			}
		});
		domainFileNameButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent arg0) {
				appendTextInSelection(Constants.REGEXP_DOMAIN_FILE_NAME);			
			}
		});
		problemFileNameButton.addSelectionListener(new SelectionAdapter() {	
			public void widgetSelected(SelectionEvent arg0) {
				appendTextInSelection(Constants.REGEXP_PROBLEM_FILE_NAME);			
			}
		});
	}
	
	private void appendTextInSelection(String text) {
		Point selection = regexpText.getSelection();
		StringBuilder sb = new StringBuilder(regexpText.getText());
		sb.replace(selection.x, selection.y, text);
		regexpText.setText(sb.toString());
		regexpText.setSelection(selection.x,selection.x);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// save content of the Text fields because they get disposed
	// as soon as the Dialog closes
	private void saveInput() {
		regexp = regexpText.getText();
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}
	
	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}

	public String getRegexp() {
		return regexp;
	}

}
