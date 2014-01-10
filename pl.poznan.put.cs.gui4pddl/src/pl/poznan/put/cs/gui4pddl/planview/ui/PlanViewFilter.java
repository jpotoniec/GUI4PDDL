package pl.poznan.put.cs.gui4pddl.planview.ui;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;

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

		System.out.println(searchString);

		return false;
	}
}
