package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLProblem {
	private String name;
	private String domain;
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private String situation;
	private PDDLTypedList objects = new PDDLTypedList();
	
	public PDDLProblem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addDomain(String name) {
		domain = name;
	}
	
	public String getDomain(String name) {
		return domain;
	}
	
	public void addRequirement(String name) {
		requirements.add(name);
	}
	
	public PDDLRequirementSet getRequirementSet() {
		return requirements;
	}
	
	public void addSituation(String name) {
		situation = name;
	}
	
	public String getSituation() {
		return situation;
	}
	
	public void addObjects(PDDLTypedList list) {
		objects.append(list);
	}
	
	public PDDLTypedList getObjects() {
		return objects;
	}
}
