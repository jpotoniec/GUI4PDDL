package pl.poznan.put.cs.gui4pddl.planview.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import pl.poznan.put.cs.gui4pddl.planview.helpers.FileNameRegexProcessor;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class PlanViewDataProvider {
	private Vector<PlanViewData> planViewDataList;

	private static volatile PlanViewDataProvider instance = null;

	public static PlanViewDataProvider getInstance() {
		if (instance == null) {
			synchronized (PlanViewDataProvider.class) {
				if (instance == null) {
					instance = new PlanViewDataProvider();
				}
			}
		}

		return instance;
	}

	private PlanViewDataProvider() {
		planViewDataList = new Vector<PlanViewData>();
	}

	public PlanViewData addPlanViewDataOfRunningProcess(ILaunchConfiguration config,
			File workingDir) {
		PlanViewData planViewModel = new PlanViewData();
		try {

			String domainAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							RunnerConstants.DOMAIN_FILE, ""));
			String problemAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							RunnerConstants.PROBLEM_FILE, ""));

			
			planViewModel.setProjectName(config.getAttribute(
					RunnerConstants.PROJECT, ""));
			planViewModel.setDomain(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(domainAbsolutePath));
			planViewModel.setDomainFilePath(domainAbsolutePath);

			planViewModel.setPlannerArguments(config.getAttribute(
					RunnerConstants.ARGUMENTS_NAME, ""));
			planViewModel.setPlannerName(config.getAttribute(
					RunnerConstants.PLANNER_NAME, ""));
			planViewModel.setProblem(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(problemAbsolutePath));
			planViewModel.setProblemFilePath(problemAbsolutePath);
			planViewModel.setStatus(PlanViewData.Status.RUNNING);
			planViewModel.setWorkingDirPath(workingDir.getAbsolutePath());
			planViewDataList.add(planViewModel);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planViewModel;

	}

	public void setPlanFilesPathsAndMarkAsEnded(ILaunchConfiguration config,
			File workingDir, PlanViewData pvd) {
		if (planViewDataList.remove(pvd) == true) {
			try {

				String regexp;
				regexp = config.getAttribute(RunnerConstants.FILE_NAME_REGEXP,
						"");
				File[] planFiles = FileNameRegexProcessor.getMatchedFiles(
						regexp, workingDir, config);
				if (planFiles.length > 0) {
					for (File f : planFiles) {
						pvd.setPlanFilePath(f.getAbsolutePath());
						pvd.setStatus(PlanViewData.Status.OK);
						planViewDataList.add(pvd);
					}
				} else {
					pvd.setStatus(PlanViewData.Status.WRONG);
					planViewDataList.add(pvd);
				}

			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public List<PlanViewData> getPlanViewDataList() {
		return planViewDataList;
	}

}
