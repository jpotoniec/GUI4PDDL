package pl.poznan.put.cs.gui4pddl.codemodel;

public interface IPDDLCodeModel {
	PDDLFile getOrCreateFile(String path);

	void removeFile(String path);
	
	void clear();
}
