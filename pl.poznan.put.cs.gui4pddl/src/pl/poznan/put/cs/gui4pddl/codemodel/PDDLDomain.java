package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PDDLDomain {
	
	private String name = "";
	private Set<String> extensions = new TreeSet<String>();
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private Map<String,PDDLType> types = new TreeMap<String, PDDLType>();
	private PDDLTypedList constants = new PDDLTypedList();
	private PDDLTypedList domain_vars = new PDDLTypedList();
	private Set<PDDLPredicate> predicates = new TreeSet<PDDLPredicate>();
	private Set<PDDLAction> actions = new TreeSet<PDDLAction>();
	
	public PDDLDomain(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addExtension(String name) {
		extensions.add(name);
	}
	
	public Set<String> getExtensions() {
		return extensions;
	}
	
	public void addRequirement(String name) {
		requirements.add(name);
	}
	
	public PDDLRequirementSet getRequirementSet() {
		return requirements;
	}
	
	public boolean isCastable(PDDLType required, PDDLType actual) {
		
		if (required == null)
			return true;
		if (actual == null)
			return false;
		
		if (required.equals(PDDLType.defaultType()))
			return true;
		
		do {	
			if (required.isCastable(actual))
				return true;
			String name = actual.getName();
			if (name != null) 
				actual = types.get(name);
			else
				actual = null;
		} while (actual != null);
		
		return false;
	}
	
	public Set<String> getTypeNames() {
		Set<String> result =  types.keySet();
		result.add("object");
		return result;
	}
	
	public void addTypes(PDDLTypedList list) {
		for (PDDLTypedList.Entry e : list) {
			types.put(e.name, e.type);
			if (e.type != null) {
				Set<String> impliedTypes = new TreeSet<String>();
				e.type.addNames(impliedTypes);
				for(String s : impliedTypes) {
					if( !types.containsKey(s))
						types.put(s, PDDLType.defaultType());
				}
			}
		}
	}
	
	public void addConstant(String name, PDDLType type) {
		constants.add(name, type);
	}
	
	public void addConstants(PDDLTypedList list) {
		constants.append(list);
	}
	
	//type == null to return all constants
	public Set<String> getConstants(PDDLType type) {
		return filterTypedList(constants, type);
	}
	
	public void addDomainVariable(String name, PDDLType type) {
		domain_vars.add(name, type);
	}
	
	public void addDomainVariables(PDDLTypedList list) {
		domain_vars.append(list);
	}
	
	//if type == null, returns all domain variables 
	public Set<String> getDomainVariables(PDDLType type) {
		return filterTypedList(domain_vars, type);
	}

	public void addPredicate(PDDLPredicate predicate) {
		predicates.add(predicate);
	}
	
	public Set<PDDLPredicate> getPredicates() {
		return predicates;
	}
	
	public void addAction(PDDLAction action) {
		actions.add(action);
	}
	
	public Set<PDDLAction> getActions() {
		return actions;
	}
	
	private Set<String> filterTypedList(PDDLTypedList list, PDDLType type) {
		Set<String> result = new TreeSet<String>();
		for(PDDLTypedList.Entry e: list) {
			if ((type == null) || (isCastable(type, e.type))) {
				result.add(e.name);
			}
		}
		return result;
	}
}
