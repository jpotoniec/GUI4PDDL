package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PDDLDomain {

	private PDDLFile file;
	private String name = "";
	private Set<String> extensions = new TreeSet<String>();
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private Map<String, PDDLType> types = new TreeMap<String, PDDLType>();
	private PDDLTypedList constants = new PDDLTypedList();
	private PDDLTypedList domain_vars = new PDDLTypedList();
	private List<PDDLPredicate> predicates = new ArrayList<PDDLPredicate>();
	private List<PDDLAction> actions = new ArrayList<PDDLAction>();

	public String toString() {

		return String
				.format("(domain %s extensions %s requirements %s types %s constants %s domain_vars %s predicates %s actions %s)",
						name, extensions, requirements, types, constants, domain_vars, predicates, actions);
	}

	public PDDLDomain(String name) {
		this.name = name;
	}

	public void setFile(PDDLFile file) {
		this.file = file;
	}

	public PDDLFile getFile() {
		return file;
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
		Set<String> result = types.keySet();
		result.add("object");
		return result;
	}

	public void addTypes(PDDLTypedList list) {
		for (PDDLTypedList.Entry e : list) {
			types.put(e.name, e.type);
			if (e.type != null) {
				Set<String> impliedTypes = new TreeSet<String>();
				e.type.addNames(impliedTypes);
				for (String s : impliedTypes) {
					if (!types.containsKey(s))
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

	// type == null to return all constants
	public Set<String> getConstants(PDDLType type) {
		return filterTypedList(constants, type);
	}

	public void addDomainVariable(String name, PDDLType type) {
		domain_vars.add(name, type);
	}

	public void addDomainVariables(PDDLTypedList list) {
		domain_vars.append(list);
	}

	// if type == null, returns all domain variables
	public Set<String> getDomainVariables(PDDLType type) {
		return filterTypedList(domain_vars, type);
	}

	public void addPredicate(PDDLPredicate predicate) {
		predicates.add(predicate);
	}

	public Collection<PDDLPredicate> getPredicates() {
		return predicates;
	}

	public void addAction(PDDLAction action) {
		actions.add(action);
	}

	public PDDLAction getAction(String name) {
		for (PDDLAction a : actions) {
			if (a.getFunctor().equals(name))
				return a;
		}
		return null;
	}
	
	public Collection<PDDLAction> getActions() {
		return actions;
	}

	private Set<String> filterTypedList(PDDLTypedList list, PDDLType type) {
		Set<String> result = new TreeSet<String>();
		for (PDDLTypedList.Entry e : list) {
			if ((type == null) || (isCastable(type, e.type))) {
				result.add(e.name);
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result
				+ ((constants == null) ? 0 : constants.hashCode());
		result = prime * result
				+ ((domain_vars == null) ? 0 : domain_vars.hashCode());
		result = prime * result
				+ ((extensions == null) ? 0 : extensions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((predicates == null) ? 0 : predicates.hashCode());
		result = prime * result
				+ ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDDLDomain other = (PDDLDomain) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else {
			if (!actions.equals(other.actions))
				return false;
		}

		if (constants == null) {
			if (other.constants != null)
				return false;
		} else if (!constants.equals(other.constants))
			return false;
		if (domain_vars == null) {
			if (other.domain_vars != null)
				return false;
		} else if (!domain_vars.equals(other.domain_vars))
			return false;
		if (extensions == null) {
			if (other.extensions != null)
				return false;
		} else if (!extensions.equals(other.extensions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (predicates == null) {
			if (other.predicates != null)
				return false;
		} else if (!predicates.equals(other.predicates))
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

}
