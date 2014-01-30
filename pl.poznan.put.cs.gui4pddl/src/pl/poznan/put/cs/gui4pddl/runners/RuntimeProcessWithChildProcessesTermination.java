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
