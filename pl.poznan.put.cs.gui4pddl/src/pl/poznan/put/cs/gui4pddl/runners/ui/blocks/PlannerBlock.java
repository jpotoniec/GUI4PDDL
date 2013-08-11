package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.runners.LaunchConfigurationCreator;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;

public class PlannerBlock extends AbstractLaunchConfigurationTab {
	
	
	private Text plannerText;
	private Button plannerBrowseButton;
	private Button newPlannerButton;

	@Override
	public void createControl(Composite parent) {
		Font font = parent.getFont();

		Group group = initializeGroup(parent, font, 3);

		plannerText = createFileText("Planner script:", group, font);
		
		plannerBrowseButton = createPushButton(group, "Browse...", null);
		
		final Composite fParent = parent;
		
		plannerBrowseButton.addSelectionListener(new SelectionAdapter() {
			FileDialog fileDialog;

			@Override
			public void widgetSelected(SelectionEvent e) {
				fileDialog = new FileDialog(fParent.getShell());

				fileDialog.setText("Select Planner Script File");

				String selected = fileDialog.open();
				plannerText.setText(selected);

			}
		});
		
		
		Group plannerGroup = initializeGroup(parent,font, 4);
		
		Label label = new Label(plannerGroup, SWT.NONE);
		label.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_BEGINNING));
		label.setText("Planner:");

		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		Combo plannerCombo = new Combo(plannerGroup, SWT.READ_ONLY);
		plannerCombo.setLayoutData(gd);
		plannerCombo.add("Planner");
		
		Combo argumentsCombo = new Combo(plannerGroup, SWT.READ_ONLY);
		argumentsCombo.setLayoutData(gd);
		argumentsCombo.add("Planner arguments");

		newPlannerButton = createPushButton(plannerGroup, "New Planner", null);
		
		
		
		
	}
	
	public Group initializeGroup(Composite parent, Font font, int columns) {
		Group group = new Group(parent, SWT.NONE);
		setControl(group);

		GridLayout topLayout = new GridLayout();
		topLayout.numColumns = columns;
		group.setLayout(topLayout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		group.setFont(font);
		group.setText("Planner");

		return group;
	}
	
	public Text createFileText(String labelText, Group group, Font font) {

		final Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_BEGINNING));
		label.setText(labelText);

		Text text = new Text(group, SWT.SINGLE | SWT.BORDER);

		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.setFont(font);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

		return text;

	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean result = super.isValid(launchConfig);

		if (result) {
			setMessage(null);
			setErrorMessage(null);

			String plannerPath = plannerText.getText();
			

			if (plannerPath == null) {
				setErrorMessage("The domain file does not exist.");
				result = false;
			} else {
				File plannerFile = new File(plannerPath);
				if (!plannerFile.exists()) {
					setErrorMessage("The planner file " + plannerFile
							+ " does not exist.");
					result = false;

				} else if (!plannerFile.isFile()) {
					setErrorMessage("The planner file " + plannerFile
							+ " does not actually map to a file.");
					result = false;
				}
			}
		}
		return result;
	}

	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration conf) {
		String plannerName = "";
		try {
			plannerName = conf.getAttribute(RunnerConstants.PLANNER,
					"");
		} catch (CoreException e) {
		}
		plannerText.setText(plannerName);
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy conf) {
		String value = plannerText.getText().trim();
		conf.setAttribute(RunnerConstants.PLANNER, value);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy arg0) {
		// TODO Auto-generated method stub
		
	}

}
