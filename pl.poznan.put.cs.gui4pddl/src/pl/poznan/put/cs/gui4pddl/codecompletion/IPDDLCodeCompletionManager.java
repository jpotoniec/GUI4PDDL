package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IDocument;

public interface IPDDLCodeCompletionManager {

	List<PDDLCodeCompletionProposal> getCodeCompletionProposals(IFile file,
			IDocument document, int offset);
	
}
