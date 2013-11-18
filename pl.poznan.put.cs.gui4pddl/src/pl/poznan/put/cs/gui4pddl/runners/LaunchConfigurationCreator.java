package pl.poznan.put.cs.gui4pddl.runners;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;

/**
 * A utility class that creates new {@link ILaunchConfiguration}s.
 * 
 * 
 */
public class LaunchConfigurationCreator {

	public static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName) throws CoreException {
		return createDefaultLaunchConfiguration(project,
				launchConfigurationType, location, projName, "", true);
	}



	private static ILaunchConfigurationWorkingCopy createDefaultLaunchConfiguration(
			IProject project, String launchConfigurationType, String location,
			String projName, String programArguments, boolean captureOutput)
			throws CoreException {

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

		System.out.println(project == null);
		
		if (project != null) {
			baseDirectory = project.getLocation().toOSString();

		}

		name = manager.generateLaunchConfigurationName(name);

		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null,
				name);

		workingCopy.setAttribute(RunnerConstants.LAUNCH_CONFIG_TYPE,
				"pl.poznan.put.cs.gui4pddl.runners.PDDLApplication");

		workingCopy.setAttribute(RunnerConstants.PROJECT, projName);

		workingCopy.setAttribute(RunnerConstants.WORKING_DIRECTORY,
				baseDirectory);

		workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND,
				captureOutput);
		workingCopy
				.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, captureOutput);

		workingCopy.setAttribute(DebugPlugin.ATTR_PROCESS_FACTORY_ID,
				PDDLProcessFactory.ID);

		if (workingCopy.getAttribute(RunnerConstants.PLANNER, "").isEmpty()
				|| workingCopy.getAttribute(RunnerConstants.WORKING_DIRECTORY,
						"").isEmpty()
				|| workingCopy.getAttribute(RunnerConstants.PROJECT, "")
						.isEmpty()
				|| workingCopy.getAttribute(RunnerConstants.DOMAIN_FILE, "")
						.isEmpty()
				|| workingCopy.getAttribute(RunnerConstants.PROBLEM_FILE, "")
						.isEmpty()) {

			ILaunchGroup group = DebugUITools.getLaunchGroup(workingCopy,
					ILaunchManager.RUN_MODE);
			String groupID = group.getIdentifier();
			int result = DebugUITools.openLaunchConfigurationDialog(PlatformUI
					.getWorkbench().getActiveWorkbenchWindow().getShell(),
					workingCopy, groupID, null);
			if (result == Window.OK) {
				return workingCopy;
			}

		}

		return null;

	}
}
