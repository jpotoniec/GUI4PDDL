package pl.poznan.put.cs.gui4pddl;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import pl.poznan.put.cs.gui4pddl.editor.TokenManager;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;
import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "pl.poznan.put.cs.gui4pddl"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private ImageCache imageCache;

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
		imageCache = new ImageCache(getDefault().getBundle().getEntry("/"));
		
		System.out.println("PDDL PLUGIN START");
		
		PlanView.setActivateMode(PlanView.ACTIVATE_VIEW_AFTER_DATA_UPDATE);


		

		// TODO dowiedziec sie czy ukrywac widok konsoli od poczatku czy nie
		/*
		 * IPreferenceStore debugUIPreferences =
		 * DebugUIPlugin.getDefault().getPreferenceStore();
		 * 
		 * debugUIPreferences.setValue(IDebugPreferenceConstants.CONSOLE_OPEN_ON_ERR
		 * , false);
		 * 
		 * debugUIPreferences.setValue(IDebugPreferenceConstants.CONSOLE_OPEN_ON_OUT
		 * , false);
		 */
	}
	
	

	public static void refreshProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public static ImageCache getImageCache() {
	        return plugin.imageCache;
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
		PlanViewDataManager.getManager().savePlanViewData();
		imageCache.dispose();
		super.stop(context);
	
		
		System.out.println("PDDL PLUGIN STOP");
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
