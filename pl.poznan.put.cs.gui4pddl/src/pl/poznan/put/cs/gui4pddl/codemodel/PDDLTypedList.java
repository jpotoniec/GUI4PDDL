package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PDDLTypedList {
	private Map<String, PDDLType> list = new TreeMap<String, PDDLType>();
	
	public void add(String name, PDDLType type) {
		if (type == null ) {
			type = PDDLType.getDefaultType();
		}
		list.put(name, type);
		System.out.printf("Added %s - %s to list\n", name, type);
	}
	
	public Set<String> getNames() {
		return list.keySet();
	}
	
	public PDDLType getType(String name) {
		return list.get(name);
	}
	
	public boolean is(String name, PDDLType type) {
		//TODO: Complex type check including hierarchy
		// Maybe implement in PDDLType
		return true;
	}
}
