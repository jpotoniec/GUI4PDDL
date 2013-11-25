package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PDDLDomain {
	
	private String name = "";
	private Set<String> extensions = new TreeSet<String>();
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private PDDLTypedList types = new PDDLTypedList();
	private PDDLTypedList constants = new PDDLTypedList();
	private PDDLTypedList domain_vars = new PDDLTypedList();
	
	public PDDLDomain(String name) {
		this.name = name;
		System.out.printf("Constructed domain %s\n", name);
	}
	
	public String getName() {
		return name;
	}
	
	public void addExtension(String name) {
		extensions.add(name);
		System.out.printf("Added extension %s\n", name);
	}
	
	public void addRequirement(String name) {
		requirements.add(name);
		System.out.printf("Added requirement %s\n", name);
	}
	
	public PDDLTypedList getTypes() {
		return types;
	}
	
	public void addType(String name, PDDLType supertype) {
		types.add(name, supertype);
		System.out.printf("Added type %s of type %s \n", name, supertype);
	}
	
	public PDDLTypedList getConstants() {
		return constants;
	}
	
	public void addDomainVar(String name, PDDLType type) {
		domain_vars.add(name, type);
		System.out.printf("Added domain var %s of type %s \n", name, type);
	}
	
}
