package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;

public class ProjectBlock extends AbstractLaunchConfigurationTab {

	private Text projectText;
	private Button projectBrowseButton;
	private String projectLocation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Font font = parent.getFont();
		Group group = initializeGroup(parent, font);
		
		// Project chooser
		projectText = createProjectText(group, font);

		projectBrowseButton = createPushButton(group, "Browse...", null); //$NON-NLS-1$
		projectBrowseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				// Filter out project by pddl nature
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IProject[] projects = workspace.getRoot().getProjects();
				ArrayList<IProject> pddlProjects = new ArrayList<IProject>();
				for (IProject project : projects) {
					try {
						if (project.isOpen()
								&& project.hasNature(PDDLNature.PDDL_NATURE_ID)) {
							pddlProjects.add(project);
						}
					} catch (CoreException exception) {
						Log.log(exception);
					}

				}
				projects = pddlProjects.toArray(new IProject[pddlProjects
						.size()]);

				// Only allow the selection of projects, do not present
				// directories
				ILabelProvider labelProvider = DebugUITools
						.newDebugModelPresentation();
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(
						getShell(), labelProvider);
				dialog.setTitle("Project selection");
				dialog.setMessage("Choose a project for the run");
				dialog.setElements(projects);

				dialog.open();

				Object object = dialog.getFirstResult();
				if ((object != null) && (object instanceof IProject)) {
					IProject project = (IProject) object;

					String projectName = project.getName();
					projectText.setText(projectName);
					projectLocation = project.getLocation().toOSString();
				}
				updateLaunchConfigurationDialog();
			}
		});
	}
	
	private Group initializeGroup(Composite parent, Font font) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Project");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayoutData(gd);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		group.setFont(font);
		return group;
	}
	
	private Text createProjectText(Group group, Font font) {
		Text projectText = new Text(group, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		projectText.setLayoutData(gd);
		projectText.setFont(font);
		projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});
		
		return projectText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Project";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		String projectName = "";
		try {
			projectName = configuration.getAttribute(RunnerConstants.PROJECT,
					"");
			projectLocation = configuration.getAttribute(
					RunnerConstants.WORKING_DIRECTORY, "");
		} catch (CoreException e) {
		}
		projectText.setText(projectName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String value = projectText.getText().trim();
		setAttribute(configuration, RunnerConstants.PROJECT, value);
		setAttribute(configuration, RunnerConstants.WORKING_DIRECTORY,
				projectLocation);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean result = super.isValid(launchConfig);

		if (result) {
			setErrorMessage(null);
			setMessage(null);

			String projectName = projectText.getText();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IResource resource = workspace.getRoot().findMember(projectName);

			if (resource == null) {
				setErrorMessage("Invalid project");
				result = false;
			} else if (resource instanceof IProject) {
				IProject project = (IProject) resource;
				try {
					if (!project.hasNature(PDDLNature.PDDL_NATURE_ID)) {
						setErrorMessage("Invalid project (no pddl nature associated).");
						result = false;
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	/**
	 * Sets attributes in the working copy
	 * 
	 * @param configuration
	 *            The configuration to set the attribute in
	 * @param name
	 *            Name of the attribute to set
	 * @param value
	 *            Value to set
	 */
	private void setAttribute(ILaunchConfigurationWorkingCopy configuration,
			String name, String value) {
		if (value == null || value.length() == 0) {
			configuration.setAttribute(name, (String) null);
		} else {
			configuration.setAttribute(name, value);
		}
	}

	/**
	 * Adds a modification listener to the current control.
	 * 
	 * 
	 * @param listener
	 *            The listener to use
	 */
	public void addModifyListener(ModifyListener listener) {
		projectText.addModifyListener(listener);
	}

}
