package pl.poznan.put.cs.gui4pddl.codemodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

public interface IPDDLFileSet {
	PDDLFile getOrCreateFile(IFile file);
	
	PDDLFile getOrCreateFile(IPath p);
	
	void removeFile(String path);
	
	void clear();
}
