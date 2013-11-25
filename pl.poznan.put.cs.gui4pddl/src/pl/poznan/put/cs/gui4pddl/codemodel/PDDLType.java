package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.LinkedList;

public class PDDLType {
	
	private String name = "";
	
	private boolean isFluent;
	
	private LinkedList<PDDLType> either;
	
	private PDDLType(String name, boolean isFluent) {
		this.name = name;
		this.isFluent = isFluent;
	}
	
	@Override
	public String toString() {
		if (isFluent) {
			return String.format("F(%s)", name);
		} else {
			return name;
		}
	}
	
	public static PDDLType getDefaultType() {
		return new PDDLType("object", false);
	}
	
	public static PDDLType getType(String name) {
		return new PDDLType(name, false);
	}
	
	public static PDDLType toFluent(PDDLType type) {
		return new PDDLType(type.name, true);
	}
	
	//TODO: Do something with either directive
	
}
