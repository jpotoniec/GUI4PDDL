package pl.put.poznan.cs.gui4pddl.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class PDDLProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	private IConfigurationElement fConfigElement;

	protected IStructuredSelection selection;

	public static final String WIZARD_ID = "pl.poznan.put.cs.gui4pddl";

	protected PDDLProjectNameAndLocationWizardPage projectPage;

	/** Target project created by this wizard */
	IProject generatedProject;

	/** Exception throw by generator thread */
	Exception creationThreadException;

	private IProject createdProject;

	protected IWorkbench workbench;

	public PDDLProjectWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
		projectPage = createProjectPage();
	}

	/**
	 * Creates the project page.
	 */
	protected PDDLProjectNameAndLocationWizardPage createProjectPage() {
		return new PDDLProjectNameAndLocationWizardPage("Setting project properties");
	}

	/**
	 * Add wizard pages to the instance
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		addPage(projectPage);
	}

	protected IProject createNewProject() {
		// TODO method stub
		return null;
	}

	/**
	 * The user clicked Finish button
	 * 
	 * Launches another thread to create Python project. A progress monitor is shown in the UI thread.
	 */
	public boolean performFinish() {
		createdProject = createNewProject();

		// TODO uncomment
		/*
		 * // Switch to default perspective (will ask before changing)
		 * BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
		 * BasicNewResourceWizard.selectAndReveal(createdProject, workbench.getActiveWorkbenchWindow());
		 */
		return true;
	}

	public IProject getCreatedProject() {
		return createdProject;
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		this.fConfigElement = config;
	}
}
