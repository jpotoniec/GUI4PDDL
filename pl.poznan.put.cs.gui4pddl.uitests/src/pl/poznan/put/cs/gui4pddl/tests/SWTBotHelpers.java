package pl.poznan.put.cs.gui4pddl.tests;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

public class SWTBotHelpers {

	public static SWTWorkbenchBot eclipseBot() {
		SWTWorkbenchBot bot = new SWTWorkbenchBot();
		return bot;
	}

	public static SWTWorkbenchBot openPDDLPerspective(SWTWorkbenchBot bot) {
		bot.perspectiveByLabel("PDDL").activate();
		return bot;
	}

	public static SWTWorkbenchBot closeWelcome(SWTWorkbenchBot bot) {
		try {
			bot.viewByTitle("Welcome").close();
		} catch (Exception e) { 
			// Nevermind
		}
		return bot;

	}
	public static SWTBotMenu menu(SWTWorkbenchBot bot, String menu, String... subMenus) {
		SWTBotMenu ret = bot.menu(menu);
		for (String subMenu: subMenus) {
			ret = ret.menu(subMenu);
		}
		return ret;
	}

	public static SWTBotShell activateShell(SWTWorkbenchBot bot, String shell) {
		SWTBotShell s = bot.shell(shell);
		s.activate();
		return s;
	}

	public static void waitForWorkspace() throws Exception {
		// ensure that all queued workspace operations and locks are released
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
		public void run(IProgressMonitor monitor) throws CoreException {
					// nothing to do!
				}
			}, new NullProgressMonitor());
	}

	public static SWTWorkbenchBot createPDDLProjectByCreator(SWTWorkbenchBot bot, String projectName) throws Exception {
		menu(bot, "File", "New", "Project...").click();
		activateShell(bot, "New Project");
		bot.tree().expandNode("GUI4PDDL").select("PDDL Project");
		bot.button("Next >").click();
		return fillNewProject(bot, projectName);
	}
	

	public static SWTWorkbenchBot createPDDLProjectByMenu(SWTWorkbenchBot bot, String projectName) throws Exception {
		menu(bot, "File", "New", "PDDL Project").click();
		return fillNewProject(bot, projectName);
	}
	
	public static SWTWorkbenchBot createPDDLFileByCreator(SWTWorkbenchBot bot, String projectName,  String fileName) throws Exception {
		menu(bot, "File", "New", "Other...").click();
		activateShell(bot, "New");
		bot.tree().expandNode("GUI4PDDL").select("PDDL File");
		bot.button("Next >").click();	
		return fillNewFile(bot, projectName, fileName);
	}
	
	public static SWTWorkbenchBot createPDDLFileByMenu(SWTWorkbenchBot bot, String projectName, String fileName) throws Exception {
		menu(bot, "File", "New", "PDDL File").click();
		return fillNewFile(bot, projectName, fileName);
	}
	
	/** Test if a project exists by checking the Package Explorer View */
	public static void assertProjectExists(SWTWorkbenchBot bot, String projectName) {
		SWTBotView projectExplorer = bot.viewByTitle("Project Explorer");
		SWTBotTree projectsTree = projectExplorer.bot().tree();
		projectsTree.expandNode(projectName);
	}
	
	/** Test if a file exists by checking the Package Explorer View */
	public static void assertFileExists(SWTWorkbenchBot bot, String projectName, String fileName) {
		SWTBotView projectExplorer = bot.viewByTitle("Project Explorer");
		SWTBotTree projectsTree = projectExplorer.bot().tree();
		projectsTree.expandNode(projectName,fileName);
		
	}
	
	public static SWTWorkbenchBot fillNewProject(SWTWorkbenchBot bot, String projectName) throws Exception {
		bot.textWithLabel("Project name:").setText(projectName);
		bot.button("Finish").click();
		waitForWorkspace();
		return bot;
	}
	
	public static SWTWorkbenchBot fillNewFile(SWTWorkbenchBot bot,  String projectName, String fileName) throws Exception {
		bot.textWithLabel("Container:").setText("/" + projectName);
		bot.textWithLabel("File name:").setText(fileName);
		bot.button("Finish").click();
		waitForWorkspace();
		return bot;
	}
	
}
