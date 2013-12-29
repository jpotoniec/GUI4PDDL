package pl.poznan.put.cs.gui4pddl.tests.planview.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pl.poznan.put.cs.gui4pddl.planview.model.PlanViewDataRow;
import pl.poznan.put.cs.gui4pddl.planview.model.manager.PlanViewDataManager;

public class PlanViewDataManagerTest {
	
	@Test
	public void testAddPlanViewDataRow() {
		PlanViewDataRow row = new PlanViewDataRow("projectName","domain", "problem", "id", "plannerName", null, null, null, null);
		PlanViewDataManager.getManager().addPlanViewDataRow(row);
		assertEquals(row, PlanViewDataManager.getManager().getPlanViewDataRows().get(0));
	}
	
	@Test
	public void testLoadPlanViewData() {
		PlanViewDataManager.getManager().loadPlanViewData();
		assertNotNull(PlanViewDataManager.getManager().getPlanViewDataRows());
	}
	
	@Test
	public void testRemovePlanViewDataRow() {
		PlanViewDataRow row = new PlanViewDataRow("projectName","domain", "problem", "id", "plannerName", null, null, null, null);
		PlanViewDataManager.getManager().getPlanViewDataRows().clear();
		PlanViewDataManager.getManager().addPlanViewDataRow(row);
		assertEquals(1, PlanViewDataManager.getManager().getPlanViewDataRows().size());
		PlanViewDataManager.getManager().removePlanViewDataRow(row);
		assertEquals(0, PlanViewDataManager.getManager().getPlanViewDataRows().size());
	}
	
	@Test
	public void testRemovePlanViewDataRows() {
		PlanViewDataRow row1 = new PlanViewDataRow("projectName","domain", "problem", "id", "plannerName", null, null, null, null);
		PlanViewDataRow row2 = new PlanViewDataRow("projectName2","domain2", "problem2", "id2", "plannerName2", null, null, null, null);
		List<PlanViewDataRow> list = new ArrayList<PlanViewDataRow>();
		list.add(row1);
		list.add(row2);
		PlanViewDataManager.getManager().getPlanViewDataRows().clear();
		PlanViewDataManager.getManager().addPlanViewDataRow(row1);
		PlanViewDataManager.getManager().addPlanViewDataRow(row2);
		assertEquals(2, PlanViewDataManager.getManager().getPlanViewDataRows().size());
		PlanViewDataManager.getManager().removePlanViewDataRows(list);
		assertEquals(0, PlanViewDataManager.getManager().getPlanViewDataRows().size());
	}
	
	@Test
	public void testSaveAndLoadPlanViewData() {
		PlanViewDataRow row1 = new PlanViewDataRow("projectName","domain", "problem", "id", "plannerName", "", "", null, "");
		PlanViewDataRow row2 = new PlanViewDataRow("projectName2","domain2", "problem2", "id2", "plannerName2", "", "", null, "");
		PlanViewDataManager.getManager().getPlanViewDataRows().clear();
		PlanViewDataManager.getManager().addPlanViewDataRow(row1);
		PlanViewDataManager.getManager().addPlanViewDataRow(row2);
		PlanViewDataManager.getManager().savePlanViewData();
		PlanViewDataManager.getManager().getPlanViewDataRows().clear();
		assertEquals(0, PlanViewDataManager.getManager().getPlanViewDataRows().size());
		PlanViewDataManager.getManager().loadPlanViewData();
		assertEquals(2, PlanViewDataManager.getManager().getPlanViewDataRows().size());
		assertEquals(row1, PlanViewDataManager.getManager().getPlanViewDataRows().get(0));
		assertEquals(row2, PlanViewDataManager.getManager().getPlanViewDataRows().get(1));
	}

}
