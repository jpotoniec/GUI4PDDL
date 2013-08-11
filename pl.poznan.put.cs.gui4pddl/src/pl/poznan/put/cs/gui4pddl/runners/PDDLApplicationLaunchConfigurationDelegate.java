package pl.poznan.put.cs.gui4pddl.runners;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class PDDLApplicationLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	private IProject[] fOrderedProjects;

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		fOrderedProjects = null;

		String projName = configuration.getAttribute(RunnerConstants.PROJECT,
				"");
		if (projName.length() > 0) {

			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projName);

			if (project != null) {
				fOrderedProjects = computeReferencedBuildOrder(new IProject[] { project });
			}
		}

		// do generic launch checks
		return super.preLaunchCheck(configuration, mode, monitor);
	}

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask("Preparing configuration", 3);

		monitor.worked(1);
		try {
			UniversalPlannerRunner.run(configuration, monitor, launch);
		} catch (Exception e) {
			Log.log(e);
			finishLaunchWithError(launch);
			handleError(launch, e);
		}

	}

	private void handleError(ILaunch launch, final Exception e) {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				ErrorDialog
						.openError(
								PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
								"Invalid launch configuration",
								"Unable to make launch because launch configuration is not valid",
								new Status(IStatus.ERROR, Activator.PLUGIN_ID,
										e.getMessage(), e));
			}
		});
		finishLaunchWithError(launch);
	}

	private void finishLaunchWithError(ILaunch launch) {
		try {
			launch.terminate();

			ILaunchManager launchManager = DebugPlugin.getDefault()
					.getLaunchManager();
			launchManager.removeLaunch(launch);
		} catch (Throwable x) {
			Log.log(x);
		}

	}
}
