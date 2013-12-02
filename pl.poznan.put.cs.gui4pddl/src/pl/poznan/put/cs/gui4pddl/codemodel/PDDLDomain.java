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
	//TODO: set of predicates
	//TODO: actions
	
	public PDDLDomain(String name) {
		this.name = name;
		System.out.printf("Constructed domain %s\n", name);
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
		System.out.printf("Added requirement %s\n", name);
	}
	
	public boolean isSubtype(PDDLType type, PDDLType supertype) {
		//TODO: Implement accepts
		/*
		 * do
		 *    if supertype.accepts(type) return true
		 *    type = types[type.name]
		 * while type != object or null
		 */
		return true;
	}
	
	public Set<String> getTypeNames() {
		return types.keySet();
	}
	
	public void addTypes(PDDLTypedList list) {
		//TODO: Add PDDLTypedList iterator
		/*
		 * for( entry : list) {
		 * 	types.add(entry.name, entry.type)
		 * }
		 * 
		 */
	}
	
	//addConstant(name, type)
	//getConstants(PDDLType type)
	public PDDLTypedList getConstants() {
		return constants;
	}
	
	//addDomainVar(name, type)
	//getDomainsVars(PDDLType type)
	public PDDLTypedList getDomainVars() {
		return constants;
	}
	
	//private method filter(PDDLTypedList, type)
	
	//TODO: remove method
	public void addDomainVar(String name, PDDLType type) {
		domain_vars.add(name, type);
		System.out.printf("Added domain var %s of type %s \n", name, type);
	}
	
	//addPredicate <PDDLPredicate>
	//addAction <PDDLAction>
	
}
