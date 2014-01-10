package pl.poznan.put.cs.gui4pddl.parser;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

import pl.poznan.put.cs.gui4pddl.log.Log;

class PDDLVisitor implements IResourceVisitor, IResourceDeltaVisitor {
	public static final String MARKER_ID = "org.eclipse.core.resources.problemmarker";
	
	private class ErrorHandler implements PDDLAnalyzer.IErrorHandler {
		
		IFile file;
		
		public ErrorHandler(IFile file) {
			this.file = file;
		}
		
		@Override
		public void reportError(PDDLError error) {
			try {
				IMarker marker = file.createMarker(MARKER_ID);
				marker.setAttribute(IMarker.MESSAGE, error.message);
				if (error.type == PDDLError.Type.WARNING)
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				else
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.LINE_NUMBER, error.line);
			} catch (CoreException e) {
				Log.log(e);
			}
		}
		
	}
	
	public boolean visit(IResource resource) {
		if (resource instanceof IFile) {
			String extension = resource.getFileExtension();
			if ((extension != null) && (extension.equals("pddl"))) {
				deleteMarkers(resource);
				
				IFile file = (IFile)resource;
				PDDLAnalyzer.indexPDDLFile(file, new ErrorHandler(file));
			}
            return false;
        }
        return true;
	}
	
	public boolean visit(IResourceDelta delta) {
		if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED)
			return visit(delta.getResource());
		else
			return false;
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
}
