package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLPredicate {
	private String name;
	private PDDLTypedList parameters;
	
	public PDDLPredicate(String name, PDDLTypedList parameters) {
		this.name = name;
		this.parameters = parameters;
	}
	
	public String getName() {
		return name;
	}
	
	public PDDLTypedList getParameters() {
		return parameters;
	}
}
