/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PDDLTypedList implements Iterable<PDDLTypedList.Entry>{

	static public class Entry {
		public String name;
		public PDDLType type;
	
		public String toString(){
			return String.format("(name %s type %s)",
					name,type);
			
		}
		
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
	
	public void append(PDDLTypedList right) {
		if (right == null || right.list == null)
			return;

		for(Entry e : right.list){
			this.list.add(e);
		}
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

	@Override
	public Iterator<Entry> iterator() {
		return list.iterator();
	}
	
	
	public String toString(){
		return list.toString();
	}
	
	public boolean contains(String name) {
		for(Entry e : list) {
			if (e.name != null && e.name.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
}
