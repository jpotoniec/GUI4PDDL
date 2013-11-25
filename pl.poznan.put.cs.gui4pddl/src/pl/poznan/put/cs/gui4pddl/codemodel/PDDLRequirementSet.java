package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Set;
import java.util.TreeSet;

public class PDDLRequirementSet {
	
	private Set<String> requirements = new TreeSet<String>();
	
	public void add(String name) {
		requirements.add(name);
	}
	
	public boolean hasRequirement(String name) {
		//TODO: This method should use requirement hierarchy
		return requirements.contains(name);
	}
	
	//TODO: Add a static list of known requirements
}
