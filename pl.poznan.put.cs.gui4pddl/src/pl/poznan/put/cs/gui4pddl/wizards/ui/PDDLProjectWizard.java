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
package pl.poznan.put.cs.gui4pddl.wizards.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import pl.poznan.put.cs.gui4pddl.PDDLStructureConfigHelpers;

/*
 *	Code in this file is heavily based on Aptana Studio and Eclipse JDK
 *  Project and file creation dialogs use common boilerplate code
 */

public class PDDLProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	private IConfigurationElement fConfigElement;

	protected IStructuredSelection selection;

	public static final String WIZARD_ID = "pl.poznan.put.cs.gui4pddl.ui.wizards.PDDLProjectWizard";

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
		// get a project handle
        final IProject newProjectHandle = projectPage.getProjectHandle();

        // get a project descriptor
        IPath defaultPath = Platform.getLocation();
        IPath newPath = projectPage.getLocationPath();
        if (defaultPath.equals(newPath)) {
            newPath = null;
        } else {
            //The user entered the path and it's the same as it'd be if he chose the default path.
            IPath withName = defaultPath.append(newProjectHandle.getName());
            if (newPath.toFile().equals(withName.toFile())) {
                newPath = null;
            }
        }

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
        description.setLocation(newPath);
        
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            protected void execute(IProgressMonitor monitor) throws CoreException {
            	PDDLStructureConfigHelpers.createPDDLProject(description, newProjectHandle, monitor);
            }
        };

        // run the operation to create a new project
        try {
            getContainer().run(true, true, op);
        } catch (InterruptedException e) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable t = e.getTargetException();
            if (t instanceof CoreException) {
                if (((CoreException) t).getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
                    MessageDialog.openError(getShell(), "Unable to create project",
                            "Another project with the same name (and different case) already exists.");
                } else {
                    ErrorDialog
                            .openError(getShell(), "Unable to create project", null, ((CoreException) t).getStatus());
                }
            } else {
                // Unexpected runtime exceptions and errors may still occur.
            	//TODO: log
                MessageDialog.openError(getShell(), "Unable to create project", t.getMessage());
            }
            return null;
        }

        return newProjectHandle;
	}

	/**
	 * The user clicked Finish button
	 * 
	 * Launches another thread to create Python project. A progress monitor is shown in the UI thread.
	 */
	@Override
	public boolean performFinish() {
		createdProject = createNewProject();
		
		 // Switch to default perspective (will ask before changing)
		  BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
		  BasicNewResourceWizard.selectAndReveal(createdProject, workbench.getActiveWorkbenchWindow());
		 
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
