package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.List;
import org.eclipse.jface.text.IDocument;

public interface IPDDLCodeCompletionManager {
	
	List<PDDLCodeCompletionProposal> getCodeCompletionProposals(
			IDocument document, int documentOffset);
	
}
