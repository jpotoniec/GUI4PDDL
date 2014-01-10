package pl.poznan.put.cs.gui4pddl;


public interface Constants {
	
	public static final String ARGUMENTS_ICON = "icons/arguments.gif";
	public static final String MAIN_ICON = "icons/nature_image.gif";

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
	
	public final static String FILE_NAME_REGEXP = "file_name_regexp";
	
	public final static String LAUNCH_CONFIG_TYPE = "pl.poznan.put.cs.gui4pddl.runners.PDDLProjectLaunchType";
	
	
	//FILE NAME REGEXP SPECIAL EXPRESSIONS
	public final static String REGEXP_WORKING_DIRECTORY = "-working_directory-";
	public final static String REGEXP_PROJECT_NAME = "-project_name-";
	public final static String REGEXP_DOMAIN_FILE_NAME = "-domain_file_name-";
	public final static String REGEXP_PROBLEM_FILE_NAME = "-problem_file_name-";
	
}
