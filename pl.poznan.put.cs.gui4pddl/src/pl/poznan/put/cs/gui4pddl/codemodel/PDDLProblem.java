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

import java.util.Set;
import java.util.TreeSet;

public class PDDLProblem {
	private PDDLFile file;
	private String name;
	private String domain;
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private String situation;
	private PDDLTypedList objects = new PDDLTypedList();
	private Set<String> implicitObjects = new TreeSet<String>();
	
	public PDDLProblem(String name) {
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
	
	public void addDomain(String name) {
		domain = name;
	}
	
	public String getDomainName() {
		return domain;
	}
	
	public void addRequirement(String name) {
		requirements.add(name);
	}
	
	public PDDLRequirementSet getRequirementSet() {
		return requirements;
	}
	
	public void addSituation(String name) {
		situation = name;
	}
	
	public String getSituation() {
		return situation;
	}
	
	public void addObjects(PDDLTypedList list) {
		objects.append(list);
	}
	
	public void addImplicitObject(String name) {
		implicitObjects.add(name);
	}
	
	public static Set<String> getObjectScope(PDDLProblem problem, PDDLDomain domain) {
		Set<String> scope = new TreeSet<String>();
		if (domain!=null) {
			scope.addAll(domain.getConstants(null));
		}
		if (problem != null) {
			scope.addAll(problem.implicitObjects);
			for(PDDLTypedList.Entry e : problem.objects) {
				scope.add(e.name);
			}
		}
		return scope;
	}
	
	public static Set<String> getVariableScope(PDDLProblem problem, PDDLDomain domain) {
		return new TreeSet<String>();
	}
	
	public PDDLTypedList getObjects() {
		return objects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		result = prime * result
				+ ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result
				+ ((situation == null) ? 0 : situation.hashCode());
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
		PDDLProblem other = (PDDLProblem) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (situation == null) {
			if (other.situation != null)
				return false;
		} else if (!situation.equals(other.situation))
			return false;
		return true;
	}
}
