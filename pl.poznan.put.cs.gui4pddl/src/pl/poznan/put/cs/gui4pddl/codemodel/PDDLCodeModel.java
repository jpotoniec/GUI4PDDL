package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import org.eclipse.core.runtime.IPath;

public class PDDLCodeModel implements IPDDLCodeModel {

	private TreeMap<String, PDDLFile> files = new TreeMap<String, PDDLFile>();
	
	@Override
	public PDDLFile getOrCreateFile(String path) {
		PDDLFile file = files.get(path);
		if (file == null) {
			file = new PDDLFile(path);
			files.put(path, file);
		}
		return file;
	}

	@Override
	public void removeFile(String path) {
		files.remove(path);
	}

	public Iterable<PDDLFile> getFiles() {
		return new ArrayList<PDDLFile>(files.values());
	}
	
	@Override
	public void clear() {
		files.clear();
	}

}
