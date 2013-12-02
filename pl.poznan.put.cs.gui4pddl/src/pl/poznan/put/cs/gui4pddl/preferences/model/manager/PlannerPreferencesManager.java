package pl.poznan.put.cs.gui4pddl.preferences.model.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;
import org.osgi.framework.Bundle;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

/**
 * Planner preferences storage + operations
 * 
 */
public class PlannerPreferencesManager {

	private static final String TAG_PLANNER_PREFERENCES = "PlannerPreferences";
	private static final String TAG_PLANNER_NAME = "PlannerName";
	private static final String TAG_PLANNER_FILE_PATH = "PlannerFilePath";
	private static final String TAG_PLAN_VIEW_FILE_PATTERN = "PlanViewFilePattern";
	private static final String TAG_PLANNER_ARGUMENTS = "PlannerArguments";
	private static final String TAG_PLANNER_ARGUMENTS_ENTRY = "PlannerArgumentsEntry";
	private static final String TAG_PLANNER_ARGUMENT_KEY = "PlannerArgumentKey";
	private static final String TAG_PLANNER_ARGUMENT_VALUE = "PlannerArgumentValue";

	private static Map<String, PlannerPreferences> plannerPreferencesMap;

	public static String PLANNER_PREFERENCES_LOCATION = Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "planner_preferences";

	private static volatile PlannerPreferencesManager instance = null;

	public static PlannerPreferencesManager getManager() {
		if (instance == null) {
			synchronized (PlanViewDataManager.class) {
				if (instance == null) {
					instance = new PlannerPreferencesManager();
				}
			}
		}

		return instance;
	}

	private PlannerPreferencesManager() {
	}

	public void loadPlannerPreferences() {
		plannerPreferencesMap = new TreeMap<String, PlannerPreferences>();
		File[] listOfFiles = getPlannerPreferencesDir().listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.canRead()) {
				String extension = null;
				int i = file.getName().lastIndexOf('.');
				if (i > 0) {
					extension = file.getName().substring(i + 1);
				}
				if (extension != null && extension.equalsIgnoreCase("xml")) {
					final String filename = file.getName();

					PlannerPreferences preferences = loadPlannerPreferences(file
							.getAbsolutePath());
					// if planner name and file path are not empty or null
					if (preferences != null
							&& preferences.getPlannerName() != null
							&& !preferences.getPlannerName().isEmpty()
					/*
					 * && preferences.getPlannerFilePath() != null &&
					 * !preferences.getPlannerFilePath().isEmpty()
					 */) {

						boolean filenameOk = checkIfNameIsCorrect(filename);
						boolean plannerNameOk = checkIfNameIsCorrect(preferences
								.getPlannerName());
						// if names have invalid signs
						/*
						 * if (!filenameOk || !plannerNameOk) { MessageDialog
						 * .openError( Activator.getDefault() .getWorkbench()
						 * .getActiveWorkbenchWindow() .getShell(), "Error",
						 * "XML configuration file name and planner name in " +
						 * filename +
						 * " file may contain only A-Z a-z 0-9 . _ - and whitespaces."
						 * ); } else {
						 */
						if (filenameOk && plannerNameOk) {
							int k = filename.lastIndexOf('.');
							String name = filename.substring(0, k);
							// if xml filename and planner name in this file are
							// not the same
							/*
							 * if (!name.equals(preferences.getPlannerName())) {
							 * MessageDialog.openError(Activator.getDefault()
							 * .getWorkbench()
							 * .getActiveWorkbenchWindow().getShell(), "Error",
							 * "XML configuration file name " + name +
							 * " and planner name " +
							 * preferences.getPlannerName() +
							 * " must be the same."); } else {
							 */
							if (name.equals(preferences.getPlannerName())) {

								/*
								 * File f = new File(
								 * preferences.getPlannerFilePath()); // if file
								 * given in planner path not exists if
								 * (!f.exists()) { MessageDialog .openError(
								 * Activator .getDefault() .getWorkbench()
								 * .getActiveWorkbenchWindow() .getShell(),
								 * "Error", "Planner script file given in " +
								 * filename +
								 * " configuration file does not exist."); }
								 * else {
								 */
								plannerPreferencesMap.put(
										preferences.getPlannerName(),
										preferences);
								// }
							}
						}
					} /*
					 * else { MessageDialog .openError(
					 * Activator.getDefault().getWorkbench()
					 * .getActiveWorkbenchWindow() .getShell(), "Error",
					 * "Xml configuration file " + filename +
					 * " is not correct. Missing planner name or/and planner path."
					 * ); }
					 */
				}
			}
		}
	}

	private File getPlannerPreferencesDir() {
		File plannerPreferencesDir = new File(PLANNER_PREFERENCES_LOCATION);

		// if the directory does not exist, create it
		if (!plannerPreferencesDir.exists()
				|| !plannerPreferencesDir.isDirectory()) {
			boolean result = plannerPreferencesDir.mkdir();

			loadDefaultPlannerPreferences(plannerPreferencesDir);

			if (!result) {
				throw new RuntimeException(
						"Could not create planner preferences directory");
			}
		}
		return plannerPreferencesDir;
	}

	private void loadDefaultPlannerPreferences(File dest) {
		Bundle bundle = Platform.getBundle("pl.poznan.put.cs.gui4pddl");
		URL fileURL = bundle.getEntry("resources/FastDownward.xml");	
		try {
			URL url = org.eclipse.core.runtime.FileLocator.toFileURL(fileURL);
			File file = new File(FileLocator.resolve(url).toURI());
			if (file != null) {
				InputStream is = null;
				OutputStream os = null;
				try {
					is = new FileInputStream(file);
					os = new FileOutputStream(new File(dest.getAbsolutePath() + File.separator + file.getName()));
					byte[] buffer = new byte[1024];
					int length;
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}
				}  finally {
					is.close();
					os.close();
				}
			}
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	private PlannerPreferences loadPlannerPreferences(String path) {

		FileReader reader = null;
		PlannerPreferences preferences = null;
		try {
			reader = new FileReader(path);
			preferences = loadPlannerPreferences(XMLMemento
					.createReadRoot(reader));
		} catch (FileNotFoundException e) {
			// Ignored... no Favorites items exist yet.
		} catch (Exception e) {
			// Log the exception and move on.
			Log.log(e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				Log.log(e);
			}
		}
		return preferences;

	}

	private PlannerPreferences loadPlannerPreferences(XMLMemento memento) {
		Map<String, String> argumentsMap = new TreeMap<String, String>();
		IMemento plannerArgumentsChild = memento
				.getChild(TAG_PLANNER_ARGUMENTS);

		if (plannerArgumentsChild != null) {
			IMemento[] plannerArgumentRows = plannerArgumentsChild
					.getChildren(TAG_PLANNER_ARGUMENTS_ENTRY);
			for (IMemento plannerArgumentRow : plannerArgumentRows) {
				argumentsMap.put(plannerArgumentRow
						.getString(TAG_PLANNER_ARGUMENT_KEY),
						plannerArgumentRow
								.getString(TAG_PLANNER_ARGUMENT_VALUE));
			}
		}
		PlannerPreferences preferences = new PlannerPreferences(
				memento.getString(TAG_PLANNER_NAME),
				memento.getString(TAG_PLANNER_FILE_PATH), argumentsMap,
				memento.getString(TAG_PLAN_VIEW_FILE_PATTERN));

		return preferences;
	}

	private boolean checkIfNameIsCorrect(String name) {
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

	public boolean savePlannerPreferences(String plannerName,
			String plannerFile, Map<String, String> arguments,
			String planViewFilePattern, PlannerPreferences preferences) {

		// remove old preferences file if name changed
		if (!plannerName.equals(preferences.getPlannerName())) {
			File oldFile = new File(getPlannerPreferencesDir()
					.getAbsolutePath()
					+ File.separator
					+ preferences.getPlannerName() + ".xml");

			oldFile.delete();

			plannerPreferencesMap.remove(preferences.getPlannerName());

		}

		PlannerPreferences plannerPreferences = new PlannerPreferences(
				plannerName, plannerFile, arguments, planViewFilePattern);

		plannerPreferencesMap.put(plannerName, plannerPreferences);

		savePlannerPreferences(getPlannerPreferencesDir().getAbsolutePath()
				+ File.separator + plannerName + ".xml", plannerPreferences);

		return true;

	}

	private void savePlannerPreferences(String path,
			PlannerPreferences preferences) {
		if (plannerPreferencesMap == null)
			return;
		XMLMemento memento = XMLMemento
				.createWriteRoot(TAG_PLANNER_PREFERENCES);
		savePlannerPreferences(memento, preferences);
		FileWriter writer = null;
		try {
			writer = new FileWriter(path);
			memento.save(writer);
		} catch (IOException e) {
			Log.log(e);
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				Log.log(e);
			}
		}
	}

	private void savePlannerPreferences(XMLMemento memento,
			PlannerPreferences preferences) {
		memento.putString(TAG_PLANNER_NAME, preferences.getPlannerName());
		memento.putString(TAG_PLANNER_FILE_PATH,
				preferences.getPlannerFilePath());
		memento.putString(TAG_PLAN_VIEW_FILE_PATTERN,
				preferences.getPlanViewFilePattern());
		IMemento arguments = memento.createChild(TAG_PLANNER_ARGUMENTS);
		for (String key : preferences.getArgumentsMap().keySet()) {
			IMemento row = arguments.createChild(TAG_PLANNER_ARGUMENTS_ENTRY);
			row.putString(TAG_PLANNER_ARGUMENT_KEY, key);
			row.putString(TAG_PLANNER_ARGUMENT_VALUE, preferences
					.getArgumentsMap().get(key));
		}
	}

	public boolean removePlannerPreferences(PlannerPreferences preferences) {
		if (preferences == null) {
			return false;
		}
		if (plannerPreferencesMap == null) {
			loadPlannerPreferences();
		}

		File oldFile = new File(getPlannerPreferencesDir().getAbsolutePath()
				+ File.separator + preferences.getPlannerName() + ".xml");

		try {
			oldFile.delete();
		} catch (Exception e) {
			return false;
		}

		plannerPreferencesMap.remove(preferences.getPlannerName());
		return true;

	}

	public Map<String, PlannerPreferences> getPlannerPreferences() {
		if (plannerPreferencesMap == null) {
			loadPlannerPreferences();
		}
		return plannerPreferencesMap;
	}

}
