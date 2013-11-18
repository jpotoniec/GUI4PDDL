package pl.poznan.put.cs.gui4pddl.planview.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import pl.poznan.put.cs.gui4pddl.runners.RunnerConstants;
import pl.poznan.put.cs.gui4pddl.runners.helpers.ProjectFilesPathsHelpers;

public class FileNameRegexProcessor {

	public static File[] getMatchedFiles(String regexp, File workingDir,
			ILaunchConfiguration config) {

		// TODO komunikat jesli wzorzec nie jest poprawny (bo ktos wczesniej
		// zmienial plik xml z konfiguracja)


		try {
			regexp = getRegexWithReplacements(regexp,
					RunnerConstants.REGEXP_PROJECT_NAME, Pattern.quote(config
							.getAttribute(RunnerConstants.PROJECT, "")));
			
			regexp = getRegexWithReplacements(regexp,
					RunnerConstants.REGEXP_WORKING_DIRECTORY,
					Pattern.quote(workingDir.getName()));

			String domainNameWithoutExtension = ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(ProjectFilesPathsHelpers
							.getAbsoluteFilePathFromRelativePath(config
									.getAttribute(RunnerConstants.DOMAIN_FILE,
											"")));

			regexp = getRegexWithReplacements(regexp,
					RunnerConstants.REGEXP_DOMAIN_FILE_NAME,
					Pattern.quote(domainNameWithoutExtension));

			String problemNameWithoutExtension = ProjectFilesPathsHelpers
					.getPDDLFileNameWithoutExtension(ProjectFilesPathsHelpers
							.getAbsoluteFilePathFromRelativePath(config
									.getAttribute(RunnerConstants.PROBLEM_FILE,
											"")));

			regexp = getRegexWithReplacements(regexp,
					RunnerConstants.REGEXP_PROBLEM_FILE_NAME,
					Pattern.quote(problemNameWithoutExtension));

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(regexp);

		Pattern pattern = Pattern.compile(regexp);

		File[] allFiles = workingDir.listFiles();

		List<File> matchedFiles = new ArrayList<File>();

		for (File f : allFiles) {
			if (pattern.matcher(f.getName()).matches()) {
				matchedFiles.add(f);
			}
		}
		return matchedFiles.toArray(new File[0]);
	}

	private static String getRegexWithReplacements(String regexp,
			String keyword, String replacement) {

		int index = regexp.indexOf(keyword);

		while (index >= 0) {
			regexp = replaceRegexSpecialWord(regexp, index, keyword, replacement);
			index = regexp.indexOf(keyword, index + keyword.length());
		}

		return regexp;

	}

	private static String replaceRegexSpecialWord(String regexp, int index,
			String keyword, String replacement) {
		StringBuilder sb = new StringBuilder(regexp);
		if ((index - 2 >= 0)
				&& ((index + keyword.length() + 1) < regexp.length())) {
			String subString = sb.substring(index - 2, index + keyword.length()
					+ 2);
			if (!subString.equals(Pattern.quote(keyword))) {
				sb.replace(index, index + keyword.length(), replacement);
			}
		} else if (index >= 0) {
			sb.replace(index, index + keyword.length(), replacement);
		}

		return sb.toString();
	}

}
