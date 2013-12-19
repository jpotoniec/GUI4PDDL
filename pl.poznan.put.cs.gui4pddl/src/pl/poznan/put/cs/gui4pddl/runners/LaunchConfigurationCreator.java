package pl.poznan.put.cs.gui4pddl.runners;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLProblem;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

/**
 * A utility class that creates new {@link ILaunchConfiguration}s.
 * 
 * 
 */
public class LaunchConfigurationCreator {

	public static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName, IResource resource) throws CoreException {
		return createDefaultLaunchConfiguration(project,
				launchConfigurationType, location, projName, "", true, resource);
	}

	private static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName, String programArguments, boolean captureOutput,
			IResource resource) throws CoreException {

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(launchConfigurationType);
		if (type == null) {
			Log.log("PDDL launch configuration type not found");
		}

		ILaunchConfiguration[] configs = manager.getLaunchConfigurations(type);
		String name = createLaunchConfigurationName(projName, configs.length);
		name = manager.generateLaunchConfigurationName(name);

		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null,
				name);

		if (resource instanceof IFile) {

			IPDDLNature nature = PDDLNature.getPDDLNature(project);
			PDDLFile pddlFile = getPDDLFile((IFile) resource);
			if (isDomainFile(pddlFile)) {
				ArrayList<IPath> problems = getProblemsPaths(pddlFile, nature);
				if (problems != null && problems.size() > 0) {
					if (problems.size() == 1) {
						IResource problemResource = LaunchUtil
								.findResource(problems.get(0));
						workingCopy.setMappedResources(new IResource[] {
								resource, problemResource });
					} else {
						Object result = getSelectionDialogResult(
								problems.toArray(),
								"Pick a problem file",
								"There are many problem files associated with this domain file. Choose a problem file to run.");
						if (result != null) {
							IPath resultPath = (IPath) result;
							IResource resultFile = LaunchUtil
									.findResource(resultPath);
							workingCopy.setMappedResources(new IResource[] {
									resource, resultFile });
						} else {
							return null;
						}
					}

				} else {
					MessageDialog
							.openWarning(Display.getDefault().getActiveShell(),
									"No associated problem files",
									"There is no problem files associated with this domain file.");

					workingCopy.setMappedResources(new IResource[] { resource,
							LaunchUtil.findResource(project.getFullPath()) });

				}

			} else if (isProblemFile(pddlFile)) {
				IPath domainPath = getDomainPath(pddlFile, nature);
				if (domainPath != null) {

					IResource domainResource = LaunchUtil
							.findResource(domainPath);
					workingCopy.setMappedResources(new IResource[] {
							domainResource, resource });
				} else {
					Iterable<PDDLDomain> domains = getAllDomains(nature);
					ArrayList<IPath> domainsPaths = new ArrayList<IPath>();
					for (PDDLDomain domain : domains) {
						domainsPaths.add(domain.getFile().getFullPath());
					}
					if (domainsPaths.size() > 0) {
						Object result = getSelectionDialogResult(
								domainsPaths.toArray(),
								"Pick a domain file",
								"There is not a domain file associated with this problem. Choose another domain file from project.");
						if (result != null) {
							IPath resultPath = (IPath) result;
							IResource resultFile = LaunchUtil
									.findResource(resultPath);
							workingCopy.setMappedResources(new IResource[] {
									resultFile, resource });
						} else {
							return null;
						}
					} else {

						MessageDialog.openWarning(Display.getDefault()
								.getActiveShell(), "No domian files",
								"There is no domain files in this project.");

						workingCopy.setMappedResources(new IResource[] {
								LaunchUtil.findResource(project.getFullPath()),
								resource });
					}
				}
			}
		}

		workingCopy.setAttribute(Constants.LAUNCH_CONFIG_TYPE,
				"pl.poznan.put.cs.gui4pddl.runners.PDDLApplication");

		workingCopy.setAttribute(Constants.PROJECT, projName);

		String baseDirectory = null;
		if (project != null) {
			baseDirectory = project.getLocation().toOSString();
		}

		workingCopy.setAttribute(Constants.WORKING_DIRECTORY, baseDirectory);

		workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND,
				captureOutput);
		workingCopy
				.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, captureOutput);

		workingCopy.setAttribute(DebugPlugin.ATTR_PROCESS_FACTORY_ID,
				PDDLProcessFactory.ID);

		boolean defaultPlanner = Activator.getDefault().getPreferenceStore()
				.getBoolean(Activator.PREF_DEFAULT_PLANNER);
		if (defaultPlanner) {
			String plannerName = Activator.getDefault().getPreferenceStore()
					.getString(Activator.PREF_DEFAULT_PLANNER_NAME);
			String plannerArgument = Activator.getDefault()
					.getPreferenceStore()
					.getString(Activator.PREF_DEFAULT_PLANNER_ARGUMENT_NAME);
			if (plannerName != null
					&& !plannerName.isEmpty()
					&& PlannerPreferencesManager.getManager()
							.getPlannerPreferences().containsKey(plannerName)) {
				workingCopy.setAttribute(Constants.PLANNER_NAME, plannerName);
				workingCopy.setAttribute(Constants.PLANNER,
						PlannerPreferencesManager.getManager()
								.getPlannerPreferences().get(plannerName)
								.getPlannerFilePath());

				if (plannerArgument != null && !plannerArgument.isEmpty()) {
					workingCopy.setAttribute(Constants.ARGUMENTS_NAME,
							plannerArgument);
					if (PlannerPreferencesManager.getManager()
							.getPlannerPreferences().get(plannerName)
							.getArgumentsMap().containsKey(plannerArgument)) {
						workingCopy.setAttribute(
								Constants.PLANNER_ARGUMENTS,
								PlannerPreferencesManager.getManager()
										.getPlannerPreferences()
										.get(plannerName).getArgumentsMap()
										.get(plannerArgument));
					}
				}
				workingCopy.setAttribute(Constants.FILE_NAME_REGEXP,
						PlannerPreferencesManager.getManager()
								.getPlannerPreferences().get(plannerName)
								.getPlanViewFilePattern());
			}
		}

		return workingCopy;

	}

	private static Object getSelectionDialogResult(Object[] elements,
			String title, String message) {
		final ILabelProvider labelProvider = DebugUITools
				.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				Display.getDefault().getActiveShell(), new ILabelProvider() {
					public Image getImage(Object element) {
						return labelProvider.getImage(element);
					}

					public String getText(Object element) {
						IPath path = (IPath) element;
						return path.lastSegment();
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
		dialog.setElements(elements);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setMultipleSelection(true);
		int result = dialog.open();
		labelProvider.dispose();
		if (result == Window.OK) {
			return dialog.getFirstResult();
		}
		return null;
	}

	private static String createLaunchConfigurationName(String projName,
			int size) {
		StringBuffer buffer = new StringBuffer(projName);
		buffer.append(" (");
		buffer.append(size + 1);
		buffer.append(")");
		return buffer.toString();
	}

	private static PDDLFile getPDDLFile(IFile currentlyEditedFile) {
		if (currentlyEditedFile != null) {
			IProject project = currentlyEditedFile.getProject();
			if (project != null) {
				IPDDLNature nature = PDDLNature.getPDDLNature(project);
				IPDDLCodeModel codeModel = nature.getCodeModel();
				PDDLFile file = codeModel.getFile(currentlyEditedFile, true);
				return file;
			}
		}
		return null;
	}

	private static boolean isDomainFile(PDDLFile file) {
		if (file != null) {
			if (file.getDomains().size() > 0) {
				return true;
			}
		}
		return false;
	}

	private static boolean isProblemFile(PDDLFile file) {
		if (file != null) {
			if (file.getProblems().size() > 0) {
				return true;
			}
		}
		return false;
	}

	private static Iterable<PDDLDomain> getAllDomains(IPDDLNature nature) {
		IPDDLCodeModel codeModel = nature.getCodeModel();
		return codeModel.getDomains(null);
	}

	private static IPath getDomainPath(PDDLFile file, IPDDLNature nature) {
		if (file != null) {
			IPDDLCodeModel codeModel = nature.getCodeModel();
			for (PDDLProblem problem : file.getProblems()) {
				PDDLDomain domain = codeModel.getDomain(problem);
				if (domain != null) {
					IPath domainPath = domain.getFile().getFullPath();
					return domainPath;
				}
			}
		}
		return null;
	}

	private static ArrayList<IPath> getProblemsPaths(PDDLFile file,
			IPDDLNature nature) {
		if (file != null) {
			ArrayList<IPath> result = new ArrayList<IPath>();
			IPDDLCodeModel codeModel = nature.getCodeModel();
			for (PDDLDomain domain : file.getDomains()) {
				ArrayList<PDDLProblem> problems = (ArrayList<PDDLProblem>) codeModel
						.getProblemsByDomain(domain);
				for (PDDLProblem problem : problems) {
					result.add(problem.getFile().getFullPath());
				}
				if (result != null && result.size() > 0)
					return result;
			}
		}
		return null;
	}

}
