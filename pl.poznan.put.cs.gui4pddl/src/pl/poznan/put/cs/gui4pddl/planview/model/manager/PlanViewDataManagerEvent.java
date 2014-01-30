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
