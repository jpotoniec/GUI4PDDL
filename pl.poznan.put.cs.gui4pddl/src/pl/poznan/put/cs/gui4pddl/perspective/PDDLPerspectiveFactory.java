package pl.poznan.put.cs.gui4pddl.perspective;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;
import pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLFileWizard;
import pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLProjectWizard;

/**
 * PDDL perspective constructor
 */
public class PDDLPerspectiveFactory implements IPerspectiveFactory {

	/**
	 * Creates PDDL perspective layout
	 * 
	 * Copied from org.eclipse.jdt.internal.ui.JavaPerspectiveFactory
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineLayout(layout);
		defineActions(layout);
	}

	/**
	 * @param layout
	 */
	public void defineLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		// Put the Outline view on the left.
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.LEFT,
				0.25f, editorArea);

		// Put the Problems and Console views on the bottom
		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, 0.66f, editorArea);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		bottom.addView(PlanView.ID);

	}

	/**
	 * @param layout
	 */
	public void defineActions(IPageLayout layout) {
		
		layout.addNewWizardShortcut(PDDLProjectWizard.WIZARD_ID); //$NON-NLS-1$        
		layout.addNewWizardShortcut(PDDLFileWizard.WIZARD_ID);
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$

		
		layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);
//		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
		layout.addShowViewShortcut(PlanView.ID);
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView");
//		layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);

		layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
	}

}
