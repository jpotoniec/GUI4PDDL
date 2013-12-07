package pl.poznan.put.cs.gui4pddl.runners;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.IDebugUIConstants;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLProblem;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

/**
 * A utility class that creates new {@link ILaunchConfiguration}s.
 * 
 * 
 */
public class LaunchConfigurationCreator {

	public static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName, IFile file) throws CoreException {
		return createDefaultLaunchConfiguration(project,
				launchConfigurationType, location, projName, "", true, file);
	}

	private static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName, String programArguments, boolean captureOutput,
			IFile file) throws CoreException {

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(launchConfigurationType);
		if (type == null) {
			throw new CoreException(new Status(IStatus.ERROR,
					"PDDL launch configuration not found", null));
		}

		String name;
		String baseDirectory = null;

		ILaunchConfiguration[] configs = manager.getLaunchConfigurations(type);

		StringBuffer buffer = new StringBuffer(projName);
		buffer.append(" (");
		buffer.append(configs.length + 1);
		buffer.append(")");

		name = buffer.toString();

		if (project != null) {
			baseDirectory = project.getLocation().toOSString();

		}

		name = manager.generateLaunchConfigurationName(name);

		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null,
				name);

		/*
		 * workingCopy.setAttribute(Constants.PROBLEM_FILE,
		 * ProjectFilesPathsHelpers.getRelativeFileLocation(file));
		 */
		IPath domain = getDomainPath(file);
	
		if (domain != null) {		
			  workingCopy .setAttribute(Constants.DOMAIN_FILE,
			  ProjectFilesPathsHelpers
			  .getRelativeFileLocation(domain));
		}
		

		workingCopy.setAttribute(Constants.LAUNCH_CONFIG_TYPE,
				"pl.poznan.put.cs.gui4pddl.runners.PDDLApplication");

		workingCopy.setAttribute(Constants.PROJECT, projName);

		workingCopy.setAttribute(Constants.WORKING_DIRECTORY, baseDirectory);

		workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND,
				captureOutput);
		workingCopy
				.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, captureOutput);

		workingCopy.setAttribute(DebugPlugin.ATTR_PROCESS_FACTORY_ID,
				PDDLProcessFactory.ID);

		return workingCopy;

	}

	private static IPath getDomainPath(IFile currentlyEditedFile) {
		if (currentlyEditedFile != null) {
			IProject project = currentlyEditedFile.getProject();
			if (project != null) {
				IPDDLNature nature = PDDLNature.getPDDLNature(project);
				IPDDLCodeModel codeModel = nature.getCodeModel();
				PDDLFile file = codeModel.getFile(currentlyEditedFile, true);
				if (file != null) {
					for (PDDLProblem problem : file.getProblems()) {
						// getProblems zwraca kolekcję, nie posiadającą metody
						// at(1)
						// lub get
						// tylko można używać iteratora
						PDDLDomain domain = codeModel.getDomain(problem);
						if (domain != null) {
							IPath domainPath = domain.getFile().getFullPath();
							return domainPath;
						}
					}
				}
			}
		}
		return null;
	}

}
