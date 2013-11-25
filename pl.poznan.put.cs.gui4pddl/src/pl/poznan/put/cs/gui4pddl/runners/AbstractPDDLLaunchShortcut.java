package pl.poznan.put.cs.gui4pddl.runners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public abstract class AbstractPDDLLaunchShortcut implements ILaunchShortcut {

	protected abstract String getLaunchConfigurationType();

	public void launch(ISelection selection, String mode) {

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			// single selection
			if (structuredSelection.size() == 1) {
				Object object = structuredSelection.getFirstElement();
				if (object instanceof IAdaptable) {

					IResource resource = (IFile) ((IAdaptable) object)
							.getAdapter(IFile.class);
					if (resource != null) {
						IProject project = resource.getProject();
						if (project != null) {
							launch(project, mode);
						}
						return;
					}

					IContainer folder = (IContainer) ((IAdaptable) object)
							.getAdapter(IContainer.class);
					if (folder != null) {

						if (folder instanceof IProject) {
							IProject project = folder.getProject();
							if (project != null)
								launch(project, mode);
						}
						return;
					}
				}
			}
			return;
		} else {
			Log.log("Expecting instance of IStructuredSelection. Received: "
					+ selection.getClass().getName());
		}
	}

	/**
	 * Launch for a selected editor.
	 */
	public void launch(IEditorPart editor, String mode) {
		// we have an editor to run
		IEditorInput input = editor.getEditorInput();
		IFile file = (IFile) input.getAdapter(IFile.class);
		if (file != null) {
			IProject project = file.getProject();
			if (project != null)
				launch(project, mode);
			return;
		}
		fileNotFound();
	}

	public void fileNotFound() {
		String msg = "Unable to launch the file. "
				+ "Possible reasons may include:\n"
				+ "    - the launch was cancelled;\n"
				+ "    - the file (editor) being launched is not under a project in the workspace;\n"
				+ "    - the file was deleted.";
		reportError(msg, null);
	}

	/**
	 * Report some error to the user.
	 */
	protected static void reportError(String message, Throwable throwable) {
		if (message == null) {
			message = "Unexpected error";
		}

		IStatus status = null;
		if (throwable instanceof CoreException) {
			status = ((CoreException) throwable).getStatus();
		} else {
			status = new Status(IStatus.ERROR,
					"pl.poznan.put.cs.gui4pddl.runners.ui", 0, message,
					throwable);
		}
		ErrorDialog.openError(Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getShell(), "PDDL runner error",
				"PDDL launch failed", status);
	}

	/**
	 * COPIED/MODIFIED from AntLaunchShortcut Returns a list of existing launch
	 * configuration for the given file.
	 */
	protected List<ILaunchConfiguration> findExistingLaunchConfigurations(
			IProject project) {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(getLaunchConfigurationType());
		List<ILaunchConfiguration> validConfigs = new ArrayList<ILaunchConfiguration>();
		if (type == null) {

			return validConfigs;
		}

		try {
			ILaunchConfiguration[] configs = manager
					.getLaunchConfigurations(type);

			// let's see if we can find it with a location relative or not.
			String location = ProjectFilesPathsHelpers
					.getProjectLocation(project);

			for (int i = 0; i < configs.length; i++) {
				String configPath = configs[i].getAttribute(
						RunnerConstants.WORKING_DIRECTORY, "");

				if (location.equals(configPath)) {

					validConfigs.add(configs[i]);
				}
			}
		} catch (CoreException e) {
			reportError("Unexpected error", e);
		}
		return validConfigs;
	}

	public ILaunchConfiguration createDefaultLaunchConfiguration(
			IProject project) {
		try {
			ILaunchConfigurationWorkingCopy createdConfiguration = createDefaultLaunchConfigurationWithoutSaving(project);
			if (createdConfiguration == null) {
				return null;
			}
			return createdConfiguration.doSave();
		} catch (CoreException e) {
			reportError(null, e);
			return null;
		}
	}

	public ILaunchConfigurationWorkingCopy createDefaultLaunchConfigurationWithoutSaving(
			IProject project) throws CoreException {
		String projName = project.getName();
		ILaunchConfigurationWorkingCopy createdConfiguration = LaunchConfigurationCreator
				.createDefaultLaunchConfiguration(project,
						getLaunchConfigurationType(),
						ProjectFilesPathsHelpers.getProjectLocation(project),
						projName);

		// Common Tab Arguments
		if (createdConfiguration != null) {
			CommonTab tab = new CommonTab();
			tab.setDefaults(createdConfiguration);
			tab.dispose();
		}

		return createdConfiguration;
	}

	/**
	 * COPIED/MODIFIED from AntLaunchShortcut
	 */
	protected ILaunchConfiguration chooseConfig(
			List<ILaunchConfiguration> configs) {
		if (configs.isEmpty()) {
			return null;
		}
		final ILabelProvider labelProvider = DebugUITools
				.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				Display.getDefault().getActiveShell(), new ILabelProvider() {
					public Image getImage(Object element) {
						return labelProvider.getImage(element);
					}

					public String getText(Object element) {
						if (element instanceof ILaunchConfiguration) {
							ILaunchConfiguration configuration = (ILaunchConfiguration) element;
							try {
								return labelProvider.getText(element)
										+ " - "
										+ configuration.getAttribute(
												RunnerConstants.PLANNER_NAME,
												"")
										+ " : "
										+ configuration.getAttribute(
												RunnerConstants.ARGUMENTS_NAME,
												"");
							} catch (CoreException ex) {
								// ignore
							}
						}
						return labelProvider.getText(element);
					}

					public boolean isLabelProperty(Object element,
							String property) {
						return labelProvider.isLabelProperty(element, property);
					}

					public void addListener(ILabelProviderListener listener) {
						labelProvider.addListener(listener);
					}

					public void removeListener(ILabelProviderListener listener) {
						labelProvider.removeListener(listener);
					}

					public void dispose() {
						labelProvider.dispose();
					}
				});
		dialog.setElements(configs.toArray(new ILaunchConfiguration[configs
				.size()]));
		dialog.setTitle("Pick a PDDL configuration");
		dialog.setMessage("Choose a PDDL configuration to run");
		dialog.setMultipleSelection(false);
		int result = dialog.open();
		labelProvider.dispose();
		if (result == Window.OK)
			return (ILaunchConfiguration) dialog.getFirstResult();
		else
			return null;
	}

	/**
	 * Launch the given targets in the given build file. The targets are
	 * launched in the given mode.
	 * 
	 * @param resources
	 *            the resources to launch
	 * @param mode
	 *            the mode in which the file should be executed
	 */
	protected void launch(IProject project, String mode) {
		ILaunchConfiguration conf = null;
		List<ILaunchConfiguration> configurations = findExistingLaunchConfigurations(project);
		if (configurations.isEmpty())
			conf = createDefaultLaunchConfiguration(project);
		else {
			if (configurations.size() == 1) {
				conf = configurations.get(0);
				if (conf == null) {
					fileNotFound();
				}
			} else {
				conf = chooseConfig(configurations);
				if (conf == null) {
					// User canceled selection
					return;
				}
			}
		}

		if (conf != null) {
			DebugUITools.launch(conf, mode);
			return;
		}

	}

}
