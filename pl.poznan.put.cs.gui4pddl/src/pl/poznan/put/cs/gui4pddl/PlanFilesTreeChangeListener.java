package pl.poznan.put.cs.gui4pddl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

import pl.poznan.put.cs.gui4pddl.planview.ui.PlanView;

public class PlanFilesTreeChangeListener implements IResourceChangeListener {

	public class PlanFileTreeVisitor implements IResourceDeltaVisitor {

		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();

			if (delta.getKind() == IResourceDelta.CHANGED
					|| delta.getKind() == IResourceDelta.REMOVED
					|| delta.getKind() == IResourceDelta.ADDED
					|| delta.getKind() == IResourceDelta.REPLACED) {
				System.out.print("Resource ");
				System.out.print(res.getFullPath());
				System.out.println(" has changed.");
				if (res.getProject() != null) {
					if (res.getProject().hasNature(PDDLNature.PDDL_NATURE_ID)) {
						if (res.getParent() instanceof IProject) {
							if (res.getName().equals("plans")) {
								System.out.println("PDDL PROJECT");
								PlanView.refreshPlanViewWithoutActivate();
								return false;
							}
						}
					}
				}
			}

			return true;

		}
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			try {
				event.getDelta().accept(new PlanFileTreeVisitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}