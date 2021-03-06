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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;


public class PDDLFile {
	
	private String path;	
	private Set<PDDLDomain> domains = new HashSet<PDDLDomain>();
	private Set<PDDLProblem> problems = new HashSet<PDDLProblem>();
	private Set<PDDLInitialSituation> initialSituations = new HashSet<PDDLInitialSituation>();
	
	public String toString(){
	
	
		return String.format("(file %s (domains %s))", path, domains);
	}
	
	public PDDLFile(String path) {
		this.path = path;
	}
	
	public IPath getFullPath() {
		return Path.fromPortableString(path);
	}
	
	public String getName() {
		IPath p = Path.fromPortableString(path);
		String lastSegment = p.lastSegment();
		if (lastSegment != null) {
			return lastSegment;
		}
		return null;
	}
	
	public String getPath() {
		return path;
	}
	
	public void clear() {
		domains.clear();
		problems.clear();
		initialSituations.clear();
	}
	
	public PDDLDomain getDomain(String name) {
		for (PDDLDomain domain : domains) {
			if (domain.getName().equals(name))
				return domain;
		}
		return null;
	}
	
	public Collection<PDDLDomain> getDomains() {
		return domains;
	}
	
	public PDDLProblem getProblem(String name) {
		System.out.printf("get problem == %s \n", name);
		for (PDDLProblem problem : problems) {
			System.out.printf("get problem %s\n", problem.getName());
			if (problem.getName().equals(name))
				return problem;
		}
		return null;
	}
	
	public Collection<PDDLProblem> getProblems() {
		return problems;
	}
	
	public PDDLInitialSituation getInitialSituation(String name) {
		for (PDDLInitialSituation s : initialSituations) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	public Collection<PDDLInitialSituation> getInitialSituations() {
		return initialSituations;
	}
	
	public void addProblem(PDDLProblem problem) {
		problem.setFile(this);
		problems.add(problem);
	}
	
	public void addDomain(PDDLDomain domain) {
		domain.setFile(this);
		domains.add(domain);
	}
	
	public void addInitialSituation(PDDLInitialSituation initsit) {
		initialSituations.add(initsit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domains == null) ? 0 : domains.hashCode());
		result = prime
				* result
				+ ((initialSituations == null) ? 0 : initialSituations
						.hashCode());
		result = prime * result
				+ ((problems == null) ? 0 : problems.hashCode());
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
		PDDLFile other = (PDDLFile) obj;
		if (domains == null) {
			if (other.domains != null)
				return false;
		} else if (!domains.equals(other.domains))
			return false;
		if (initialSituations == null) {
			if (other.initialSituations != null)
				return false;
		} else if (!initialSituations.equals(other.initialSituations))
			return false;
		if (problems == null) {
			if (other.problems != null)
				return false;
		} else if (!problems.equals(other.problems))
			return false;
		return true;
	}
}
