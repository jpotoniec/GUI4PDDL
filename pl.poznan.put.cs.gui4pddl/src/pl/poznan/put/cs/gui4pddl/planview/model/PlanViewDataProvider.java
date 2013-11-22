package pl.poznan.put.cs.gui4pddl.planview.model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.planview.helpers.FileNameRegexProcessor;
import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class PlanViewDataProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vector<PlanViewData> planViewDataList;

	public static String PLAN_BROWSER_DATA_LOCATION = Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "plan_browser";

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

	public PlanViewData addPlanViewDataOfRunningProcess(
			ILaunchConfiguration config, File workingDir) {
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
		savePlanBrowserData();
	}

	public Vector<PlanViewData> getPlanViewDataList() {
		return planViewDataList;
	}

	public static void loadPlanBrowserDataFromFile() {
		File planBrowserDataDir = new File(PLAN_BROWSER_DATA_LOCATION);

		// if the directory does not exist, create it
		if (!planBrowserDataDir.exists()) {
			boolean result = planBrowserDataDir.mkdir();

			if (!result) {
				throw new RuntimeException(
						"Could not create planner preferences directory");
			}
		}

		try {
			FileInputStream fileIn = new FileInputStream(
					PLAN_BROWSER_DATA_LOCATION
							+ System.getProperty("file.separator")
							+ "plan_browser.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			instance = (PlanViewDataProvider) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {

			c.printStackTrace();
			return;
		}

	}

	public static boolean savePlanBrowserData() {
		PlanViewDataProvider provider = getInstance();
		try {
			FileOutputStream fileOut = new FileOutputStream(
					PLAN_BROWSER_DATA_LOCATION
							+ System.getProperty("file.separator")
							+ "plan_browser.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(provider);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		}

		return true;

	}

	public void checkIfPlansFilesExistsAndRefreshData() {
		for (PlanViewData row : instance.getPlanViewDataList()) {
			if (row.getPlanFilePath() != null) {
				File f = new File(row.getPlanFilePath());
				if (f.exists() && f.isFile()) {
					row.setStatus(PlanViewData.Status.OK);
				} else {
					row.setPlanFilePath(null);
					row.setStatus(PlanViewData.Status.WRONG);
				}
			}
		}
	}

}
