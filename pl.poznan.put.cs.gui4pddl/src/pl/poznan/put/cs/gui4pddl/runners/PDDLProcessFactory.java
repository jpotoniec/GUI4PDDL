package pl.poznan.put.cs.gui4pddl.runners;

import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IProcessFactory;
import org.eclipse.debug.core.model.IProcess;

public class PDDLProcessFactory implements IProcessFactory {

	public static String ID = "pl.poznan.put.cs.gui4pddl.PDDLProcessFactory";
	
	@Override
	public IProcess newProcess(ILaunch launch, Process process, String label,
			Map attributes) {
		return new RuntimeProcessWithChildProcessesTermination(launch, process, label, attributes);
	}

}
