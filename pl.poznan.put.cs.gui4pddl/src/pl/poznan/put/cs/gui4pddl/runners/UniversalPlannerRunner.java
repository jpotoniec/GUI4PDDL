package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;

public class UniversalPlannerRunner {

	private static String getPDDLFileNameWithoutExtension(String path) {
		File file = new File(path);
		String fileName = file.getName();
		String fileNameWithoutExtension = fileName.substring(0,
				fileName.length() - 5);
		return fileNameWithoutExtension;
	}

	private static Integer getFolderMaxNumber(File folder) {
		File[] listOfFiles = folder.listFiles();
		List<Integer> folderNumbersList = new ArrayList<Integer>();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isDirectory()) {
				String dirName = listOfFiles[i].getName();
				try {
					int number = Integer.parseInt(dirName);
					folderNumbersList.add(number);
				} catch (NumberFormatException nfe) {
					// not a number
				}
			}
		}

		int max = folderNumbersList.size() == 0 ? 1 : Collections
				.max(folderNumbersList) + 1;

		return max;

	}

	public static String getWorkingPath(String basePath, String domainPath,
			String problemPath) {
		File baseDirectory = new File(basePath
				+ System.getProperty("file.separator") + "plans");
		if (!baseDirectory.exists() || !baseDirectory.isDirectory()) {
			baseDirectory.mkdir();
		}

		String domainFileNameWithoutExtension = getPDDLFileNameWithoutExtension(domainPath);
		String problemFileNameWithoutExtension = getPDDLFileNameWithoutExtension(problemPath);

		File domainDir = new File(baseDirectory.getAbsolutePath()
				+ System.getProperty("file.separator")
				+ domainFileNameWithoutExtension);

		if (!domainDir.exists() || !domainDir.isDirectory()) {
			domainDir.mkdir();
		}

		File problemDir = new File(domainDir.getAbsolutePath()
				+ System.getProperty("file.separator")
				+ problemFileNameWithoutExtension);

		if (!problemDir.exists() || !problemDir.isDirectory()) {
			problemDir.mkdir();
		}

		File numberDir = new File(problemDir.getAbsoluteFile()
				+ System.getProperty("file.separator")
				+ getFolderMaxNumber(problemDir));

		if (!numberDir.exists() || !numberDir.isDirectory()) {
			numberDir.mkdir();
		}

		return numberDir.getAbsolutePath();
	}

	public static Process run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		monitor.beginTask("Launch Planner", 1);
		monitor.subTask("Launch Planner");

		String[] commandLine = createScriptCommandLine(config);
		System.out.println(commandLine[3]);

		String baseDirectory = config.getAttribute(
				RunnerConstants.WORKING_DIRECTORY, "");

		String workingPath = getWorkingPath(
				baseDirectory,
				LaunchConfigurationCreator
						.getAbsoluteFilePathFromRelativePath(config
								.getAttribute(RunnerConstants.DOMAIN_FILE, "")),
				LaunchConfigurationCreator.getAbsoluteFilePathFromRelativePath(config
						.getAttribute(RunnerConstants.PROBLEM_FILE, "")));

		File workingDir = new File(workingPath);

		/*
		 * String[] cmdLine;
		 * 
		 * String OS = System.getProperty("os.name").toLowerCase(); if
		 * (OS.indexOf("win") >= 0) { cmdLine = commandLine.split(" "); } else {
		 * cmdLine = DebugPlugin.parseArguments(commandLine); }
		 */

		Process p = DebugPlugin.exec(commandLine, workingDir);
		IProcess process = DebugPlugin.newProcess(launch, p, commandLine[0]);

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

	private static String[] createScriptCommandLine(ILaunchConfiguration config)
			throws CoreException {
		List<String> cmdLine = new ArrayList<String>();
		String script = config.getAttribute(RunnerConstants.PLANNER, "");
		String argument = config.getAttribute(
				RunnerConstants.PLANNER_ARGUMENTS, "");
		String domain = config.getAttribute(RunnerConstants.DOMAIN_FILE, "");
		String problem = config.getAttribute(RunnerConstants.PROBLEM_FILE, "");
		domain = LaunchConfigurationCreator
				.getAbsoluteFilePathFromRelativePath(domain);
		problem = LaunchConfigurationCreator
				.getAbsoluteFilePathFromRelativePath(problem);

		String[] arguments = DebugPlugin.parseArguments(argument);

		cmdLine.add(script);
		cmdLine.add(domain);
		cmdLine.add(problem);
		for (String arg : arguments) {
			cmdLine.add(arg);
		}

		return cmdLine.toArray(new String[0]);
	}

}
