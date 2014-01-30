package pl.poznan.put.cs.gui4pddl.runners;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

public class PDDLLaunchShortcut implements ILaunchShortcut {

	private boolean showDialog = false;

	protected String getLaunchConfigurationType() {
		return Constants.LAUNCH_CONFIG_TYPE;
	}

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
							launch(project, mode, resource);
						}
						return;
					}

					IContainer folder = (IContainer) ((IAdaptable) object)
							.getAdapter(IContainer.class);
					if (folder != null) {

						if (folder instanceof IProject) {
							IProject project = folder.getProject();
							if (project != null)
								launch(project, mode, project);
						} else if (folder instanceof IFolder) {
							IProject project = folder.getProject();
							IFolder f = (IFolder) folder;
							if (f != null) {
								launch(project, mode, folder);
							}
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
				launch(project, mode, file);
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
			IProject project, IResource resource) {
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

			if (resource instanceof IProject) {
				String location = LaunchUtil.getProjectLocation(project);

				for (ILaunchConfiguration config : configs) {
					if (location.equals(config.getAttribute(
							Constants.WORKING_DIRECTORY, ""))) {
						validConfigs.add(config);
					}
				}
			} else if (resource instanceof IFile) {
				for (ILaunchConfiguration config : configs) {
					if (config.getMappedResources() != null) {
						for (IResource r : config.getMappedResources()) {
							if (resource.equals(r)) {
								validConfigs.add(config);
								break;
							}
						}
					}
				}
			} else if (resource instanceof IFolder) {
				for (ILaunchConfiguration config : configs) {
					if (config.getMappedResources() != null) {
						for (IResource r : config.getMappedResources()) {
							if (resource
									.getRawLocation()
									.toOSString()
									.equals(r.getParent().getRawLocation()
											.toOSString())) {
								validConfigs.add(config);
								break;
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			reportError("Unexpected error", e);
		}
		return validConfigs;
	}

	public ILaunchConfiguration createDefaultLaunchConfiguration(
			IProject project, IResource resource) {
		try {
			ILaunchConfigurationWorkingCopy createdConfiguration = createDefaultLaunchConfigurationWithoutSaving(
					project, resource);

			if (createdConfiguration == null) {
				return null;
			}

			return createdConfiguration;
		} catch (CoreException e) {
			reportError(null, e);
			return null;
		}
	}


	private boolean shouldLaunchConfigurationDialogBeShown(
			ILaunchConfiguration conf) {
		try {
			return (conf.getAttribute(Constants.PLANNER, "").isEmpty()
					|| conf.getAttribute(Constants.WORKING_DIRECTORY, "")
							.isEmpty()
					|| conf.getAttribute(Constants.PROJECT, "").isEmpty()
					|| conf.getAttribute(Constants.ARGUMENTS_NAME, "").isEmpty()
					|| LaunchUtil.getDomainFile(conf) == null || LaunchUtil
						.getProblemFile(conf) == null);
		} catch (CoreException e) {
			Log.log(e);
			e.printStackTrace();
		}
		return false;
	}

	public ILaunchConfigurationWorkingCopy createDefaultLaunchConfigurationWithoutSaving(
			IProject project, IResource resource) throws CoreException {
		String projName = project.getName();
		ILaunchConfigurationWorkingCopy createdConfiguration = LaunchConfigurationCreator
				.createDefaultLaunchConfiguration(project,
						getLaunchConfigurationType(),
						LaunchUtil.getProjectLocation(project), projName,
						resource);

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
										+ "\nDomain: "
										+ LaunchUtil.getDomainFile(
												configuration).getName()
										+ "\nProblem: "
										+ LaunchUtil.getProblemFile(
												configuration).getName()
										+ "\n"
										+ configuration.getAttribute(
												Constants.PLANNER_NAME, "")
										+ "\n"
										+ configuration.getAttribute(
												Constants.ARGUMENTS_NAME, "");
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
	protected void launch(IProject project, String mode, IResource resource) {
		System.out.println("LAUNCH");
		ILaunchConfiguration conf = null;
		List<ILaunchConfiguration> configurations = findExistingLaunchConfigurations(
				project, resource);
		if (configurations.isEmpty()) {
			conf = createDefaultLaunchConfiguration(project, resource);
		} else {
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
			if (shouldLaunchConfigurationDialogBeShown(conf)) {
				LaunchUtil.openLaunchConfigurationDialogAndSave(conf);
			} else {
				if (!showDialog)
					LaunchUtil.launchAndSave(conf, mode);
				else
					LaunchUtil.openLaunchConfigurationDialogAndSave(conf);
			}
		}
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

}
