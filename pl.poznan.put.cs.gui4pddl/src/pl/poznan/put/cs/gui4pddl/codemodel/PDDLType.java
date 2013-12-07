package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.List;
import java.util.ArrayList;
/**
 *Representation of PDDL type. 
 *
 *
 */
public class PDDLType {
	
	private String name;
	
	private PDDLType fluent;
	
	private ArrayList<PDDLType> either;
	
	private PDDLType() {
	}
	
	/**
	 * Creates a default type. Default type in PDDL is object.
	 * 
	 * @return default type
	 */
	public static PDDLType defaultType() {
		PDDLType ret = new PDDLType();
		ret.name = "object";
		return ret;
	}
	
	/**
	 * Creates a simple type with a name.
	 * @param name name of the type
	 * @return simple type with a name
	 */
	public static PDDLType simpleType(String name) {
		PDDLType ret = new PDDLType();
		ret.name = name;
		return ret;
	}
	/**
	 * Creates the type of an object whose value varies from situation to situation,
	 * and is always of type t.
	 * @param type type of object
	 * @return fluent type
	 */
	public static PDDLType fluentType(PDDLType type) {
		PDDLType ret = new PDDLType();
		ret.fluent = type;
		return ret;
	}
	/**
	 * Creates the either type, union of types.
	 * @param list list of a types
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
