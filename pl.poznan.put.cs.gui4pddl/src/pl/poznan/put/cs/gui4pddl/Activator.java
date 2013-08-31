package pl.poznan.put.cs.gui4pddl;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import pl.poznan.put.cs.gui4pddl.editor.TokenManager;
import pl.poznan.put.cs.gui4pddl.preferences.helpers.PlannerPreferencesStore;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "pl.poznan.put.cs.gui4pddl"; //$NON-NLS-1$

	

	// The shared instance
	private static Activator plugin;

	private ResourceBundle resourceBundle;
	// private LoggingModel loggingModel;
	private TokenManager tokenManager;
	

	/**
	 * The constructor
	 */
	public Activator() {

		tokenManager = new TokenManager(getPreferenceStore());
		// loggingModel = new LoggingModel();
		// setupReceiver();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		PlannerPreferencesStore.loadPlannerPreferences();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/*
	 * public LoggingModel getLoggingModel() { return loggingModel; }
	 */

	public TokenManager getTokenManager() {
		return tokenManager;
	}

	public static final String PREF_DEFAULT_COLOR = "pddl_default_color";
	public static final String PREF_COMMENT_COLOR = "pddl_comment_color";
	public static final String PREF_VALUE_COLOR = "pddl_value_color";
	public static final String PREF_VARIABLE_COLOR = "pddl_variable_color";
	public static final String PREF_KEYWORD_COLOR = "pddl_keyword_color";
	public static final String PREF_BRACKET_COLOR = "pddl_bracket_color";
	// etc...
	public static final String PREF_PORT = "pddl_view_port";

	protected void initializeDefaultPreferences(IPreferenceStore store) {
		super.initializeDefaultPreferences(store);
		store.setDefault(Activator.PREF_DEFAULT_COLOR,
				StringConverter.asString(new RGB(0, 0, 0)));
		store.setDefault(Activator.PREF_COMMENT_COLOR,
				StringConverter.asString(new RGB(0, 255, 0)));
		store.setDefault(Activator.PREF_VALUE_COLOR,
				StringConverter.asString(new RGB(0, 0, 255)));
		store.setDefault(Activator.PREF_VARIABLE_COLOR,
				StringConverter.asString(new RGB(0, 100, 70)));
		store.setDefault(Activator.PREF_KEYWORD_COLOR,
				StringConverter.asString(new RGB(255, 0, 0)));
		store.setDefault(Activator.PREF_BRACKET_COLOR,
				StringConverter.asString(new RGB(143, 143, 143)));
		// etc...
		store.setDefault(Activator.PREF_PORT, 4445);
	}

	/*
	 * private void setupReceiver() { int port =
	 * getDefault().getPreferenceStore().getInt( Activator.PREF_PORT); try {
	 * ReceiverThread lr = new ReceiverThread(loggingModel, port); lr.start(); }
	 * catch (IOException e) { DebugPlugin.log(e); } }
	 */

}
