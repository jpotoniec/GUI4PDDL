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
package pl.poznan.put.cs.gui4pddl.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLProjectIndex;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class Builder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "pl.poznan.put.cs.gui4pddl.PDDLParser";
	
	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		
		IProject project = getProject();
		if (project == null)
			return null;

		if ((kind == INCREMENTAL_BUILD) || (kind == AUTO_BUILD)) {
			IResourceDelta delta = getDelta(project);
			if (delta == null ) {
				project.accept(new PDDLVisitor());
			} else {
				delta.accept(new PDDLVisitor());
			}
		} else if (kind == FULL_BUILD ){
			project.accept(new PDDLVisitor());
		} else if (kind == CLEAN_BUILD ) {
			IPDDLNature nature = PDDLNature.getPDDLNature(project);
			if (nature != null) {
				IPDDLProjectIndex index = nature.getPDDLProjectIndex();
				if (index != null)
					index.clear();
			}
		}

		return null;
	}
	
/*	protected List<IFile> getAllIFiles(IContainer container) throws RuntimeException {
		final ArrayList<IFile> ret = new ArrayList<IFile>();
		ret.clear();
		
		try {
            container.accept(new IResourceVisitor() {

                public boolean visit(IResource resource) {
                    if (resource instanceof IFile) {
                        ret.add((IFile) resource);
                        return false; //has no members
                    }
                    return true;
                }

            });
        } catch (CoreException e) {
            throw new RuntimeException(e);
        }
        return ret;
	}
*/

	public static void addBuilderToProject(IProject project) {
		if (!project.isOpen())
			return;

		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			Log.log(e);
			return;
		}

		ICommand[] cmds = description.getBuildSpec();
		for (int j = 0; j < cmds.length; j++)
			if (cmds[j].getBuilderName().equals(BUILDER_ID))
				return;
		
		// Associate builder with project.
		ICommand newCmd = description.newCommand();
		newCmd.setBuilderName(BUILDER_ID);
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.add(newCmd);
		description.setBuildSpec((ICommand[]) newCmds
				.toArray(new ICommand[newCmds.size()]));
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			Log.log(e);
		}
	}
}
