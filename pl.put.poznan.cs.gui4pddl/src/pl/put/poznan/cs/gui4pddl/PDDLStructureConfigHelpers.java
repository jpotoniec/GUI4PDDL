package pl.put.poznan.cs.gui4pddl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

public class PDDLStructureConfigHelpers {

	public static IProject getProjectHandle(String projectName) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    }

}
