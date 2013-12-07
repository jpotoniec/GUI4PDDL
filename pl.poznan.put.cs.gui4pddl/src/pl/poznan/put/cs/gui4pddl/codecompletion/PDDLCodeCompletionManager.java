package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.util.List;
import java.util.LinkedList;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.IDocument;

import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLRequirementSet;
import pl.poznan.put.cs.gui4pddl.parser.PDDLLexer;

public class PDDLCodeCompletionManager implements IPDDLCodeCompletionManager {

	public interface ICompletionProvider {
		boolean getCodeCompletionProposals(PDDLCodeCompletionContext context, List<PDDLCodeCompletionProposal> proposals);
	}
	
	private ICompletionProvider requirementsCompletionProvider = new ICompletionProvider() {
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context, List<PDDLCodeCompletionProposal> proposals) {
			
			Token openingToken = context.getOpeningToken();
			if (openingToken != null && openingToken.getType() == PDDLLexer.REQUIRE_DEF) {
				for (String key : PDDLRequirementSet.knownRequirements) {
					proposals.add(new PDDLCodeCompletionProposal(key));
				}
				return true;
			}
			return false;
		}
	};
	
	private ICompletionProvider[] completionProviders = {
			requirementsCompletionProvider,
	};
	
	public PDDLCodeCompletionManager(IPDDLNature nature) {
		
	}

	@Override
	public List<PDDLCodeCompletionProposal> getCodeCompletionProposals(
			IDocument document, int offset) {
		
		LinkedList<PDDLCodeCompletionProposal> proposals = new LinkedList<PDDLCodeCompletionProposal>();
		
		PDDLCodeCompletionContext context = new PDDLCodeCompletionContext(document, offset);
		System.out.println(context);
		
		for (ICompletionProvider provider : completionProviders ) {
			if (provider.getCodeCompletionProposals(context, proposals))
				break;
		}

		return proposals;
	}
	

}
