package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.util.List;
import java.util.LinkedList;

import org.eclipse.jface.text.IDocument;

import pl.poznan.put.cs.gui4pddl.IPDDLNature;

public class PDDLCodeCompletionManager implements IPDDLCodeCompletionManager {

	public PDDLCodeCompletionManager(IPDDLNature nature) {
		
	}

	@Override
	public List<PDDLCodeCompletionProposal> getCodeCompletionProposals(
			IDocument document, int documentOffset) {
		
		LinkedList<PDDLCodeCompletionProposal> proposals = new LinkedList<PDDLCodeCompletionProposal>();
		
		proposals.add(new PDDLCodeCompletionProposal(":strips"));
		proposals.add(new PDDLCodeCompletionProposal("?variable1234"));
		proposals.add(new PDDLCodeCompletionProposal(":precondition"));
		proposals.add(new PDDLCodeCompletionProposal("another-token"));
		
		return proposals;
	}

}
