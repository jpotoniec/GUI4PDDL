package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLInitialSituation {
	private String name;
	private String domain;
	private PDDLTypedList objects = new PDDLTypedList();
	
	public PDDLInitialSituation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addDomain(String name) {
		domain = name;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public PDDLTypedList getObjects() {
		return objects;
	}
}
