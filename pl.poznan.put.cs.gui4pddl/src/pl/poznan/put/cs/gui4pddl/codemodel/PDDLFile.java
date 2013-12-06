package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;


public class PDDLFile {
	
	private String path;	
	private Set<PDDLDomain> domains = new TreeSet<PDDLDomain>();
	private Set<PDDLProblem> problems = new TreeSet<PDDLProblem>();
	private Set<PDDLInitialSituation> initialSituations = new TreeSet<PDDLInitialSituation>();
	
	public PDDLFile(String path) {
		this.path = path;
	}
	
	public IPath getFullPath() {
		return Path.fromPortableString(path);
	}
	
	public String getPath() {
		return path;
	}
	
	public void clear() {
		domains.clear();
		problems.clear();
		initialSituations.clear();
	}
	
	public Collection<PDDLDomain> getDomains() {
		return domains;
	}
	
	public Collection<PDDLProblem> getProblems() {
		return problems;
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
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (problems == null) {
			if (other.problems != null)
				return false;
		} else if (!problems.equals(other.problems))
			return false;
		return true;
	}
}
