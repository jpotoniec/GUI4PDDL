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

import java.util.EventObject;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;

/**
 * Event that occurs when rows in plan browser are added/removed
 *
 */
public class PlanViewDataManagerEvent extends EventObject {

	private static final long serialVersionUID = 3697053173951102953L;
	private final PlanViewDataRow[] added;
	private final PlanViewDataRow[] removed;

	public PlanViewDataManagerEvent(PlanViewDataManager source,
			PlanViewDataRow[] itemsAdded, PlanViewDataRow[] itemsRemoved) {
		super(source);
		added = itemsAdded;
		removed = itemsRemoved;
	}

	public PlanViewDataRow[] getItemsAdded() {
		return added;
	}

	public PlanViewDataRow[] getItemsRemoved() {
		return removed;
	}

}
