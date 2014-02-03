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
package pl.poznan.put.cs.gui4pddl.tests.ui.wizards;

import static org.junit.Assert.*;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.poznan.put.cs.gui4pddl.tests.SWTBotHelpers;
import pl.poznan.put.cs.gui4pddl.wizards.ui.PDDLFileWizard;
import pl.poznan.put.cs.gui4pddl.wizards.ui.PDDLProjectWizard;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PDDLFileWizardTest {

	public static SWTWorkbenchBot bot = null;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		bot = SWTBotHelpers.eclipseBot();
		SWTBotHelpers.closeWelcome(bot);
	}

	@Before
	public void setUp() {
		SWTBotHelpers.openPDDLPerspective(bot);
		assertEquals("PDDL", bot.activePerspective().getLabel());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testID() {
		assertEquals("pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLFileWizard", PDDLFileWizard.WIZARD_ID);
	}
	
	@Test
	public void canCreateANewPDDLFileByCreatorTest() throws Exception {
		String projectName = "canCreateANewPDDLFileFromCreatorTest";
		SWTBotHelpers.createPDDLProjectByMenu(bot, projectName);
		SWTBotHelpers.assertProjectExists(bot, projectName);
		bot.sleep(2000);
		SWTBotHelpers.createPDDLFileByCreator(bot, projectName,"PDDLFileByCreator.pddl");
		SWTBotHelpers.assertFileExists(bot, projectName, "PDDLFileByCreator.pddl");
	}
	
	@Test
	public void canCreateANewPDDLFileByMenuTest() throws Exception {
		String projectName = "canCreateANewPDDLFileByMenuTest";
		SWTBotHelpers.createPDDLProjectByMenu(bot, projectName);
		SWTBotHelpers.assertProjectExists(bot, projectName);
		bot.sleep(2000);
		SWTBotHelpers.createPDDLFileByMenu(bot, projectName,"PDDLFileByMenu.pddl");
		SWTBotHelpers.assertFileExists(bot, projectName, "PDDLFileByMenu.pddl");
	}
	
	@Test
	public void fileWizardControllersTest() throws Exception {
		SWTBotHelpers.menu(bot, "File", "New", "PDDL File").click();
		
		//check Finish button when Container name empty
		bot.textWithLabel("Container:").setText("");
		assertFalse(bot.button("Finish").isEnabled());
		
		//check Finish button when file name empty
		bot.textWithLabel("Container:").setText("/canCreateANewPDDLFileByMenuTest");
		bot.textWithLabel("File name:").setText("");
		assertFalse(bot.button("Finish").isEnabled());
		
		//check Finish button when file name has not pddl extension
		bot.textWithLabel("File name:").setText("test.t");
		assertFalse(bot.button("Finish").isEnabled());
		
		//check if Folder Selection window is visible
		bot.button("Browse...").click();
		bot.button("Cancel").click();
		
		//add next file
		bot.textWithLabel("File name:").setText("test2.pddl");
		assertTrue(bot.button("Finish").isEnabled());
		bot.button("Finish").click();
		SWTBotHelpers.waitForWorkspace();
		SWTBotHelpers.assertFileExists(bot, "canCreateANewPDDLFileByMenuTest", "test2.pddl");
	
		
	}
	

}
