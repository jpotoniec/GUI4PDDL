package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

public class UniversalPlannerRunner {

	public static Process run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		monitor.beginTask("Launch Planner", 1);
		monitor.subTask("Launch Planner");

		String commandLine = createScriptCommandLine(config);
		System.out.println(commandLine);

		String workingPath = config.getAttribute(
				RunnerConstants.WORKING_DIRECTORY, "");
		File workingDir = new File(workingPath);

		String[] cmdLine;

		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("win") >= 0) {
			cmdLine = commandLine.split(" ");
		} else {
			cmdLine = DebugPlugin.parseArguments(commandLine);
		}

		Process p = DebugPlugin.exec(cmdLine, workingDir);
		IProcess process = DebugPlugin.newProcess(launch, p, cmdLine[0]);

		while (!process.isTerminated()) {
			if (monitor.isCanceled()) {

				if (process.canTerminate())
					process.terminate();
			}
		}
		monitor.worked(1);

		monitor.done();

		return p;
	}

	private static String createScriptCommandLine(ILaunchConfiguration config)
			throws CoreException {
		String script = config.getAttribute(RunnerConstants.PLANNER, "");
		String arguments = config.getAttribute(
				RunnerConstants.PLANNER_ARGUMENTS, "");
		String domain = config.getAttribute(RunnerConstants.DOMAIN_FILE, "");
		String problem = config.getAttribute(RunnerConstants.PROBLEM_FILE, "");
		domain = LaunchConfigurationCreator
				.getAbsoluteFilePathFromRelativePath(domain);
		problem = LaunchConfigurationCreator
				.getAbsoluteFilePathFromRelativePath(problem);

		return script + " " + domain + " " + problem + " " + arguments;
	}

}
