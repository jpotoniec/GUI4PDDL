package pl.poznan.put.cs.gui4pddl.tests.ui.wizards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.poznan.put.cs.gui4pddl.tests.SWTBotHelpers;
import pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLProjectWizard;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PDDLProjectWizardTest {
	
	
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

	@Test
	public void testID() {
		assertEquals("pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLProjectWizard", PDDLProjectWizard.WIZARD_ID);
	}
		

	@Test
	public void canCreateANewPDDLProjectByCreatorTest() throws Exception {
		SWTBotHelpers.createPDDLProjectByCreator(bot, "MyFirstPDDLProjectFromCreator");
		SWTBotHelpers.assertProjectExists(bot,  "MyFirstPDDLProjectFromCreator");
	}
	
	@Test
	public void canCreateANewPDDLProjectByMenuTest() throws Exception {
		SWTBotHelpers.createPDDLProjectByMenu(bot, "MyFirstPDDLProjectFromMenu");
		SWTBotHelpers.assertProjectExists(bot,  "MyFirstPDDLProjectFromMenu");
	}
	
	@Test
	public void projectWizardControllersTest() throws Exception {
		SWTBotHelpers.createPDDLProjectByMenu(bot, "projectWizardControllersTest");
		bot.sleep(2000);
		SWTBotHelpers.menu(bot, "File", "New", "PDDL Project").click();
		
		//check if Finish button enabled when project name empty
		assertFalse(bot.button("Finish").isEnabled());
		
		//check window description
		assertTrue(bot.text("Create a new PDDL Project.").isVisible());
		
		//check window description when project name is empty
		bot.textWithLabel("Project name:").setText("WizardControllersTest");
		bot.textWithLabel("Project name:").setText("");
		assertTrue(bot.text("Project name is empty").isVisible());
		
		//check if Finish button enabled when project name exists
		bot.textWithLabel("Project name:").setText("projectWizardControllersTest");
		assertFalse(bot.button("Finish").isEnabled());
		bot.textWithLabel("Project name:").setText("WizardControllersTest");
		
		//check window description, Finish button and Directory textfield when project path empty (checkbox clicked)
		assertFalse(bot.textWithLabel("Directory").isEnabled());
		bot.checkBox("Use default").click();
		assertTrue(bot.textWithLabel("Directory").isEnabled());
		assertTrue(bot.text("Project location is empty").isVisible());
		assertFalse(bot.button("Finish").isEnabled());
		bot.checkBox("Use default").click();
		assertTrue(bot.button("Finish").isEnabled());
		
		//end project wizard
		bot.button("Finish").click();
		SWTBotHelpers.waitForWorkspace();
		
	}
	
	

}