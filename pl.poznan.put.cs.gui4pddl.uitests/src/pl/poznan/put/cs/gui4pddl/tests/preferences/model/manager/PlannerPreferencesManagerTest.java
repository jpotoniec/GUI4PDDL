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
package pl.poznan.put.cs.gui4pddl.tests.preferences.model.manager;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import org.junit.BeforeClass;
import org.junit.Test;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

public class PlannerPreferencesManagerTest {

	private static PlannerPreferences pref;
	private static Map<String, String> arguments;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		arguments = new TreeMap<String, String>();
		arguments.put("arg1", "val1");
		arguments.put("arg2", "val2");
		
		pref = new PlannerPreferences("plannerName", "plannerFile", arguments, "sas_plan*");
	}
	
	
	@Test
	public void testSavePlannerPreferences() {
		int size = PlannerPreferencesManager.getManager().getPlannerPreferences().size();
		
		PlannerPreferencesManager.getManager().savePlannerPreferences("plannerName", "plannerFile", arguments, "sas_plan*", pref);
		assertEquals(size + 1, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		File preferencesFile = new File( Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "planner_preferences" + File.separator + "plannerName.xml");
		assertTrue(preferencesFile.exists());		
		assertTrue(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("plannerName"));
	}
	
	@Test
	public void testSavePlannerPreferencesWhileChangePlannerName() {
		int size = PlannerPreferencesManager.getManager().getPlannerPreferences().size();
		
		PlannerPreferencesManager.getManager().savePlannerPreferences("plannerName_NEW_NAME", "plannerFile", arguments, "sas_plan*", pref);
		assertEquals(size, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		File oldPreferencesFile = new File( Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "planner_preferences" + File.separator + "plannerName.xml");
		assertFalse(oldPreferencesFile.exists());		
		
		File newPreferencesFile = new File( Activator.getDefault()
				.getStateLocation().toOSString()
				+ File.separator + "planner_preferences" + File.separator + "plannerName_NEW_NAME.xml");
			assertTrue(newPreferencesFile.exists());	
			
		assertTrue(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("plannerName_NEW_NAME"));
		assertFalse(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("plannerName"));
	}
	
	@Test
	public void testLoadPlannerPreferences() {
		
		PlannerPreferencesManager.getManager().savePlannerPreferences("plannerName", "plannerFile", arguments, "sas_plan*", pref);
		
		PlannerPreferencesManager.getManager().loadPlannerPreferences();
		assertTrue(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("plannerName"));
		PlannerPreferences loadPreferences = PlannerPreferencesManager.getManager().getPlannerPreferences().get("plannerName");
		assertEquals("plannerName", loadPreferences.getPlannerName());
		assertEquals("plannerFile", loadPreferences.getPlannerFilePath());
		assertEquals(arguments, loadPreferences.getArgumentsMap());
		assertEquals("sas_plan*", loadPreferences.getPlanViewFilePattern());
	}
	
	@Test
	public void testLoadPlannerPreferencesWhilePlannerNameIsEmpty() {
		int size = PlannerPreferencesManager.getManager().getPlannerPreferences().size();
		
		Map<String, String> tmpArguments = new TreeMap<String, String>();
		tmpArguments.put("arg1", "val1");
		tmpArguments.put("arg2", "val2");
		
		PlannerPreferences tmpPref = new PlannerPreferences("", "plannerFile", tmpArguments, "sas_plan*");
				
		PlannerPreferencesManager.getManager().savePlannerPreferences("", "plannerFile", tmpArguments, "sas_plan*", tmpPref);
		assertEquals(size + 1, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		PlannerPreferencesManager.getManager().loadPlannerPreferences();
		assertEquals(size, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		assertFalse(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey(""));
	}
	
	@Test
	public void testLoadPlannerPreferencesWhilePlannerNameIsIncorrect() {
		int size = PlannerPreferencesManager.getManager().getPlannerPreferences().size();
		
		Map<String, String> tmpArguments = new TreeMap<String, String>();
		tmpArguments.put("arg1", "val1");
		tmpArguments.put("arg2", "val2");
		
		PlannerPreferences tmpPref = new PlannerPreferences("###", "plannerFile", tmpArguments, "sas_plan*");
				
		PlannerPreferencesManager.getManager().savePlannerPreferences("###", "plannerFile", tmpArguments, "sas_plan*", tmpPref);
		assertEquals(size + 1, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		PlannerPreferencesManager.getManager().loadPlannerPreferences();
		assertEquals(size, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		assertFalse(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("###"));
	}
	
	@Test
	public void testRemovePlannerPreferences() {
		int size = PlannerPreferencesManager.getManager().getPlannerPreferences().size();
		PlannerPreferencesManager.getManager().savePlannerPreferences("plannerName", "plannerFile", arguments, "sas_plan*", pref);
		assertEquals(size + 1, PlannerPreferencesManager.getManager().getPlannerPreferences().size());
		
		File preferencesFile = new File( Activator.getDefault()
			.getStateLocation().toOSString()
			+ File.separator + "planner_preferences" + File.separator + "plannerName.xml");
		assertTrue(preferencesFile.exists());		
		
		assertTrue(PlannerPreferencesManager.getManager().removePlannerPreferences(pref));
		assertFalse(preferencesFile.exists());
		assertFalse(PlannerPreferencesManager.getManager().getPlannerPreferences().containsKey("plannerName"));
	}
	
	@Test
	public void testRemovePlannerPreferencesWhilePreferencesIsNull() {
		assertFalse(PlannerPreferencesManager.getManager().removePlannerPreferences(null));
	}

}
