package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.parser.PDDLIndexer;

public class PDDLCodeModel implements IPDDLCodeModel, IPDDLFileSet {

	private TreeMap<String, PDDLFile> files = new TreeMap<String, PDDLFile>();
	
	@Override
	public PDDLFile getOrCreateFile(IFile f) {
		return getOrCreateFile(f.getFullPath());
	}
	
	@Override
	public PDDLFile getOrCreateFile(IPath p) {
		String path = p.toPortableString();
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
	public PDDLFile getFile(IFile file, boolean parse) {
		PDDLFile fileIndex = files.get(file.getFullPath().toPortableString());
		if (fileIndex == null && parse) {
			try {
				PDDLIndexer.indexPDDLFile(file, this);
			} catch (RuntimeException e) {
				Log.log(e);
			}
			fileIndex = files.get(file.getFullPath().toPortableString());
		}
		return fileIndex;
	}
	
	public PDDLDomain getDomain(IPath dirpath, String domainName) {
		PDDLDomain result;
		
		if (dirpath != null ) {
			result = checkDomainFile(dirpath.append(domainName + ".pddl"), domainName);
			if (result != null)
				return result;
			result = checkDomainFile(dirpath.append("domain.pddl"), domainName);
			if (result != null)
				return result;
		}


		for (PDDLFile file : files.values()) {
			for (PDDLDomain domain : file.getDomains()) {
				if (domain.getName().equals(domainName))
					return domain;
			}
		}
		
		return null;
	}
	
	public PDDLDomain getDomain(PDDLProblem problem) {
		if (problem == null)
			return null;
		String name = problem.getDomainName();
		
		IPath dirpath = null;
		PDDLFile fileIndex = problem.getFile();
		if (fileIndex != null) {
			IPath path = fileIndex.getFullPath();
			dirpath = path.removeLastSegments(1);
		}
		
		return getDomain(dirpath, name);
	}
	
	/**
	 * Checks if a PDDL file contains domain of given name
	 * If file is not yet parsed, parsing is forced
	 * @param path
	 * @param name
	 * @return
	 */
	private PDDLDomain checkDomainFile(IPath path, String name) {
		System.out.printf("Checking domain file %s\n", path.toOSString());
		
		PDDLFile fileIndex = getFile(path, true);
		if (fileIndex == null)
			return null;
		
		for (PDDLDomain domain : fileIndex.getDomains())
		{
			if (domain.getName().equals(name))
				return domain;
		}
		
		return null;
	}
	
	private PDDLFile getFile(IPath path, boolean parse) {
		String key = path.toPortableString();
		PDDLFile fileIndex = files.get(key);
		if (fileIndex == null && parse) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = root.getFile(path);
			if (file.exists()) {
				try {
					PDDLIndexer.indexPDDLFile(file, this);
				} catch (RuntimeException e) {
					Log.log(e);
				}
				
				fileIndex = files.get(key);
				if (fileIndex == null)
					return null;
			}
		}
		return fileIndex;
	}
	
	//TODO: struktura domena -> pliki pod nia
	
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
