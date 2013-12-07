package pl.poznan.put.cs.gui4pddl.runners;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;

import pl.poznan.put.cs.gui4pddl.Activator;

public class PDDLLaunchShortcutWithDialog extends PDDLLaunchShortcut {

	/**
	 * Launch the given targets in the given build file. The targets are
	 * launched in the given mode.
	 * 
	 * @param resources
	 *            the resources to launch
	 * @param mode
	 *            the mode in which the file should be executed
	 */
	protected void launch(IProject project, String mode, IFile file) {

		String groupId = IDebugUIConstants.ID_RUN_LAUNCH_GROUP;

		ILaunchConfiguration conf = createDefaultLaunchConfiguration(project, file);

		if (conf != null) {
			DebugUITools.openLaunchConfigurationDialog(Activator.getDefault()
					.getWorkbench().getActiveWorkbenchWindow().getShell(),
					conf, groupId, null);
		}

	}

	public ILaunchConfiguration createDefaultLaunchConfiguration(
			IProject project, IFile file) {
		try {
			ILaunchConfigurationWorkingCopy createdConfiguration = createDefaultLaunchConfigurationWithoutSaving(project, file);

			if (createdConfiguration == null) {
				return null;
			}

			return createdConfiguration.doSave();
		} catch (CoreException e) {
			reportError(null, e);
			return null;
		}
	}

}
