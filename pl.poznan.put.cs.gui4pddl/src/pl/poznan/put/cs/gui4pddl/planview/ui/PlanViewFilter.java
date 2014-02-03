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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;

/**
 * Filters rows of the plan browser table according to the word given in the 'Search' text box
 *
 */
public class PlanViewFilter extends ViewerFilter {

	public PlanViewFilter() {
	}

	private String searchString;

	public void setSearchText(String s) {
		this.searchString = ".*" + s + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		PlanViewDataRow p = (PlanViewDataRow) element;
		if (p.getProjectName().matches(searchString)) {
			return true;
		}
		if (p.getDomain().matches(searchString)) {
			return true;
		}
		if (p.getProblem().matches(searchString)) {
			return true;
		}

		if (p.getId().matches(searchString)) {
			return true;
		}
		for (String planFile : p.getPlanFileNames()) {
			if (planFile.matches(searchString)) {
				return true;
			}
		}

		if (p.getPlannerName().matches(searchString)) {
			return true;
		}

		if (p.getPlannerArguments().matches(searchString)) {
			return true;
		}

		return false;
	}
}
