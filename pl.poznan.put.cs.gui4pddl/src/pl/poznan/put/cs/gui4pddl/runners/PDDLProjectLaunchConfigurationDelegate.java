package pl.poznan.put.cs.gui4pddl.runners;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

public class PDDLProjectLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	private IProject[] fOrderedProjects;

	@Override
	protected IProject[] getBuildOrder(ILaunchConfiguration configuration,
			String mode) throws CoreException {
		return fOrderedProjects;
	}

	@Override
	public boolean preLaunchCheck(final ILaunchConfiguration configuration,
			String mode, IProgressMonitor monitor) throws CoreException {
		
		fOrderedProjects = null;

		String projName = configuration.getAttribute(Constants.PROJECT, "");
		if (configuration.getAttribute(Constants.PLANNER, "").isEmpty()
				|| configuration.getAttribute(Constants.WORKING_DIRECTORY, "")
						.isEmpty()
				|| configuration.getAttribute(Constants.PROJECT, "").isEmpty()
				|| (LaunchUtil.getDomainFile(configuration) == null
						|| LaunchUtil.getDomainFile(configuration)
								.getFileExtension() == null || LaunchUtil
						.getDomainFile(configuration).getFileExtension()
						.isEmpty())
				|| (LaunchUtil.getProblemFile(configuration) == null)
				|| LaunchUtil.getProblemFile(configuration).getFileExtension() == null
				|| LaunchUtil.getProblemFile(configuration).getFileExtension()
						.isEmpty()) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					MessageDialog
							.openWarning(
									Display.getDefault().getActiveShell(),
									"Configuration not correct",
									"Configuration "
											+ configuration.getName()
											+ " is not correct. Go to Run->Run Configurations... and correct it.");
				}
			});

			return false;
		}

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
		try {
			if (monitor == null) {
				monitor = new NullProgressMonitor();
			}
			monitor.beginTask("Planning", 20);
			monitor.subTask("Creating working directory");
			IResource domainFile = LaunchUtil.getDomainFile(configuration);
			IResource problemFile = LaunchUtil.getProblemFile(configuration);
			IFolder workingDir = LaunchUtil.createWorkingDir(configuration
					.getAttribute(Constants.PROJECT, ""), domainFile
					.getRawLocation().toOSString(), problemFile
					.getRawLocation().toOSString());

			monitor.worked(2);
			monitor.subTask("Planning");
			PDDLPlannerRunner.run(configuration, monitor, launch,
					workingDir);
			Activator.refreshProject(configuration.getAttribute(
					Constants.PROJECT, ""));
			monitor.worked(18);

			monitor.subTask("Creating Plan Browser row");
			PlanView.createRowAndActivateView(configuration, workingDir);
			monitor.worked(20);
			monitor.done();
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
