package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.List;
import java.util.ArrayList;

/**
 *Representation of PDDL type. 
 *
 *
 */

import java.util.Set;

public class PDDLType {

	private String name;

	private PDDLType fluent;

	private ArrayList<PDDLType> either;

	private PDDLType() {
	}

	public String toString() {
		if (name != null && !name.equals(""))
			return name;
		else if (fluent != null)
			return String.format("(fluent %s)", fluent);
		else if (either != null)
			return String.format("(Either %s)", either);
		return null;

	}

	/**
	 * Creates a default type. Default type in PDDL is object.
	 * 
	 * @return default type
	 */

	public String getName() {
		if (isFluent())
			return fluent.getName();
		else
			return name;
	}

	public void addNames(Set<String> names) {
		if (either == null)
			names.add(getName());
		else {
			for (PDDLType t : either) {
				t.addNames(names);
			}
		}
	}

	public boolean isFluent() {
		return fluent != null;
	}

	// Checks if type st can be casted to type this
	// This doesn't check types hierarchy specified in domain
	public boolean isCastable(PDDLType st) {
		if (st == null)
			return false;

		String name = getName();

		if (name != null) {
			String stName = st.getName();
			if (name.equals(stName))
				return true;
			else
				return false;
		}

		if (either != null) {
			for (PDDLType et : either) {
				if (et.isCastable(st))
					return true;
			}
		}
		return false;
	}

	public static PDDLType defaultType() {
		return simpleType("object");
	}

	/**
	 * Creates a simple type with a name.
	 * 
	 * @param name
	 *            name of the type
	 * @return simple type with a name
	 */
	public static PDDLType simpleType(String name) {
		PDDLType ret = new PDDLType();
		ret.name = name;
		return ret;
	}

	/**
	 * Creates the type of an object whose value varies from situation to
	 * situation, and is always of type t.
	 * 
	 * @param type
	 *            type of object
	 * @return fluent type
	 */
	public static PDDLType fluentType(PDDLType type) {
		PDDLType ret = new PDDLType();
		ret.fluent = type;
		return ret;
	}

	/**
	 * Creates the either type, union of types.
	 * 
	 * @param list
	 *            list of a types
	 * @return either type
	 */
	public static PDDLType eitherType(List<PDDLType> list) {
		PDDLType ret = new PDDLType();
		ret.either = new ArrayList<PDDLType>(list);
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((either == null) ? 0 : either.hashCode());
		result = prime * result + ((fluent == null) ? 0 : fluent.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PDDLType other = (PDDLType) obj;
		if (either == null) {
			if (other.either != null)
				return false;
		} else if (!either.equals(other.either))
			return false;
		if (fluent == null) {
			if (other.fluent != null)
				return false;
		} else if (!fluent.equals(other.fluent))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
