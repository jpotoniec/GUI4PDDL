package pl.poznan.put.cs.gui4pddl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;

public class PDDLStructureConfigHelpers {

	public static IProject getProjectHandle(String projectName) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    }

	public static void createPDDLProject(IProjectDescription description, IProject projectHandle,
			IProgressMonitor monitor) throws CoreException, OperationCanceledException {
		
		try {
			monitor.beginTask("", 2000);
			projectHandle.create(description, new SubProgressMonitor(monitor, 1000));

	        if (monitor.isCanceled()) {
	            throw new OperationCanceledException();
	        }
	        
	        projectHandle.open(IResource.BACKGROUND_REFRESH, new SubProgressMonitor(monitor, 1000));
	        
	        PDDLNature.addNature(projectHandle, monitor);
		} finally {
			monitor.done();
		}
		
	}
}
