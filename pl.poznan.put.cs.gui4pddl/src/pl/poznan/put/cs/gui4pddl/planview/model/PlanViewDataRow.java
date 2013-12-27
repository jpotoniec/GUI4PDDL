package pl.poznan.put.cs.gui4pddl.planview.model;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;

public class PlanViewDataRow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String projectName;
	private String domain;
	private String problem;
	private String plannerName;
	private String domainFilePath;
	private String problemFilePath;
	private String id;

	private List<String> planFileNames;
	private String plannerArguments;

	public PlanViewDataRow() {

	}

	public PlanViewDataRow(String projectName, String domain, String problem,
			String id, String plannerName, String domainFilePath,
			String problemFilePath, List<String> planFileNames,
			String plannerArguments) {
		super();
		this.projectName = projectName;
		this.domain = domain;
		this.problem = problem;
		this.id = id;
		this.plannerName = plannerName;
		this.domainFilePath = domainFilePath;
		this.problemFilePath = problemFilePath;
		this.planFileNames = planFileNames;
		this.plannerArguments = plannerArguments;

	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getPlanFileNames() {
		return planFileNames;
	}

	public void setPlanFileNames(List<String> planFileNames) {
		this.planFileNames = planFileNames;
	}

	public String getPlannerArguments() {
		return plannerArguments;
	}

	public void setPlannerArguments(String plannerArguments) {
		this.plannerArguments = plannerArguments;
	}

	public IFolder getWorkingFolder() {
		return ResourcesPlugin.getWorkspace().getRoot()
				.getProject(getProjectName()).getFolder("plans")
				.getFolder(getDomain()).getFolder(getProblem())
				.getFolder(getId());
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(this.getClass().equals(o.getClass())))
			return false;
		PlanViewDataRow another = (PlanViewDataRow) o;
		return (null == getProjectName() ? null == another.getProjectName()
				: getProjectName().equals(another.getProjectName()))
				&& (null == getDomain() ? null == another.getDomain()
						: getDomain().equals(another.getDomain()))
				&& (null == getProblem() ? null == another.getProblem()
						: getProblem().equals(another.getProblem()))
				&& (null == getId() ? null == another.getId() : getId().equals(
						another.getId()));
	}

}
