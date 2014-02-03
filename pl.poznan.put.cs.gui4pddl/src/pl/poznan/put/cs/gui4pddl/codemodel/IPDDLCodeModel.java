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
