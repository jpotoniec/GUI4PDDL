package pl.poznan.put.cs.gui4pddl.preferences.helpers;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.MessageDialog;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

/**
 * Planner preferences storage + operations
 * 
 */
public class PlannerPreferencesStore {

	private static Map<String, PlannerPreferences> plannerPreferencesMap = new TreeMap<String, PlannerPreferences>();
	public static String PLANNER_PREFERENCES_LOCATION = Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "planner_preferences";

	public static void loadPlannerPreferences() {
		File plannerPreferencesDir = new File(PLANNER_PREFERENCES_LOCATION);

		// if the directory does not exist, create it
		if (!plannerPreferencesDir.exists()) {
			boolean result = plannerPreferencesDir.mkdir();

			if (!result) {
				throw new RuntimeException(
						"Could not create planner preferences directory");
			}
		}
		loadPlannerPreferences(plannerPreferencesDir);
	}

	private static void loadPlannerPreferences(File plannerPreferencesDir) {
		File[] listOfFiles = plannerPreferencesDir.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.canRead()) {
				String extension = null;
				int i = file.getName().lastIndexOf('.');
				if (i > 0) {
					extension = file.getName().substring(i + 1);
				}
				if (extension != null && extension.equalsIgnoreCase("xml")) {
					XMLDecoder decoder = null;
					final String filename = file.getName();
					try {
						decoder = new XMLDecoder(new BufferedInputStream(
								new FileInputStream(file.getAbsoluteFile())));
						decoder.setExceptionListener(new ExceptionListener() {

							@Override
							public void exceptionThrown(Exception e) {
								MessageDialog.openError(Activator.getDefault()
										.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
										"Error", "Xml configuration file "
												+ filename + " is not correct");

							}
						});
					} catch (FileNotFoundException e) {
						throw new RuntimeException(
								"Could not read planner preferences file");
					}
					PlannerPreferences preferences = (PlannerPreferences) decoder
							.readObject();
					decoder.close();
					// if planner name and file path are not empty or null
					if (preferences != null
							&& preferences.getPlannerName() != null
							&& !preferences.getPlannerName().isEmpty()
							&& preferences.getPlannerFilePath() != null
							&& !preferences.getPlannerFilePath().isEmpty()) {

						boolean filenameOk = checkIfNameIsCorrect(filename);
						boolean plannerNameOk = checkIfNameIsCorrect(preferences
								.getPlannerName());
						// if names have invalid signs
						if (!filenameOk || !plannerNameOk) {
							MessageDialog
									.openError(
											Activator.getDefault()
													.getWorkbench()
													.getActiveWorkbenchWindow()
													.getShell(),
											"Error",
											"XML configuration file name and planner name in "
													+ filename
													+ " file may contain only A-Z a-z 0-9 . _ - and whitespaces.");
						} else {
							int k = filename.lastIndexOf('.');
							String name = filename.substring(0, k);
							//if xml filename and planner name in this file are not the same
							if (!name.equals(preferences.getPlannerName())) {
								MessageDialog.openError(Activator.getDefault()
										.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
										"Error", "XML configuration file name "
												+ name + " and planner name "
												+ preferences.getPlannerName()
												+ " must be the same.");
							} else {

								File f = new File(
										preferences.getPlannerFilePath());
								// if file given in planner path not exists
								if (!f.exists()) {
									MessageDialog
											.openError(
													Activator
															.getDefault()
															.getWorkbench()
															.getActiveWorkbenchWindow()
															.getShell(),
													"Error",
													"Planner script file given in "
															+ filename
															+ " configuration file does not exist.");
								} else {
									plannerPreferencesMap.put(
											preferences.getPlannerName(),
											preferences);
								}
							}
						}
					} else {
						MessageDialog
								.openError(
										Activator.getDefault().getWorkbench()
												.getActiveWorkbenchWindow()
												.getShell(),
										"Error",
										"Xml configuration file "
												+ filename
												+ " is not correct. Missing planner name or/and planner path.");
					}
				}
			}
		}
	}

	private static boolean checkIfNameIsCorrect(String name) {
		boolean validString = true;
		for (char c : name.toCharArray()) {
			if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)
					|| c == '.' || c == '_' || c == '-') {
				validString = true;

			} else {
				validString = false;
				break;
			}
		}
		if (validString) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean savePlannerPreferences(String plannerName,
			String plannerFile, Map<String, String> arguments, String planViewFilePattern,
			PlannerPreferences preferences) {

		// remove old preferences file if name changed
		if (!plannerName.equals(preferences.getPlannerName())) {
			File oldFile = new File(PLANNER_PREFERENCES_LOCATION
					+ File.separator + preferences.getPlannerName() + ".xml");

			oldFile.delete();

			plannerPreferencesMap.remove(preferences.getPlannerName());

		}

		PlannerPreferences plannerPreferences = new PlannerPreferences(
				plannerName, plannerFile, arguments, planViewFilePattern);

		plannerPreferencesMap.put(plannerName, plannerPreferences);

		XMLEncoder xmlEncoder = null;
		try {
			xmlEncoder = new XMLEncoder(new BufferedOutputStream(
					new FileOutputStream(PLANNER_PREFERENCES_LOCATION
							+ File.separator + plannerName + ".xml")));
		} catch (Exception e) {
			return false;
		}
		xmlEncoder.writeObject(plannerPreferences);
		xmlEncoder.close();

		return true;

	}

	public static boolean removePlannerPreferences(
			PlannerPreferences preferences) {

		File oldFile = new File(PLANNER_PREFERENCES_LOCATION + File.separator
				+ preferences.getPlannerName() + ".xml");

		try {
			oldFile.delete();
		} catch (Exception e) {
			return false;
		}

		plannerPreferencesMap.remove(preferences.getPlannerName());
		return true;

	}

	public static Map<String, PlannerPreferences> getPlannerPreferences() {
		return plannerPreferencesMap;
	}

}
