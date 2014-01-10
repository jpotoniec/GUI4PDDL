package pl.poznan.put.cs.gui4pddl.planview.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import pl.poznan.put.cs.gui4pddl.Constants;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.runners.helpers.LaunchUtil;

public class FileNameRegexProcessor {

	public static List<String> getMatchedFilesNames(String regexp,
			File workingDir, ILaunchConfiguration config) {
		try {
			regexp = getRegexWithReplacements(regexp,
					Constants.REGEXP_PROJECT_NAME, Pattern.quote(config
							.getAttribute(Constants.PROJECT, "")));

			regexp = getRegexWithReplacements(regexp,
					Constants.REGEXP_WORKING_DIRECTORY,
					Pattern.quote(workingDir.getName()));

			String domainNameWithoutExtension = LaunchUtil
					.getPDDLFileNameWithoutExtension(LaunchUtil.getDomainFile(config).getRawLocation().toOSString());

			regexp = getRegexWithReplacements(regexp,
					Constants.REGEXP_DOMAIN_FILE_NAME,
					Pattern.quote(domainNameWithoutExtension));

			String problemNameWithoutExtension = LaunchUtil
					.getPDDLFileNameWithoutExtension(LaunchUtil.getProblemFile(config).getRawLocation().toOSString());

			regexp = getRegexWithReplacements(regexp,
					Constants.REGEXP_PROBLEM_FILE_NAME,
					Pattern.quote(problemNameWithoutExtension));

		} catch (CoreException e) {
			e.printStackTrace();
		}

		List<String> matchedFiles = new ArrayList<String>();
		try {
			Pattern pattern = Pattern.compile(regexp);

			File[] allFiles = workingDir.listFiles();

			for (File f : allFiles) {
				if (pattern.matcher(f.getName()).matches()) {
					matchedFiles.add(f.getName());
				}
			}
		} catch (PatternSyntaxException e) {
			Log.log("File name regular pattern error", e);
		}

		return matchedFiles;
	}

	public static String getRegexWithReplacements(String regexp,
			String keyword, String replacement) {

		int index = regexp.indexOf(keyword);

		while (index >= 0) {
			regexp = replaceRegexSpecialWord(regexp, index, keyword,
					replacement);
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
