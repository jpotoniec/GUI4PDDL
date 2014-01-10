package pl.poznan.put.cs.gui4pddl.runners.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.window.Window;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;

public class LaunchUtil {

	public static String getProjectLocation(IProject project) {
		String loc = null;
		if (project != null) {
			loc = project.getLocation().toOSString();
		} else {
			return null;
		}

		return loc;
	}

	public static IResource findResource(IPath path) {
		if (path != null) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot root = workspace.getRoot();
			IResource resource = root.findMember(path);
			return resource;
		}
		return null;
	}

	public static IResource getDomainFile(ILaunchConfiguration config) {
		if (config != null) {
			try {
				if (config.getMappedResources() != null
						&& config.getMappedResources().length > 0)
					return config.getMappedResources()[0];
			} catch (CoreException e) {
				Log.log("Cannot read domain file from mapped resources launch configuration",
						e);
			}
		}
		return null;
	}

	public static IResource getProblemFile(ILaunchConfiguration config) {
		if (config != null) {
			try {
				if (config.getMappedResources() != null
						&& config.getMappedResources().length > 1)
					return config.getMappedResources()[1];
			} catch (CoreException e) {
				Log.log("Cannot read problem file from mapped resources launch configuration",
						e);
			}
		}
		return null;
	}
	
	public static void launchAndSave(ILaunchConfiguration conf, String mode) {
		if (conf instanceof ILaunchConfigurationWorkingCopy) {
			ILaunchConfigurationWorkingCopy wc = (ILaunchConfigurationWorkingCopy) conf;
			try {
				conf = wc.doSave();
			} catch (CoreException e) {
				Log.log(e);
				e.printStackTrace();
			}
		}
		DebugUITools.launch(conf, mode);
	}

	public static int openLaunchConfigurationDialogAndSave(ILaunchConfiguration conf) {
		String groupId = IDebugUIConstants.ID_RUN_LAUNCH_GROUP;
		int result = DebugUITools.openLaunchConfigurationDialog(Activator
				.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getShell(), conf, groupId, null);
		if (result == Window.OK) {
			if (conf instanceof ILaunchConfigurationWorkingCopy) {
				ILaunchConfigurationWorkingCopy wc = (ILaunchConfigurationWorkingCopy) conf;
				try {
					conf = wc.doSave();
				} catch (CoreException e) {
					Log.log(e);
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String getRelativeFileLocation(IPath file) {
		String rel = null;
		if (file != null) {
			IStringVariableManager varManager = VariablesPlugin.getDefault()
					.getStringVariableManager();
			rel = file.makeRelative().toString();
			rel = varManager.generateVariableExpression("workspace_loc", rel);
		} else {
			return null;
		}
		return rel;
	}

	public static String getAbsoluteFilePathFromRelativePath(String relativePath) {
		IStringVariableManager varManager = VariablesPlugin.getDefault()
				.getStringVariableManager();
		String filePath = null;
		try {
			filePath = varManager.performStringSubstitution(relativePath);
		} catch (CoreException e) {
			return null;
		}
		return filePath;
	}

	public static String getPDDLFileNameWithoutExtension(String path) {
		File file = new File(path);
		String fileName = file.getName();
		String fileNameWithoutExtension = fileName.substring(0,
				fileName.length() - 5);
		return fileNameWithoutExtension;
	}

	public static Integer getFolderMaxNumber(File folder) {
		File[] listOfFiles = folder.listFiles();
		List<Integer> folderNumbersList = new ArrayList<Integer>();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isDirectory()) {
				String dirName = listOfFiles[i].getName();
				try {
					int number = Integer.parseInt(dirName);
					folderNumbersList.add(number);
				} catch (NumberFormatException nfe) {
					// not a number
				}
			}
		}

		int max = folderNumbersList.size() == 0 ? 1 : Collections
				.max(folderNumbersList) + 1;

		return max;

	}

	public static synchronized IFolder createWorkingDir(String projectName,
			String domainPath, String problemPath) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		IFolder plans = project.getFolder("plans");

		String domainFileNameWithoutExtension = getPDDLFileNameWithoutExtension(domainPath);
		String problemFileNameWithoutExtension = getPDDLFileNameWithoutExtension(problemPath);
		IFolder domain = plans.getFolder(domainFileNameWithoutExtension);
		IFolder problem = domain.getFolder(problemFileNameWithoutExtension);
		IFolder id = null;

		// at this point, no resources have been created
		if (!project.isOpen())
			try {
				project.open(null);
			} catch (CoreException e) {
				Log.log(e);
				e.printStackTrace();
			}
		try {
			plans.refreshLocal(IResource.DEPTH_INFINITE, null);
			if (!plans.exists()) {
				plans.create(IResource.DERIVED | IResource.HIDDEN, true, null);
			}
			if (!domain.exists()) {
				domain.create(IResource.DERIVED | IResource.HIDDEN, true, null);
			}
			if (!problem.exists()) {
				problem.create(IResource.DERIVED | IResource.HIDDEN, true, null);
			}
			String path = problem.getRawLocation().toOSString();
			int max = getFolderMaxNumber(new File(path));
			id = problem.getFolder(String.valueOf(max));
			if (!id.exists()) {
				id.create(IResource.DERIVED | IResource.HIDDEN, true, null);
			}

			plans.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			Log.log(e);
			e.printStackTrace();
		}

		return id;
	}
}