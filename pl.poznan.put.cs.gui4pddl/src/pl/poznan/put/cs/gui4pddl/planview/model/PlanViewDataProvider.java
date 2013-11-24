package pl.poznan.put.cs.gui4pddl.planview.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.helpers.FileNameRegexProcessor;
import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class PlanViewDataProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vector<PlanViewRowData> planViewRowDataVector;

	public static String PLAN_BROWSER_DATA_LOCATION = Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "plan_browser";
	public static String PLAN_BROWSER_DATA_FILE_PATH = PLAN_BROWSER_DATA_LOCATION
			+ File.separator + "plan_browser.ser";

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
		planViewRowDataVector = new Vector<PlanViewRowData>();
	}

	public PlanViewRowData addPlanViewDataOfRunningProcess(
			ILaunchConfiguration config, File workingDir) {
		PlanViewRowData planViewRowData = new PlanViewRowData();
		try {

			String domainAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							RunnerConstants.DOMAIN_FILE, ""));
			String problemAbsolutePath = ProjectFilesPathsHelpers
					.getAbsoluteFilePathFromRelativePath(config.getAttribute(
							RunnerConstants.PROBLEM_FILE, ""));

			planViewRowData.setProjectName(config.getAttribute(
					RunnerConstants.PROJECT, ""));
			planViewRowData.setDomain(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(domainAbsolutePath));
			planViewRowData.setDomainFilePath(domainAbsolutePath);

			planViewRowData.setPlannerArguments(config.getAttribute(
					RunnerConstants.ARGUMENTS_NAME, ""));
			planViewRowData.setPlannerName(config.getAttribute(
					RunnerConstants.PLANNER_NAME, ""));
			planViewRowData.setProblem(ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(problemAbsolutePath));
			planViewRowData.setProblemFilePath(problemAbsolutePath);
			planViewRowData.setStatus(PlanViewRowData.Status.RUNNING);
			planViewRowData.setWorkingDirPath(workingDir.getAbsolutePath());
			planViewRowDataVector.add(planViewRowData);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planViewRowData;

	}

	public void setPlanFilesPathsAndMarkAsEnded(ILaunchConfiguration config,
			File workingDir, PlanViewRowData pvrd) {
		if (planViewRowDataVector.remove(pvrd) == true) {
			try {

				String regexp;
				regexp = config.getAttribute(RunnerConstants.FILE_NAME_REGEXP,
						"");
				File[] planFiles = FileNameRegexProcessor.getMatchedFiles(
						regexp, workingDir, config);
				if (planFiles.length > 0) {
					for (File f : planFiles) {
						PlanViewRowData tmp = new PlanViewRowData();
						tmp.setDomain(pvrd.getDomain());
						tmp.setDomainFilePath(pvrd.getDomainFilePath());
						tmp.setPlannerArguments(pvrd.getPlannerArguments());
						tmp.setPlannerName(pvrd.getPlannerName());
						tmp.setProblem(pvrd.getProblem());
						tmp.setProblemFilePath(pvrd.getProblemFilePath());
						tmp.setProjectName(pvrd.getProjectName());
						tmp.setStatus(pvrd.getStatus());
						tmp.setWorkingDirPath(pvrd.getWorkingDirPath());
						tmp.setPlanFilePath(f.getAbsolutePath());
						tmp.setStatus(PlanViewRowData.Status.OK);
						planViewRowDataVector.add(tmp);
					}
				} else {
					pvrd.setStatus(PlanViewRowData.Status.WRONG);
					planViewRowDataVector.add(pvrd);
				}

			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		savePlanBrowserData();
	}

	public Vector<PlanViewRowData> getPlanViewDataList() {
		return planViewRowDataVector;
	}

	public static void loadPlanBrowserDataFromFile() {
		File planBrowserDataDir = new File(PLAN_BROWSER_DATA_LOCATION);

		// if the directory does not exist, create it
		if (!planBrowserDataDir.exists()) {
			boolean result = planBrowserDataDir.mkdir();

			if (!result) {
				Log.log("Could not create plan browser data directory");
			}
		}

		try {
			FileInputStream fileIn = new FileInputStream(
					PLAN_BROWSER_DATA_FILE_PATH);
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
					PLAN_BROWSER_DATA_FILE_PATH);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(provider);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			Log.log("Could not save plan browser data");
			return false;
		}

		return true;

	}

	public void refreshPlanBrowserData() {
		ArrayList<PlanViewRowData> toRemove = new ArrayList<PlanViewRowData>();
		for (PlanViewRowData row : instance.getPlanViewDataList()) {
			if (row.getWorkingDirPath() != null) {
				File workingDir = new File(row.getWorkingDirPath());
				if (!workingDir.exists() || !workingDir.isDirectory()) {
					toRemove.add(row);
				} else {
					if (row.getPlanFilePath() != null) {
						File planFile = new File(row.getPlanFilePath());
						if (planFile.exists() && planFile.isFile()) {
							row.setStatus(PlanViewRowData.Status.OK);
						} else {
							row.setPlanFilePath(null);
							row.setStatus(PlanViewRowData.Status.WRONG);
						}
					} else {
						row.setPlanFilePath(null);
						row.setStatus(PlanViewRowData.Status.WRONG);
					}
				}
			}
		}
		instance.getPlanViewDataList().removeAll(toRemove);
	}

}
