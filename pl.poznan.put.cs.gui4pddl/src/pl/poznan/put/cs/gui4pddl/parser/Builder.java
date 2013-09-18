package pl.poznan.put.cs.gui4pddl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import pl.poznan.put.cs.gui4pddl.log.Log;

public class Builder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "pl.poznan.put.cs.gui4pddl.PDDLParser";
	public static final String MARKER_ID = "org.eclipse.core.resources.problemmarker";

	class PDDLFileVisitor implements IResourceVisitor, IResourceDeltaVisitor {
		public boolean visit(IResource resource) {
			if (resource instanceof IFile) {
				if (resource.getFileExtension().equals("pddl")) {
					deleteMarkers(resource);
					parse((IFile)resource);
				}
                return false; //has no members
            }
            return true;
		}
		
		public boolean visit(IResourceDelta delta) {
			if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED)
				return visit(delta.getResource());
			else
				return false;
		}
	}
	
	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		
		IProject project = getProject();
		if (project == null)
			return null;
		
		if ((kind == INCREMENTAL_BUILD) || (kind == AUTO_BUILD)) {
			IResourceDelta delta = getDelta(project);
			if (delta == null ) {
				project.accept(new PDDLFileVisitor());
			}
			delta.accept(new PDDLFileVisitor());
		} else {
			project.accept(new PDDLFileVisitor());
		}
		return null;
	}
	
	protected List<IFile> getAllIFiles(IContainer container) throws RuntimeException {
		final ArrayList<IFile> ret = new ArrayList<IFile>();
		ret.clear();
		
		try {
            container.accept(new IResourceVisitor() {

                public boolean visit(IResource resource) {
                    if (resource instanceof IFile) {
                        ret.add((IFile) resource);
                        return false; //has no members
                    }
                    return true;
                }

            });
        } catch (CoreException e) {
            throw new RuntimeException(e);
        }
        return ret;
	}
	
	public static void addBuilderToProject(IProject project) {
		if (!project.isOpen())
			return;

		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			Log.log(e);
			return;
		}

		ICommand[] cmds = description.getBuildSpec();
		for (int j = 0; j < cmds.length; j++)
			if (cmds[j].getBuilderName().equals(BUILDER_ID))
				return;
		
		// Associate builder with project.
		ICommand newCmd = description.newCommand();
		newCmd.setBuilderName(BUILDER_ID);
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.add(newCmd);
		description.setBuildSpec((ICommand[]) newCmds
				.toArray(new ICommand[newCmds.size()]));
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			Log.log(e);
		}
	}
	
	protected void parse(IFile file) {
		if (!file.exists())
			return;
		
		InputStream stream = null;
		try {
			stream = file.getContents();

			ANTLRInputStream input = new ANTLRInputStream(stream);
			PDDLLexer lexer = new PDDLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			PDDLParser parser = new PDDLParser(tokens);
			
			try {
				parser.pddl_file();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
			
			List<PDDLError> errors = parser.getErrors();
			reportErrors(file, errors);
			
		} catch (CoreException e) {
			Log.log(e);
		} catch (IOException e) {
			Log.log(e);
		}
		finally {
			if (stream != null)
			try {
				stream.close();
			} catch (IOException e) {
				Log.log(e);
			}
		}
	}
	
	public static boolean deleteMarkers(IResource resource) {
		try {
			resource.deleteMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
			return true;
		} catch (CoreException e) {
			Log.log(e);
			return false;
		}
	}
	
	private void reportErrors(IFile file, List<PDDLError> errors) {
		try {
			for (PDDLError error : errors) {
				IMarker marker = file.createMarker(MARKER_ID);
				marker.setAttribute(IMarker.MESSAGE, error.message);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.LINE_NUMBER, error.line);
			}
			
		} catch (CoreException e) {
			Log.log(e);
		}
	}

}
