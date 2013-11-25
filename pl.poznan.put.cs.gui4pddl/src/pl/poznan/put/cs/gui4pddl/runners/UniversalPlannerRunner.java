package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class UniversalPlannerRunner {

	public static Process run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch, File workingDir) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		monitor.beginTask("Launch Planner", 1);
		monitor.subTask("Launch Planner");

		String commandLine = createScriptCommandLine(config);

		String[] cmdLine;

		cmdLine = DebugPlugin.parseArguments(commandLine);

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
		String argument = config.getAttribute(
				RunnerConstants.PLANNER_ARGUMENTS, "");
		String domain = config.getAttribute(RunnerConstants.DOMAIN_FILE, "");
		String problem = config.getAttribute(RunnerConstants.PROBLEM_FILE, "");
		domain = ProjectFilesPathsHelpers
				.getAbsoluteFilePathFromRelativePath(domain);
		problem = ProjectFilesPathsHelpers
				.getAbsoluteFilePathFromRelativePath(problem);

		return "\"" + script + "\" " + "\"" + domain + "\" " + "\"" + problem
				+ "\" " + argument;

	}

}
