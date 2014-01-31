package pl.poznan.put.cs.gui4pddl.codecompletion;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

import org.antlr.runtime.Token;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;

import pl.poznan.put.cs.gui4pddl.IPDDLNature;
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeModel;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLAction;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLDomain;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLFile;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLInitialSituation;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLPredicate;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLProblem;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLRequirementSet;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLTypedList;
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
	
	public ICompletionProvider objectCompletionProvider = new ICompletionProvider() {
		
		@Override
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context,
				List<PDDLCodeCompletionProposal> proposals) {
			
			PDDLFile fileIndex = context.getFileIndex();
			if (fileIndex == null)
				return false;
			
			if (context.isFirstInScope())
				return false;
			
			if (context.isProblem()) {
				if (context.isOpeningToken(PDDLLexer.INIT, true) || context.isOpeningToken(PDDLLexer.GOAL, true)) {
					PDDLProblem problem = fileIndex.getProblem(context.getDefinitionName());
					for(PDDLTypedList.Entry e: problem.getObjects()) {
						//TODO: Type checking
						proposals.add(new PDDLCodeCompletionProposal(e.name, e.type.toString()));
					}
					return true;
				}
			}
			return false;
		}
	};
	
	public ICompletionProvider typeCompletionProvider = new ICompletionProvider() {
		
		@Override
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context,
				List<PDDLCodeCompletionProposal> proposals) {
			PDDLFile fileIndex = context.getFileIndex();
			if (fileIndex == null)
				return false;
			
			if (context.isPreviousToken(PDDLLexer.HYPHEN)) {
				PDDLDomain domain = getDomain(context);
				if (domain != null) {
					for(String typeName : domain.getTypeNames()) {
						proposals.add(new PDDLCodeCompletionProposal(typeName));
					}
				} else {
					proposals.add(new PDDLCodeCompletionProposal("object"));
				}
				return true;
			}
			
			return false;
		}
	};
	
	public ICompletionProvider variableCompletionProvider = new ICompletionProvider() {
		
		@Override
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context,
				List<PDDLCodeCompletionProposal> proposals) {
			
			PDDLFile fileIndex = context.getFileIndex();
			if (fileIndex == null)
				return false;
			
			if (context.isFirstInScope())
				return false;
			
			if(context.isDomain()) {
				PDDLDomain domain = context.getFileIndex().getDomain(context.getDefinitionName());
				if (domain != null)
				{
					if (context.isOpeningToken(PDDLLexer.ACTION, true)) {
						//Domain variables and constants
						for(String var : domain.getDomainVariables(null)) {
							proposals.add(new PDDLCodeCompletionProposal(var));
						}
						for(String var : domain.getConstants(null)) {
							proposals.add(new PDDLCodeCompletionProposal(var));
						}
						//Current action parameter and declared variables
						List<Token> actionScope = context.getElementScope(PDDLLexer.ACTION);
						if (actionScope != null && actionScope.size() >= 2) {
							String actionName = actionScope.get(1).getText();
							PDDLAction action = domain.getAction(actionName);
							for(PDDLTypedList.Entry e : action.getVariables())
								proposals.add(new PDDLCodeCompletionProposal(e.name,e.type.getName()));
							for(PDDLTypedList.Entry e : action.getParameters())
								proposals.add(new PDDLCodeCompletionProposal(e.name,e.type.getName()));
							
						}
						return true;
					}
				}
			}
			
			return false;
		}
	};
	
	public ICompletionProvider keywordCompletionProvider = new ICompletionProvider() {
		
		@Override
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context,
				List<PDDLCodeCompletionProposal> proposals) {
			
			if (context.nestingLevel() == 0) {
				proposals.add(new PDDLCodeCompletionProposal("(define "));
			}
			
			if (context.nestingLevel() == 1) {
				proposals.add(new PDDLCodeCompletionProposal("("));
			}
			
			if (context.nestingLevel() == 2 && context.isFirstInScope())
			{
				switch(context.getDefinitionType()) {
				case DOMAIN:
					proposals.add(new PDDLCodeCompletionProposal(":action"));
					proposals.add(new PDDLCodeCompletionProposal(":axiom"));
					proposals.add(new PDDLCodeCompletionProposal(":constants"));
					proposals.add(new PDDLCodeCompletionProposal(":domain-variables"));
					proposals.add(new PDDLCodeCompletionProposal(":extends"));
					proposals.add(new PDDLCodeCompletionProposal(":action"));
					proposals.add(new PDDLCodeCompletionProposal(":method"));
					proposals.add(new PDDLCodeCompletionProposal(":predicates"));
					proposals.add(new PDDLCodeCompletionProposal(":requirements"));
					proposals.add(new PDDLCodeCompletionProposal(":safety"));
					proposals.add(new PDDLCodeCompletionProposal(":timeless"));
					proposals.add(new PDDLCodeCompletionProposal(":types"));
					break;
				case PROBLEM:
					proposals.add(new PDDLCodeCompletionProposal(":domain"));
					proposals.add(new PDDLCodeCompletionProposal(":goal"));
					proposals.add(new PDDLCodeCompletionProposal(":init"));
					proposals.add(new PDDLCodeCompletionProposal(":length"));
					proposals.add(new PDDLCodeCompletionProposal(":objects"));
					proposals.add(new PDDLCodeCompletionProposal(":situation"));
					proposals.add(new PDDLCodeCompletionProposal(":requirements"));
					break;
				case INITSIT:
					proposals.add(new PDDLCodeCompletionProposal(":domain"));
					proposals.add(new PDDLCodeCompletionProposal(":objects"));
					proposals.add(new PDDLCodeCompletionProposal(":init"));
					break;
				case NONE:
					proposals.add(new PDDLCodeCompletionProposal("domain"));
					proposals.add(new PDDLCodeCompletionProposal("problem"));
					proposals.add(new PDDLCodeCompletionProposal("situation"));
					break;
				default:
				}
			}
			if (context.getOpeningToken() != null)
			{
				if (context.getOpeningToken().getType() == PDDLLexer.ACTION) {
					proposals.add(new PDDLCodeCompletionProposal(":parameters"));
					proposals.add(new PDDLCodeCompletionProposal(":vars"));
					proposals.add(new PDDLCodeCompletionProposal(":precondition"));
					proposals.add(new PDDLCodeCompletionProposal(":effect"));
					proposals.add(new PDDLCodeCompletionProposal(":expansion"));
					proposals.add(new PDDLCodeCompletionProposal(":maintain"));
					proposals.add(new PDDLCodeCompletionProposal(":only-in-expansions"));
				}
				
				if (context.getOpeningToken().getType() == PDDLLexer.AXIOM) {
					proposals.add(new PDDLCodeCompletionProposal(":vars"));
					proposals.add(new PDDLCodeCompletionProposal(":context"));
					proposals.add(new PDDLCodeCompletionProposal(":implies"));
				}
				
				if(context.isOpeningToken(PDDLLexer.LENGTH, true)) {
					proposals.add(new PDDLCodeCompletionProposal(":parallel"));
					proposals.add(new PDDLCodeCompletionProposal(":serial"));
				}
			}
			
			return false;
		}
	};
	
	public ICompletionProvider fileNameCompletionProvider = new ICompletionProvider() {
		
		@Override
		public boolean getCodeCompletionProposals(
				PDDLCodeCompletionContext context,
				List<PDDLCodeCompletionProposal> proposals) {
			if (context.isPreviousToken(PDDLLexer.DOMAIN_DEF) || context.isPreviousToken(PDDLLexer.PROBLEM_DEF)) {
				PDDLFile file = context.getFileIndex();
				if (file != null) {
					String name = file.getName();
					if (name != null) {
						name = name.replace(".pddl", "") + ")";
						proposals.add(new PDDLCodeCompletionProposal(file.getName()));
						System.out.println(name);
					}
				}
					
				return true;
			}
			return false;
		}
	};
	
	public static PDDLDomain getDomain(PDDLCodeCompletionContext context) {

		PDDLFile fileIndex = context.getFileIndex();
		if (fileIndex == null)
			return null;

		PDDLDomain domain = null;
		switch(context.getDefinitionType()) {
		case DOMAIN:
			domain = fileIndex.getDomain(context.getDefinitionName());
			break;
		case PROBLEM:
			IPath problemDirpath = fileIndex.getFullPath().removeLastSegments(1);
			PDDLProblem problem = fileIndex.getProblem(context.getDefinitionName());
			if (problem != null && context.getCodeModel() != null)
				domain = context.getCodeModel().getDomain(problemDirpath, problem.getDomainName());
			break;
		case INITSIT:
			IPath initsitDirpath = fileIndex.getFullPath().removeLastSegments(1);
			PDDLInitialSituation initsit = fileIndex.getInitialSituation(context.getDefinitionName());
			if (initsit != null && context.getCodeModel() != null)
				domain = context.getCodeModel().getDomain(initsitDirpath, initsit.getDomainName());
			break;
		default:
		}

		return domain;
	}
	
	
	private ICompletionProvider[] completionProviders = {
			requirementsCompletionProvider,
			predicateCompletionProvider,
			objectCompletionProvider,
			typeCompletionProvider,
			variableCompletionProvider,
			keywordCompletionProvider,
			fileNameCompletionProvider
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
				;
		}
		
		Collections.sort(proposals);

		return proposals;
	}
	
	private IPDDLCodeModel getCodeModel() {
		if (nature != null)
			return nature.getCodeModel();
		return null;
	}
}
