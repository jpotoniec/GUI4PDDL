package pl.poznan.put.cs.gui4pddl.planview.ui;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;

public class PlanViewFilter extends ViewerFilter {

	public PlanViewFilter() {
	}

	private String searchString;

	public void setSearchText(String s) {
		// ensure that the value can be used for matching
		this.searchString = ".*" + s + ".*";
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		PlanViewDataRow p = (PlanViewDataRow) element;
		if (p.getProjectName().matches(searchString)) {
			System.out.println("Projcet name MATCH");
			return true;
		}
		if (p.getDomain().matches(searchString)) {
			System.out.println("domain MATCH");
			return true;
		}
		if (p.getProblem().matches(searchString)) {
			System.out.println("problem MATCH");
			return true;
		}

		if (p.getId().matches(searchString)) {
			System.out.println("id match");
			return true;
		}
		for (String planFile : p.getPlanFileNames()) {
			if (planFile.matches(searchString)) {
				System.out.println("Plan file match");
				return true;
			}
		}

		if (p.getPlannerName().matches(searchString)) {
			System.out.println("planner name MATCH");
			return true;
		}

		if (p.getPlannerArguments().matches(searchString)) {
			System.out.println("planner arguments MATCH");
			return true;
		}

		System.out.println(searchString);

		return false;
	}
}
