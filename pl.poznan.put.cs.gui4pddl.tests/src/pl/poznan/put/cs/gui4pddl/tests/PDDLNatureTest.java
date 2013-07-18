package pl.poznan.put.cs.gui4pddl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.poznan.put.cs.gui4pddl.PDDLNature;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PDDLNatureTest {

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
	public void testId() {
		assertEquals(PDDLNature.PDDL_NATURE_ID,"pl.poznan.put.cs.gui4pddl.PDDLProject");
	}
	
	@Test
	public void testIfProjectHasNature() throws Exception {
		SWTBotHelpers.createPDDLProjectByCreator(bot, "testIfProjectHasNature");
		IProject project =  ResourcesPlugin.getWorkspace().getRoot().getProject("testIfProjectHasNature");
		//PDDLNature.addNature(project, null);
		//assertNotNull(PDDLNature.getPDDLNature(project));
		assertTrue(project.hasNature(PDDLNature.PDDL_NATURE_ID));
	}
	
	@Test
	public void testAddNatureWhenProjectHasNature() throws Exception {
		SWTBotHelpers.createPDDLProjectByCreator(bot, "testAddNatureWhenProjectHasNature");
		IProject project =  ResourcesPlugin.getWorkspace().getRoot().getProject("testAddNatureWhenProjectHasNature");
		assertEquals(PDDLNature.addNature(project, null),PDDLNature.getPDDLNature(project));
	}
	
	@Test
	public void testAddNatureWhenProjectIsNull() throws Exception {
		IProject project =  ResourcesPlugin.getWorkspace().getRoot().getProject("testAddNatureWhenProjectIsNull");
		assertNull(PDDLNature.addNature(project, null));
	}
	
	@Test
	public void testAddNatureWhenProjectIsClosed() throws Exception {
		SWTBotHelpers.createPDDLProjectByCreator(bot, "testAddNatureWhenProjectIsClosed");
		IProject project =  ResourcesPlugin.getWorkspace().getRoot().getProject("testAddNatureWhenProjectIsClosed");
		project.close(null);
		assertNull(PDDLNature.addNature(project, null));
	
	}
	
}
