package pl.poznan.put.cs.gui4pddl.runners.ui.blocks;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

/**
 * A control for selecting a pddl domain and problem files.
 */
public class DomainAndProblemFilesBlock extends AbstractLaunchConfigurationTab {

	private Text domainFileText;
	private Text problemFileText;
	private Button problemFileBrowseButton;
	private Button domainFileBrowseButton;
	private String projectName;
	private ModifyListener projectModifyListener;

	public void createControl(Composite parent) {
		Font font = parent.getFont();

		Group group = initializeGroup(parent, font);

		domainFileText = createFileText("Domain file:", group, font);
		domainFileBrowseButton = createPushButton(group, "Browse...", null);

		problemFileText = createFileText("Problem file:", group, font);
		problemFileBrowseButton = createPushButton(group, "Browse...", null);

		addSelectionListenerToBrowseButton(domainFileBrowseButton,
				domainFileText, "Domain file", "Choose PDDL domain file",
				parent);
		addSelectionListenerToBrowseButton(problemFileBrowseButton,
				problemFileText, "Problem file", "Choose PDDL problem file",
				parent);

		createProjectModifyListener();

	}

	public Group initializeGroup(Composite parent, Font font) {
		Group group = new Group(parent, SWT.NONE);
		setControl(group);

		GridLayout topLayout = new GridLayout();
		topLayout.numColumns = 3;
		group.setLayout(topLayout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		group.setFont(font);
		group.setText("Domain and Problem Files");

		return group;
	}

	public Text createFileText(String labelText, Group group, Font font) {

		final Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
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

	public void addSelectionListenerToBrowseButton(Button button, Text text,
			String title, String message, Composite parent) {
		final Composite lParent = parent;
		final Text lText = text;
		final String lTitle = title;
		final String lMessage = message;
		// On button click, this display the pddl module picker dialog.
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();

				IResource resource = workspace.getRoot()
						.findMember(projectName);

				if (resource instanceof IProject) {
					IProject project = (IProject) resource;

					PDDLFilePickerDialog dialog = new PDDLFilePickerDialog(
							lParent.getShell(), lTitle, lMessage, project);

					int result = dialog.open();
					if (result == PDDLFilePickerDialog.OK) {
						Object[] dialResult = dialog.getResult();
						if ((dialResult != null)) {

							if (dialResult[0] instanceof IResource) {

								if (dialResult[0] instanceof IFile) {

									IFile file = (IFile) dialResult[0];
									lText.setText(LaunchUtil
											.getRelativeFileLocation(file
													.getFullPath()));
								}
							}

						}
					}
				}
			}
		});
	}

	private void createProjectModifyListener() {
		// Create a ModifyListener, used to listen for project modifications in
		// the ProjectBlock.
		// This assumes that the Project is in a Text control...
		projectModifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Widget widget = e.widget;
				if (widget instanceof Text) {
					Text text = (Text) widget;
					projectName = text.getText();
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IResource resource = workspace.getRoot().findMember(
							projectName);

					boolean enabled = false;
					if ((resource != null) && (resource instanceof IProject)) {
						IProject project = (IProject) resource;
						try {
							enabled = (project
									.hasNature(PDDLNature.PDDL_NATURE_ID));
						} catch (CoreException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					domainFileBrowseButton.setEnabled(enabled);
					problemFileBrowseButton.setEnabled(enabled);
				}
			}
		};
	}

	/*
	 * * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Main module";
	}

	/*
	 * * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */

	public void initializeFrom(ILaunchConfiguration configuration) {

		// Initialize the location field
		String domainFileLocation = "";
		String problemFileLocation = "";
		try {
			if (LaunchUtil.getDomainFile(configuration) != null) {
				domainFileLocation = LaunchUtil
						.getRelativeFileLocation(LaunchUtil.getDomainFile(
								configuration).getFullPath());
			}

			if (LaunchUtil.getProblemFile(configuration) != null) {
				problemFileLocation = LaunchUtil
						.getRelativeFileLocation(LaunchUtil.getProblemFile(
								configuration).getFullPath());
			}
			projectName = configuration.getAttribute(Constants.PROJECT, "");
		} catch (CoreException e) {
		}
		domainFileText.setText(domainFileLocation);
		problemFileText.setText(problemFileLocation);
	}

	/*
	 * * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		String domainFilePathString = domainFileText.getText().trim();
		String problemFilePathString = problemFileText.getText().trim();

		IPath domainPath = null;
		IPath problemPath = null;
		if (domainFilePathString != null && problemFilePathString != null
				&& !domainFilePathString.isEmpty()
				&& !problemFilePathString.isEmpty()) {

			String domainPathString = LaunchUtil
					.getAbsoluteFilePathFromRelativePath(domainFilePathString);

			String problemPathString = LaunchUtil
					.getAbsoluteFilePathFromRelativePath(problemFilePathString);

			if (domainPathString != null)
				domainPath = new Path(domainPathString);
			if (problemPathString != null)
				problemPath = new Path(problemPathString);
			

			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			if (project != null) {
				
				System.out.println(project.getLocation());
				
				IPath domainFileRelativePath = domainPath
						 .makeRelativeTo(ResourcesPlugin.getWorkspace().getRoot().getLocation());
				IPath problemFileRelativePath = problemPath
						 .makeRelativeTo(ResourcesPlugin.getWorkspace().getRoot().getLocation());
				
				System.out.println("DOMAIN FILE " + domainFileRelativePath);
				System.out.println("PROBLEM FILE " + problemFileRelativePath);
				
				IResource domainFile = LaunchUtil.findResource(domainFileRelativePath);
				IResource problemFile = LaunchUtil.findResource(problemFileRelativePath);
				if (domainFile != null && problemFile != null) {
					configuration.setMappedResources(new IResource[] {
							domainFile, problemFile });
				} else {
					// TODO komunikat o usunieciu plikow domeny lub problemu
				}
			} else {
				// TODO komunikat o usunięciu projektu
			}
		}

	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean result = super.isValid(launchConfig);

		if (result) {
			setMessage(null);
			setErrorMessage(null);

			String domainPath = domainFileText.getText();
			String problemPath = problemFileText.getText();

			String domainFullPath = null;
			String problemFullPath = null;

			domainFullPath = LaunchUtil
					.getAbsoluteFilePathFromRelativePath(domainPath);
			problemFullPath = LaunchUtil
					.getAbsoluteFilePathFromRelativePath(problemPath);

			if (domainFullPath == null) {
				setErrorMessage("The domain file path is incorrect or not exists.");
				result = false;
			} else if (problemFullPath == null) {
				setErrorMessage("The problem file path is incorrect or not exists.");
				result = false;
			} else {

				File domainFile = new File(domainFullPath);
				File problemFile = new File(problemFullPath);
				if (!domainFile.exists()) {
					setErrorMessage("The domain file " + domainFile
							+ " does not exist.");
					result = false;

				} else if (!problemFile.exists()) {
					setErrorMessage("The problem file " + problemFile
							+ " does not exist.");
					result = false;
				} else if (!domainFile.isFile()) {
					setErrorMessage("The domain file " + domainFile
							+ " does not actually map to a file.");
					result = false;
				} else if (!problemFile.isFile()) {
					setErrorMessage("The problem file " + problemFile
							+ " does not actually map to a file.");
					result = false;
				}
			}
		}
		return result;
	}

	/*
	 * * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// no defaults to set
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
	 * Obtain a listener, used to detect changes of the currently selected
	 * project This updates the browse button, and allos the appropriate
	 * selection of the main module.
	 * 
	 * @return a ModifyListener that updates the block controls.
	 */
	public ModifyListener getProjectModifyListener() {
		return projectModifyListener;
	}

	class PDDLFilePickerDialog extends ElementTreeSelectionDialog {

		public PDDLFilePickerDialog(Shell parent, String title, String message,
				IProject project) {
			super(parent, new WorkbenchLabelProvider(),
					new PDDLFileContentProvider());
			this.setAllowMultiple(false);
			this.setEmptyListMessage("No PDDL Files in project "
					+ project.getName());
			this.setInput(project);
			this.setTitle(title);
			this.setMessage(message);

			this.setValidator(new ISelectionStatusValidator() {
				public IStatus validate(Object selection[]) {
					if (selection.length >= 1) {
						if (selection[0] instanceof IFile) {
							IFile file = (IFile) selection[0];

							return new Status(IStatus.OK, Activator.PLUGIN_ID,
									IStatus.OK, "File  " + file.getName()
											+ " selected", null);

						}
					}
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							IStatus.ERROR, "No PDDL File selected", null);

				}
			});
		}
	}

	class PDDLFileContentProvider implements ITreeContentProvider {

		/**
		 * Creates a new ContainerContentProvider.
		 */
		PDDLFileContentProvider() {
		}

		/**
		 * The visual part that is using this content provider is about to be
		 * disposed. Deallocate all allocated SWT resources.
		 */
		public void dispose() {
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang
		 * .Object)
		 */
		public Object[] getChildren(Object element) {

			if (element instanceof IContainer) {
				IContainer container = (IContainer) element;

				if (container.isAccessible()) {
					try {
						List<IResource> children = new ArrayList<IResource>();

						IResource[] members = container.members();

						for (int i = 0; i < members.length; i++) {

							if (members[i] instanceof IFile) {
								IFile file = (IFile) members[i];
								if (file.getFileExtension() != null) {
									if (file.getFileExtension()
											.equalsIgnoreCase("pddl")) {
										children.add(file);
									}
								}
							} else if (members[i] instanceof IContainer) {
								children.add(members[i]);
							}
						}
						return children.toArray();
					} catch (CoreException e) {
						// this should never happen because we call
						// #isAccessible before invoking #members
					}
				}
			}

			return new Object[0];
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
		 * java.lang.Object)
		 */
		public Object[] getElements(Object element) {
			return getChildren(element);
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang
		 * .Object)
		 */
		public Object getParent(Object element) {
			if (element instanceof IResource)
				return ((IResource) element).getParent();
			return null;
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang
		 * .Object)
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		/*
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged
		 */
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

}