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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.RuntimeProcess;

/**
 * RuntimeProcess subclass that can terminate the process subtree
 *
 */
public class RuntimeProcessWithChildProcessesTermination extends RuntimeProcess {

	public RuntimeProcessWithChildProcessesTermination(ILaunch launch,
			Process process, String name, Map attributes) {
		super(launch, process, name, attributes);
	}
	
	/**
	 * @see ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
	
		Process process = getSystemProcess();
		if (process != null) {
			ProcessTreeTerminator.terminateProcessTree(process);
			
		}
		super.terminate();
	}
	
	

}
