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
package pl.poznan.put.cs.gui4pddl.runners;

import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IProcessFactory;
import org.eclipse.debug.core.model.IProcess;

/**
 * Creates new process that can terminate the process sub-tree
 *
 */
public class PDDLProcessFactory implements IProcessFactory {

	public static String ID = "pl.poznan.put.cs.gui4pddl.PDDLProcessFactory";
	
	@Override
	public IProcess newProcess(ILaunch launch, Process process, String label,
			Map attributes) {
		return new RuntimeProcessWithChildProcessesTermination(launch, process, label, attributes);
	}

}
