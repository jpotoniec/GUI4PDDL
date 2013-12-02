package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.TreeMap;

public class PDDLCodeModel implements IPDDLCodeModel {

	private TreeMap<String, PDDLFile> files = new TreeMap<String, PDDLFile>();
	
	@Override
	public PDDLFile getFile(String path) {
		return files.get(path);
	}
	
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
	
	@Override
	public Iterable<PDDLDomain> getDomains(String name) {
		ArrayList<PDDLDomain> result = new ArrayList<PDDLDomain>();
		for (PDDLFile file : files.values()) {
			for (PDDLDomain domain: file.getDomains()) {
				if ((name == null) || (name.equals(domain.getName())))
					result.add(domain);
			}
		}
		return result;
	}
	
	@Override
	public Iterable<PDDLProblem> getProblems(String name) {
		ArrayList<PDDLProblem> result = new ArrayList<PDDLProblem>();
		for (PDDLFile file : files.values()) {
			for (PDDLProblem problem: file.getProblems()) {
				if ((name == null) || (name.equals(problem.getName())))
					result.add(problem);
			}
		}
		return result;
	}
	
	@Override
	public Iterable<PDDLInitialSituation> getInitialSituations(String name) {
		ArrayList<PDDLInitialSituation> result = new ArrayList<PDDLInitialSituation>();
		for (PDDLFile file : files.values()) {
			for (PDDLInitialSituation initsit : file.getInitialSituations()) {
				if ((name == null) || (name.equals(initsit.getName())))
					result.add(initsit);
			}
		}
		return result;
	}

	@Override
	public void clear() {
		files.clear();
	}

}
