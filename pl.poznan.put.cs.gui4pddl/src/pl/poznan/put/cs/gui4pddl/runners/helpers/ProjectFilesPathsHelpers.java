package pl.poznan.put.cs.gui4pddl.runners.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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

	public static File getWorkingDir(String basePath, String domainPath,
			String problemPath) {
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
	}

}
