package pl.poznan.put.cs.gui4pddl.preferences.model;

import java.util.Map;

public class PlannerPreferences {

	
	private String plannerName;
	private String plannerFilePath;
	private Map<String,String> argumentsMap;
	
	public PlannerPreferences() {
		
	}
	
	public PlannerPreferences(String plannerName, String plannerFilePath, Map<String,String> argumentsMap) {
		this.plannerFilePath = plannerFilePath;
		this.plannerName = plannerName;
		this.argumentsMap = argumentsMap;
	}

	public String getPlannerName() {
		return plannerName;
	}

	public void setPlannerName(String plannerName) {
		this.plannerName = plannerName;
	}

	public String getPlannerFilePath() {
		return plannerFilePath;
	}

	public void setPlannerFilePath(String plannerFilePath) {
		this.plannerFilePath = plannerFilePath;
	}

	public Map<String,String> getArgumentsMap() {
		return argumentsMap;
	}

	public void setArgumentsMap(Map<String,String> argumentsMap) {
		this.argumentsMap = argumentsMap;
	}
}