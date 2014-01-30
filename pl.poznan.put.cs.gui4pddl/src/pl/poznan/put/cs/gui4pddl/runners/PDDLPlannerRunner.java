package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

/**
 * PDDL runner class
 *
 */
public class PDDLPlannerRunner {

	public static IProcess run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch, IFolder workingDir) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		IProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
		
		subMonitor.subTask("Launch Planner");
		
		String commandLine = createScriptCommandLine(config);

		String[] cmdLine;

		cmdLine = DebugPlugin.parseArguments(commandLine);

		Process p = DebugPlugin.exec(cmdLine, new File(workingDir.getRawLocation().toOSString()));
		IProcess process = DebugPlugin.newProcess(launch, p, cmdLine[0]);
		subMonitor.worked(1);
		
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			Log.log(e);
			e.printStackTrace();
		}


		subMonitor.done();

		return process;
	}

	private static String createScriptCommandLine(ILaunchConfiguration config)
			throws CoreException {

		String script = config.getAttribute(Constants.PLANNER, "");
		String argument = config.getAttribute(
				Constants.PLANNER_ARGUMENTS, "");
		String domain = LaunchUtil.getDomainFile(config).getRawLocation().toOSString();
		String problem = LaunchUtil.getProblemFile(config).getRawLocation().toOSString();

		System.out.println("\"" + script + "\" " + "\"" + domain + "\" " + "\"" + problem
				+ "\" " + argument);
		return "\"" + script + "\" " + "\"" + domain + "\" " + "\"" + problem
				+ "\" " + argument;

	}

}
