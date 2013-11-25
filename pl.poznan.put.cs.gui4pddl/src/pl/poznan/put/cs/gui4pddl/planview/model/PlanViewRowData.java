package pl.poznan.put.cs.gui4pddl.planview.model;

import java.io.File;
import java.io.Serializable;


public class PlanViewRowData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Status {
		RUNNING("Running"), OK("Ok"), WRONG("Wrong");

		private final String text;	

		private Status(String s) {
			text = s;
		
		}

		public String toString() {
			return text;
		}
		
	}

	private String projectName;
	private String domain;
	private String problem;
	private String plannerName;
	private String domainFilePath;
	private String problemFilePath;
	private String id;
	private String workingDirPath;
	
	private transient Status status;

	private String planFilePath;
	private String plannerArguments;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getPlannerName() {
		return plannerName;
	}

	public void setPlannerName(String plannerName) {
		this.plannerName = plannerName;
	}

	public String getDomainFilePath() {
		return domainFilePath;
	}

	public void setDomainFilePath(String domainFilePath) {
		this.domainFilePath = domainFilePath;
	}

	public String getProblemFilePath() {
		return problemFilePath;
	}

	public void setProblemFilePath(String problemFilePath) {
		this.problemFilePath = problemFilePath;
	}

	public String getWorkingDirPath() {
		return workingDirPath;
	}

	public void setWorkingDirPath(String workingDirPath) {
		File f = new File(workingDirPath);
		if (f.exists() && f.isDirectory()) {
			id = f.getName();
		}
		this.workingDirPath = workingDirPath;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPlanFilePath() {
		return planFilePath;
	}

	public void setPlanFilePath(String planFilePath) {
		this.planFilePath = planFilePath;
	}

	public String getPlannerArguments() {
		return plannerArguments;
	}

	public void setPlannerArguments(String plannerArguments) {
		this.plannerArguments = plannerArguments;
	}

	public String getId() {
		return id;
	}

}
