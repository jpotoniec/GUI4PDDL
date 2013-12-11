package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.util.List;
import java.util.LinkedList;

import org.antlr.runtime.Token;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;

import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLInitialSituation;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLPredicate;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLProblem;
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
	
	private ICompletionProvider predicateCompletionProvider = new ICompletionProvider() {
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context, List<PDDLCodeCompletionProposal> proposals) {

			PDDLFile fileIndex = context.getFileIndex();
			if (fileIndex == null)
				return false;
			
			if (!context.isFirstInScope())
				return false;
			
			PDDLDomain domain = null;
			if (context.getDefinitionType() == PDDLCodeCompletionContext.DefinitionType.DOMAIN) {
				if (context.isPrecedingToken(PDDLLexer.PRECONDITION, true, false) || context.isPrecedingToken(PDDLLexer.EFFECT, true, false)) {
					domain = fileIndex.getDomain(context.getDefinitionName());
				}
			}
			if (context.getDefinitionType() == PDDLCodeCompletionContext.DefinitionType.PROBLEM) {
				if (context.isOpeningToken(PDDLLexer.INIT, true) || context.isOpeningToken(PDDLLexer.GOAL, true)) {
					IPath dirpath = fileIndex.getFullPath().removeLastSegments(1);
					PDDLProblem problem = fileIndex.getProblem(context.getDefinitionName());
					if (problem != null && context.getCodeModel() != null)
						domain = context.getCodeModel().getDomain(dirpath, problem.getDomainName());
				}
			}
			if (context.getDefinitionType() == PDDLCodeCompletionContext.DefinitionType.INITSIT) {
				if (context.isOpeningToken(PDDLLexer.INIT, true)) {
					IPath dirpath = fileIndex.getFullPath().removeLastSegments(1);
					PDDLInitialSituation initsit = fileIndex.getInitialSituation(context.getDefinitionName());
					if (initsit != null && context.getCodeModel() != null)
						domain = context.getCodeModel().getDomain(dirpath, initsit.getDomainName());
				}
			}
			
			if (domain != null) {
				for (PDDLPredicate p: domain.getPredicates()) {
					proposals.add(new PDDLCodeCompletionProposal(p.getName(), p.getParameters().toString()));
				}
			}
			
			return false;
			//domain.getPredicates
		}
	};
	
	private ICompletionProvider[] completionProviders = {
			requirementsCompletionProvider,
			predicateCompletionProvider,
	};
	
	private IPDDLNature nature;
	
	public PDDLCodeCompletionManager(IPDDLNature nature) {
		this.nature = nature;
	}

	@Override
	public List<PDDLCodeCompletionProposal> getCodeCompletionProposals(
			IFile file, IDocument document, int offset) {
		
		LinkedList<PDDLCodeCompletionProposal> proposals = new LinkedList<PDDLCodeCompletionProposal>();
		
		IPDDLCodeModel codeModel = getCodeModel();
		PDDLFile fileIndex = null;
		if (codeModel != null)
			fileIndex = codeModel.getFile(file, true);

		PDDLCodeCompletionContext context = new PDDLCodeCompletionContext(codeModel, fileIndex);
		context.parse(document, offset);

		System.out.println(context);
		
		for (ICompletionProvider provider : completionProviders ) {
			if (provider.getCodeCompletionProposals(context, proposals))
				break;
		}

		return proposals;
	}
	
	private IPDDLCodeModel getCodeModel() {
		if (nature != null)
			return nature.getCodeModel();
		return null;
	}
}
