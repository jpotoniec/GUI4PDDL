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
package pl.poznan.put.cs.gui4pddl.planview.model.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;

/**
 * Plan browser data storage + operations
 *
 */
public class PlanViewDataManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<IPlanViewDataManagerChangeListener> listeners = new ArrayList<IPlanViewDataManagerChangeListener>();

	private Vector<PlanViewDataRow> planViewDataRows;

	private static final String PLAN_DATA_DIR = Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "plan_browser";

	private static final String PLAN_DATA_FILE_NAME = "planViewData.xml";

	private static final String TAG_PLANVIEWDATA = "PlanViewData";
	private static final String TAG_PLANVIEWDATAROW = "PlanViewDataRow";
	private static final String TAG_PROJECTNAME = "ProjectName";
	private static final String TAG_DOMAIN = "Domain";
	private static final String TAG_PROBLEM = "Problem";
	private static final String TAG_ID = "id";
	private static final String TAG_PLANNER_NAME = "PlannerName";
	private static final String TAG_DOMAIN_FILE_PATH = "DomainFilePath";
	private static final String TAG_PROBLEM_FILE_PATH = "ProblemFilePath";
	private static final String TAG_PLAN_FILE_NAMES = "PlanFileNames";
	private static final String TAG_PLAN_FILE_NAME = "PlanFileName";
	private static final String TAG_PLAN_ARGUMENTS = "PlanArguments";

	private static volatile PlanViewDataManager instance = null;

	public static PlanViewDataManager getManager() {
		if (instance == null) {
			synchronized (PlanViewDataManager.class) {
				if (instance == null) {
					instance = new PlanViewDataManager();
				}
			}
		}

		return instance;
	}

	private PlanViewDataManager() {
	}

	public void addPlanViewDataRow(PlanViewDataRow row) {
		if (row == null) {
			return;
		}
		if (planViewDataRows == null) {
			loadPlanViewData();
		}
		planViewDataRows.add(row);
		ArrayList<PlanViewDataRow> l = new ArrayList<PlanViewDataRow>();
		l.add(row);
		firePlanViewDataRowsChanged(l.toArray(new PlanViewDataRow[0]),
				new PlanViewDataRow[0]);
	}

	public void loadPlanViewData() {

		planViewDataRows = new Vector<PlanViewDataRow>();
		FileReader reader = null;
		try {
			reader = new FileReader(getPlanViewDataDir().getAbsolutePath()
					+ File.separator + PLAN_DATA_FILE_NAME);
			loadPlanViewData(XMLMemento.createReadRoot(reader));
		} catch (FileNotFoundException e) {
			// Ignored... no plan view items exist yet.
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
	}

	private File getPlanViewDataDir() {
		File planViewDataDir = new File(PLAN_DATA_DIR);

		// if the directory does not exist, create it
		if (!planViewDataDir.exists() || !planViewDataDir.isDirectory()) {
			boolean result = planViewDataDir.mkdir();

			if (!result) {
				throw new RuntimeException(
						"Could not create plan view directory");
			}
		}
		return planViewDataDir;
	}

	private void loadPlanViewData(XMLMemento memento) {
		IMemento[] children = memento.getChildren(TAG_PLANVIEWDATAROW);
		for (int i = 0; i < children.length; i++) {
			ArrayList<String> planFileNames = new ArrayList<String>();
			IMemento[] planFileNamesChildren = children[i]
					.getChildren(TAG_PLAN_FILE_NAMES);
			for (IMemento planFileNamesChild : planFileNamesChildren) {
				planFileNames.add(planFileNamesChild
						.getString(TAG_PLAN_FILE_NAME));
			}

			PlanViewDataRow item = new PlanViewDataRow(
					children[i].getString(TAG_PROJECTNAME),
					children[i].getString(TAG_DOMAIN),
					children[i].getString(TAG_PROBLEM),
					children[i].getString(TAG_ID),
					children[i].getString(TAG_PLANNER_NAME),
					children[i].getString(TAG_DOMAIN_FILE_PATH),
					children[i].getString(TAG_PROBLEM_FILE_PATH),
					planFileNames, children[i].getString(TAG_PLAN_ARGUMENTS));
			if (item != null)
				planViewDataRows.add(item);
		}
	}

	private void firePlanViewDataRowsChanged(PlanViewDataRow[] itemsAdded,
			PlanViewDataRow[] itemsRemoved) {
		PlanViewDataManagerEvent event = new PlanViewDataManagerEvent(this,
				itemsAdded, itemsRemoved);
		for (Iterator<IPlanViewDataManagerChangeListener> iter = listeners
				.iterator(); iter.hasNext();)
			iter.next().planViewDataChanged(event);
	}

	public boolean removePlanViewDataRow(PlanViewDataRow row) {
		if (row == null) {
			return false;
		}
		if (planViewDataRows == null) {
			loadPlanViewData();
		}
		boolean res = planViewDataRows.remove(row);
		PlanViewDataRow[] a = new PlanViewDataRow[1];
		a[0] = row;
		firePlanViewDataRowsChanged(new PlanViewDataRow[0], a);
		return res;
	}

	public void removePlanViewDataRows(List<PlanViewDataRow> list) {
		if (list == null) {
			return;
		}
		if (planViewDataRows == null) {
			loadPlanViewData();
		}
		planViewDataRows.removeAll(list);
		firePlanViewDataRowsChanged(new PlanViewDataRow[0],
				list.toArray(new PlanViewDataRow[0]));
	}

	public void addPlanViewDataManagerListener(
			IPlanViewDataManagerChangeListener listener) {
		if (!listeners.contains(listener))
			listeners.add(listener);
	}

	public void removePlanViewDataManagerListener(
			IPlanViewDataManagerChangeListener listener) {
		listeners.remove(listener);
	}

	public Vector<PlanViewDataRow> getPlanViewDataRows() {
		if (planViewDataRows == null)
			loadPlanViewData();
		return planViewDataRows;
	}

	public void savePlanViewData() {
		if (planViewDataRows == null)
			return;
		XMLMemento memento = XMLMemento.createWriteRoot(TAG_PLANVIEWDATA);
		savePlanViewData(memento);
		FileWriter writer = null;
		try {
			writer = new FileWriter(getPlanViewDataDir() + File.separator
					+ PLAN_DATA_FILE_NAME);
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

	private void savePlanViewData(XMLMemento memento) {
		Iterator<PlanViewDataRow> iter = planViewDataRows.iterator();
		while (iter.hasNext()) {
			PlanViewDataRow item = (PlanViewDataRow) iter.next();
			IMemento child = memento.createChild(TAG_PLANVIEWDATAROW);
			child.putString(TAG_PROJECTNAME, item.getProjectName());
			child.putString(TAG_DOMAIN, item.getDomain());
			child.putString(TAG_PROBLEM, item.getProblem());
			child.putString(TAG_ID, item.getId());
			child.putString(TAG_PLANNER_NAME, item.getPlannerName());
			child.putString(TAG_DOMAIN_FILE_PATH, item.getDomainFilePath());
			child.putString(TAG_PROBLEM_FILE_PATH, item.getProblemFilePath());

			if (item.getPlanFileNames() != null) {
				for (String planFileName : item.getPlanFileNames()) {
					IMemento planFileNamesChild = child
							.createChild(TAG_PLAN_FILE_NAMES);
					planFileNamesChild.putString(TAG_PLAN_FILE_NAME,
							planFileName);
				}
			}
			child.putString(TAG_PLAN_ARGUMENTS, item.getPlannerArguments());
		}
	}
}
