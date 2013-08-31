package pl.poznan.put.cs.gui4pddl.preferences.helpers;

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

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

public class PlannerPreferencesStore {

	private static Map<String, PlannerPreferences> plannerPreferences = new TreeMap<String, PlannerPreferences>();
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
					try {
						decoder = new XMLDecoder(new BufferedInputStream(
								new FileInputStream(file.getAbsoluteFile())));
					} catch (FileNotFoundException e) {
						throw new RuntimeException(
								"Could not read planner preferences file");
					}
					PlannerPreferences preferences = (PlannerPreferences) decoder
							.readObject();
					decoder.close();
					plannerPreferences.put(preferences.getPlannerName(),
							preferences);
				}
			}
		}
	}
	
	public static boolean savePlannerPreferences(String plannerName,
			String plannerFile, Map<String, String> arguments,
			PlannerPreferences preferences) {

		// delete preferences file if name changed
		if (!plannerName.equals(preferences.getPlannerName())) {
			File oldFile = new File(PLANNER_PREFERENCES_LOCATION
					+ File.separator + preferences.getPlannerName() + ".xml");

			oldFile.delete();

			getPlannerPreferences().remove(preferences.getPlannerName());

		}

		PlannerPreferences plannerPreferences = new PlannerPreferences(
				plannerName, plannerFile, arguments);

		getPlannerPreferences().put(plannerName, plannerPreferences);

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

		File oldFile = new File(PLANNER_PREFERENCES_LOCATION
				+ File.separator + preferences.getPlannerName() + ".xml");

		try {
			oldFile.delete();
		} catch (Exception e) {
			return false;
		}

		getPlannerPreferences().remove(preferences.getPlannerName());
		return true;

	}
	
	public static Map<String, PlannerPreferences> getPlannerPreferences() {
		return plannerPreferences;
	}

}
