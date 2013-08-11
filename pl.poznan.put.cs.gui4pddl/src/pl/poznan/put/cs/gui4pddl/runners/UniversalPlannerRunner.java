package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

public class UniversalPlannerRunner {


	public static Process run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		IProgressMonitor subMonitor = new SubProgressMonitor(monitor, 5);

		subMonitor.beginTask("Launching Planner", 1);

		subMonitor.subTask("Constructing command_line...");

		String commandLine = createScriptCommandLine(config);

		subMonitor.subTask("Exec...");

		String workingPath = config.getAttribute(RunnerConstants.WORKING_DIRECTORY, "");
		File workingDir = new File(workingPath);

		String[] cmdLine = DebugPlugin.parseArguments(commandLine);
		Process p = DebugPlugin.exec(cmdLine, workingDir);
		DebugPlugin.newProcess(launch, p, "script");

		subMonitor.subTask("Done");
		return p;
	}

	private static String createScriptCommandLine(ILaunchConfiguration config)
			throws CoreException {
		String script = config.getAttribute(RunnerConstants.PLANNER, "");
		String arguments = config.getAttribute(
				RunnerConstants.PLANNER_ARGUMENTS, "");
		String domain = config.getAttribute(RunnerConstants.DOMAIN_FILE, "");
		String problem = config.getAttribute(RunnerConstants.PROBLEM_FILE, "");
		domain = LaunchConfigurationCreator.getAbsoluteFilePathFromRelativePath(domain);
		problem = LaunchConfigurationCreator.getAbsoluteFilePathFromRelativePath(problem);
		
		return script + " " + domain + " " + problem + " " + arguments;
	}

}
