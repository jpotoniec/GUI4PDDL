package pl.poznan.put.cs.gui4pddl.codemodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

public interface IPDDLCodeModel {
	
	/**
	 * Returns file index for Eclipse File Resource
	 * @param file
	 * @param parse if true and file index is not in memory, 
	 * 		invokes file parsing
	 * @return
	 */
	PDDLFile getFile(IFile file, boolean parse);
	
	/**
	 * Finds domain for a problem.
	 */
	PDDLDomain getDomain(PDDLProblem problem);
	
	//TODO: Javadoc
	PDDLDomain getDomain(IPath dirpath, String domainName);
	
	/**
	 * Returns a list of domains in project filtered by name.
	 * If name is null - returns all domains.
	 */
	Iterable<PDDLDomain> getDomains(String name);
	
	/**
	 * Calculates a list of problems that reference given domain
	 */
	Iterable<PDDLProblem> getProblemsByDomain(PDDLDomain domain);
	
	/**
	 * Returns a list of problems in project filtered by name.
	 * If name is null - returns all problems.
	 */
	Iterable<PDDLProblem> getProblems(String name);
	
	Iterable<PDDLInitialSituation> getInitialSituations(String name);
}
