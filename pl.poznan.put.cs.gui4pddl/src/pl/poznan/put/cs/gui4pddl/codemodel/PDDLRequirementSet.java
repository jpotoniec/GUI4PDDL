package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PDDLRequirementSet {
	
	//TODO: Fill out all requirements from pp.22 pddl.pdf
	public static String[] knownRequirements	= new String[] {
		":strips", ":typing", ":disjunctive-preconditions", ":equality",
		":existential-preconditions", ":universal-preconditions"};
	
	private static Map<String, String[]> implications;
	
	private Set<String> requirements = new TreeSet<String>();
	
	{
		implications = new TreeMap<String, String[]>();
		implications.put(":quantified-preconditions", new String[]{":existential-preconditions", ":universal-preconditions"});
		implications.put(":foreach-expansions", new String[]{":action-expansions"});
	}
	
	public void add(String name) {
		requirements.add(name);
		//TODO: also add implcations
	}
	
	//TODO: Javadoc - uses requirement hierarchy
	public boolean hasRequirement(String name) {
		return requirements.contains(name);
	}
}
