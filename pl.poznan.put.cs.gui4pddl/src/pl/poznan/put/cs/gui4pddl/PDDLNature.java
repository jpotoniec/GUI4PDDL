package pl.poznan.put.cs.gui4pddl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import pl.poznan.put.cs.gui4pddl.codecompletion.IPDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codecompletion.PDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLProjectIndex;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.log.Log;
import pl.poznan.put.cs.gui4pddl.parser.Builder;

public class PDDLNature implements IProjectNature, IPDDLNature {

	public static final String PDDL_NATURE_ID = "pl.poznan.put.cs.gui4pddl.PDDLProject";

	private IProject project;
	private PDDLCodeCompletionManager completionManager;
	private PDDLCodeModel codeModel;

	public PDDLNature() {
		codeModel = new PDDLCodeModel();
		completionManager = new PDDLCodeCompletionManager(this);
	}

	@Override
	public void configure() throws CoreException {
		Builder.addBuilderToProject(getProject());
		new Job("Properties File Audit") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					project.build(Builder.FULL_BUILD, Builder.BUILDER_ID, null,
							monitor);
				} catch (CoreException e) {
					Log.log(e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}	

	@Override
	public void deconfigure() throws CoreException {
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	public static PDDLNature addNature(IProject project, IProgressMonitor monitor) throws CoreException {

		if (project == null || !project.isOpen()) {
			return null;
		}

		if (project.hasNature(PDDL_NATURE_ID)) {
			return getPDDLNature(project);
		}

		// TODO concurrency mapLock

		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		IProjectDescription desc = project.getDescription();

		String[] natures = desc.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = PDDL_NATURE_ID;
		desc.setNatureIds(newNatures);
		project.setDescription(desc, monitor);

		// TODO call init

		return getPDDLNature(project);
	}

	public static PDDLNature getPDDLNature(IProject project) {
		try {
			return (PDDLNature) project.getNature(PDDL_NATURE_ID);
		} catch (CoreException e) {
			//TODO: log exception
		}
		
		return null;
	}

	@Override
	public IPDDLCodeCompletionManager getCodeCompletionManager() {
		return completionManager;
	}

	@Override
	public IPDDLCodeModel getCodeModel() {
		return codeModel;
	}

	@Override
	public IPDDLProjectIndex getPDDLProjectIndex() {
		return codeModel;
	}
}
