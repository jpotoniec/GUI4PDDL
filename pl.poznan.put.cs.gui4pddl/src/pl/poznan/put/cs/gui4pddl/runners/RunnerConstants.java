package pl.poznan.put.cs.gui4pddl.runners;

import pl.poznan.put.cs.gui4pddl.Activator;

public interface RunnerConstants {

	public static final String PROJECT = Activator.PLUGIN_ID
			+ ".ATTR_PROJECT";
	public static final String RESOURCE_TYPE = Activator.PLUGIN_ID
			+ ".ATTR_RESOURCE_TYPE";
	public static final String WORKING_DIRECTORY = "org.eclipse.ui.externaltools"
			+ ".ATTR_WORKING_DIRECTORY";
	public static final String PLANNER = "pddl_planner";
	public static final String PLANNER_NAME = "pddl_planner_name";
	
	public final static String PROBLEM_FILE = "problemFile";
	public final static String DOMAIN_FILE = "domainFile";
	public final static String PLANNER_ARGUMENTS = "arguments";
	public final static String ARGUMENTS_NAME = "arguments_name";
	
	public final static String LAUNCH_CONFIG_TYPE = "pl.poznan.put.cs.gui4pddl.runners.PDDLApplication";
	
}
