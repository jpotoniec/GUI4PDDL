package pl.poznan.put.cs.gui4pddl.codemodel;

import org.eclipse.core.resources.IFile;

public interface IPDDLCodeModel {
	PDDLFile getFile(IFile file, boolean parse);

	PDDLFile getOrCreateFile(IFile file);
	
	void removeFile(String path);
	
	void clear();
	
	Iterable<PDDLDomain> getDomains(String name);
	
	Iterable<PDDLProblem> getProblems(String name);
	
	Iterable<PDDLInitialSituation> getInitialSituations(String name);

	PDDLDomain getDomain(PDDLProblem problem);
}
