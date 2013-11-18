package pl.poznan.put.cs.gui4pddl.planview.model;

import java.util.ArrayList;
import java.util.List;

public class PlanViewModelProvider {
	private static List<PlanViewModel> model = new ArrayList<PlanViewModel>();
	
	
	public static void add(PlanViewModel planViewRow) {
		model.add(planViewRow);
	}
	
	public static List<PlanViewModel> getPlanViewModel() {
		return model;
	}
	
	

}
