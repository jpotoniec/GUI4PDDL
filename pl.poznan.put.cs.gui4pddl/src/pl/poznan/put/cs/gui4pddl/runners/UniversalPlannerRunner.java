package pl.poznan.put.cs.gui4pddl.runners;

import java.io.File;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import pl.poznan.put.cs.gui4pddl.planview.helpers.FileNameRegexProcessor;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewModel;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewModelProvider;
import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class UniversalPlannerRunner {

	public static Process run(ILaunchConfiguration config,
			IProgressMonitor monitor, ILaunch launch) throws CoreException {

		if (monitor == null)
			monitor = new NullProgressMonitor();
		monitor.beginTask("Launch Planner", 1);
		monitor.subTask("Launch Planner");

		String commandLine = createScriptCommandLine(config);

		String baseDirectory = config.getAttribute(
				RunnerConstants.WORKING_DIRECTORY, "");

		String workingPath = ProjectFilesPathsHelpers
				.getWorkingPath(
						baseDirectory,
						ProjectFilesPathsHelpers.getAbsoluteFilePathFromRelativePath(config
								.getAttribute(RunnerConstants.DOMAIN_FILE, "")),
						ProjectFilesPathsHelpers
								.getAbsoluteFilePathFromRelativePath(config
										.getAttribute(
												RunnerConstants.PROBLEM_FILE,
												"")));

		File workingDir = new File(workingPath);

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

		openPlan(config, workingDir);

		monitor.done();

		return p;
	}

	private static void openPlan(ILaunchConfiguration config, File workingDir)
			throws CoreException {
		String regexp = config.getAttribute(RunnerConstants.FILE_NAME_REGEXP,
				"");
		File[] planFiles = FileNameRegexProcessor.getMatchedFiles(regexp,
				workingDir, config);

		String domainAbsolutePath = ProjectFilesPathsHelpers
				.getAbsoluteFilePathFromRelativePath(config.getAttribute(
						RunnerConstants.DOMAIN_FILE, ""));
		String problemAbsolutePath = ProjectFilesPathsHelpers
				.getAbsoluteFilePathFromRelativePath(config.getAttribute(
						RunnerConstants.PROBLEM_FILE, ""));

		for (File f : planFiles) {
			System.out.println("PLAN FILE" + f.getName());
			PlanViewModel planViewModel = new PlanViewModel();
			planViewModel.setDomain(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(domainAbsolutePath));
			planViewModel.setDomainFilePath(domainAbsolutePath);
			planViewModel.setPlanFilePath(config.getAttribute(
					RunnerConstants.PLANNER, ""));
			planViewModel.setPlannerArguments(config.getAttribute(
					RunnerConstants.ARGUMENTS_NAME, ""));
			planViewModel.setPlannerName(config.getAttribute(
					RunnerConstants.PLANNER_NAME, ""));
			planViewModel.setProblem(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(problemAbsolutePath));
			planViewModel.setProblemFilePath(problemAbsolutePath);
			planViewModel.setStatus(PlanViewModel.Status.OK);
			planViewModel.setWorkingDirPath(workingDir.getAbsolutePath());
			PlanViewModelProvider.add(planViewModel);
		}

		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					PlanView view = (PlanView) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.showView(PlanView.ID);
					view.setInput(PlanViewModelProvider.getPlanViewModel());
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	

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
