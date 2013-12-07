package pl.poznan.put.cs.gui4pddl.runners.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;

public class ProjectFilesPathsHelpers {

	public static String getProjectLocation(IProject project) {
		String loc = null;
		if (project != null) {
			loc = project.getLocation().toOSString();
		} else {
			return null;
		}

		return loc;
	}

	public static String getRelativeFileLocation(IFile file) {
		String rel = null;
		if (file != null) {
			IStringVariableManager varManager = VariablesPlugin.getDefault()
					.getStringVariableManager();
			rel = file.getFullPath().makeRelative().toString();
			rel = varManager.generateVariableExpression("workspace_loc", rel);
		} else {
			return null;
		}
		return rel;
	}

	public static String getAbsoluteFilePathFromRelativePath(String relativePath)
			throws CoreException {
		IStringVariableManager varManager = VariablesPlugin.getDefault()
				.getStringVariableManager();
		String filePath = null;
		filePath = varManager.performStringSubstitution(relativePath);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			plans.refreshLocal(IResource.DEPTH_INFINITE, null);
			if (!plans.exists()) {
				plans.create( IResource.DERIVED | IResource.HIDDEN, true, null);				
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	/*public static synchronized File getWorkingDir(String basePath,
			String domainPath, String problemPath) {
		File baseDirectory = new File(basePath
				+ System.getProperty("file.separator") + "plans");
		if (!baseDirectory.exists() || !baseDirectory.isDirectory()) {
			baseDirectory.mkdir();
		}

		String domainFileNameWithoutExtension = getPDDLFileNameWithoutExtension(domainPath);
		String problemFileNameWithoutExtension = getPDDLFileNameWithoutExtension(problemPath);

		File domainDir = new File(baseDirectory.getAbsolutePath()
				+ System.getProperty("file.separator")
				+ domainFileNameWithoutExtension);

		if (!domainDir.exists() || !domainDir.isDirectory()) {
			domainDir.mkdir();
		}

		File problemDir = new File(domainDir.getAbsolutePath()
				+ System.getProperty("file.separator")
				+ problemFileNameWithoutExtension);

		if (!problemDir.exists() || !problemDir.isDirectory()) {
			problemDir.mkdir();
		}

		File numberDir = new File(problemDir.getAbsoluteFile()
				+ System.getProperty("file.separator")
				+ getFolderMaxNumber(problemDir));

		if (!numberDir.exists() || !numberDir.isDirectory()) {
			numberDir.mkdir();
		}

		return numberDir;
	}*/

	/*public static boolean deleteFile(File file) {
		if (file.exists() && file.isFile()) {
			return file.delete();
		}
		return false;
	}*/

	/*public static void deleteIFile(IFile file) {
		try {
			file.refreshLocal(IResource.DEPTH_ZERO, null);
			if (file.exists()) {
				file.delete(true, true, null);
			}
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void deleteIFolder(IFolder folder) {
		try {
			folder.refreshLocal(IResource.DEPTH_ZERO, null);
			if (folder.exists()) {
				folder.delete(true, true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	/*public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		return dir.delete(); // The directory is empty now and can be deleted.
	}
*/
}