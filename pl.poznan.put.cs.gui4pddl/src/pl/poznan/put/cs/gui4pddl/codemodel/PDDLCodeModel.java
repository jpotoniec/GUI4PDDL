/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.ArrayList;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.parser.PDDLAnalyzer;

public class PDDLCodeModel implements IPDDLCodeModel, IPDDLProjectIndex {

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
				PDDLAnalyzer.indexPDDLFile(file, null);
			} catch (RuntimeException e) {
				Log.log(e);
			}
			fileIndex = files.get(file.getFullPath().toPortableString());
		}
		return fileIndex;
	}
	
	private PDDLFile getFile(IPath path, boolean parse) {
		String key = path.toPortableString();
		PDDLFile fileIndex = files.get(key);
		if (fileIndex == null && parse) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = root.getFile(path);
			if (file.exists()) {
				try {
					PDDLAnalyzer.indexPDDLFile(file, null);
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
	public Iterable<PDDLProblem> getProblemsByDomain(PDDLDomain domain) {
		ArrayList<PDDLProblem> result = new ArrayList<PDDLProblem>();
		for (PDDLFile file : files.values()) {
			for (PDDLProblem problem: file.getProblems()) {
				if (problem.getDomainName().equals(domain.getName()))
					result.add(problem);
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
