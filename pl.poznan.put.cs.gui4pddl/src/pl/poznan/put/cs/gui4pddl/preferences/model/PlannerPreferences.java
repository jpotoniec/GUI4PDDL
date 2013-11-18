package pl.poznan.put.cs.gui4pddl.preferences.model;

import java.util.Map;

/**
 * Planner Preferences object that is stored in an xml file
 *
 */
public class PlannerPreferences {

	
	private String plannerName;
	private String plannerFilePath;
	private Map<String,String> argumentsMap;
	private String planViewFilePattern;
	
	public PlannerPreferences() {
		
	}
	
	public PlannerPreferences(String plannerName, String plannerFilePath, Map<String,String> argumentsMap, String planViewFilePattern) {
		this.plannerFilePath = plannerFilePath;
		this.plannerName = plannerName;
		this.argumentsMap = argumentsMap;
		this.planViewFilePattern = planViewFilePattern;
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
	
	public String getPlanViewFilePattern() {
		return planViewFilePattern;
	}
	
	public void setPlanViewFilePattern(String planViewFilePattern) {
		this.planViewFilePattern = planViewFilePattern;
	}
}
