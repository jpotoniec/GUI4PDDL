package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;


public class PDDLFile {
	
	private String path;	
	private Set<PDDLDomain> domains = new TreeSet<PDDLDomain>();
	private Set<PDDLProblem> problems = new TreeSet<PDDLProblem>();
	private Set<PDDLInitialSituation> initialSituations = new TreeSet<PDDLInitialSituation>();
	
	public PDDLFile(String path) {
		this.path = path;
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
		problems.add(problem);
	}
	
	public void addDomain(PDDLDomain domain) {
		domains.add(domain);
	}
	
	public void addInitialSituation(PDDLInitialSituation initsit) {
		initialSituations.add(initsit);
	}
}
