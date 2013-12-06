package pl.poznan.put.cs.gui4pddl.parser;

public class PDDLError {
	enum Type {
		ERROR, WARNING;
	}

	public int charPositionInLine;
	public int line;
	public String message;
	Type type = Type.ERROR;
	
}
