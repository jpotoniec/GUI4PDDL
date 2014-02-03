/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl;

import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import pl.poznan.put.cs.gui4pddl.editor.TokenManager;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;
import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;

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

	}

	public static void refreshProject(String projectName) {
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			Log.log(e);
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
		PlanViewDataManager.getManager().savePlanViewData();
		plugin = null;
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

	public static final String PREF_SHOW_PLAN_BROWSER = "show_plan_browser";
	public static final String PREF_DEFAULT_PLANNER = "use_default_planner";
	public static final String PREF_DEFAULT_PLANNER_NAME = "default_planner_name";
	public static final String PREF_DEFAULT_PLANNER_ARGUMENT_NAME = "default_planner_argument_name";

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

		store.setDefault(Activator.PREF_SHOW_PLAN_BROWSER, true);
		store.setDefault(Activator.PREF_DEFAULT_PLANNER, false);
	}

	/*
	 * private void setupReceiver() { int port =
	 * getDefault().getPreferenceStore().getInt( Activator.PREF_PORT); try {
	 * ReceiverThread lr = new ReceiverThread(loggingModel, port); lr.start(); }
	 * catch (IOException e) { DebugPlugin.log(e); } }
	 */

}
