package pl.poznan.put.cs.gui4pddl.codemodel;

public interface IPDDLCodeModel {
	PDDLFile getFile(String path);
	
	PDDLFile getOrCreateFile(String path);

	void removeFile(String path);
	
	void clear();
	
	Iterable<PDDLDomain> getDomains(String name);
	
	Iterable<PDDLProblem> getProblems(String name);
	
	Iterable<PDDLInitialSituation> getInitialSituations(String name);
}
