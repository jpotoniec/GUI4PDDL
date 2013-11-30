package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PDDLTypedList {

	static public class Entry {
		public String name;
		public PDDLType type;
		
		public Entry(String name, PDDLType type) {
			this.name = name;
			this.type = type;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Entry other = (Entry) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
	}
	
	private List<Entry> list = new ArrayList<PDDLTypedList.Entry>();
	
	public void add(String name, PDDLType type) {
		if (type == null)
			type = PDDLType.defaultType();
		list.add(new Entry(name, type));
	}
	
	public int size() {
		return list.size();
	}
	
	public Entry at(int index) {
		return list.get(index);
	}
	
	public PDDLType getType(String name) {
		for (Entry e: list) {
			if (e.name == name)
				return e.type;
		}
		return null;
	}
	
	public boolean hasDuplicateNames() {
		//TODO: Implementation
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		PDDLTypedList other = (PDDLTypedList) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
}
