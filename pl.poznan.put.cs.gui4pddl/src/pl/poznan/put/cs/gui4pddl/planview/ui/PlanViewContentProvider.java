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
package pl.poznan.put.cs.gui4pddl.planview.ui;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import pl.poznan.put.cs.gui4pddl.planview.model.manager.IPlanViewDataManagerChangeListener;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManagerEvent;

/**
 * Plan browser content provider. Remove or add rows to plan browser table when model has changed
 *
 */
public class PlanViewContentProvider implements IStructuredContentProvider,
		IPlanViewDataManagerChangeListener {
	private TableViewer viewer;
	private PlanViewDataManager manager;

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TableViewer) viewer;
		if (manager != null)
			manager.removePlanViewDataManagerListener(this);
		manager = (PlanViewDataManager) newInput;
		if (manager != null)
			manager.addPlanViewDataManagerListener(this);
	}

	@Override
	public Object[] getElements(Object parent) {
		return manager.getPlanViewDataRows().toArray();
	}

	@Override
	public void planViewDataChanged(final PlanViewDataManagerEvent event) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				viewer.getTable().setRedraw(false);
				try {
					viewer.remove(event.getItemsRemoved());
					viewer.add(event.getItemsAdded());
					viewer.refresh();
				} finally {
					viewer.getTable().setRedraw(true);
					
				}
			}
		});
	}

}
