package pl.poznan.put.cs.gui4pddl.editor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import pl.poznan.put.cs.gui4pddl.PDDLNature;
import pl.poznan.put.cs.gui4pddl.codecompletion.IPDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codecompletion.PDDLCodeCompletionProposal;

public class PDDLCompletionAssistant implements IContentAssistProcessor {

	private final PDDLEditor Editor;
	private List<PDDLCodeCompletionProposal> baseProps;

	public PDDLCompletionAssistant(PDDLEditor Editor) {
		this.Editor = Editor;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset) {
		ICompletionProposal[] proposals = null;
		try {
			IDocument document = viewer.getDocument();
			IRegion range = document.getLineInformationOfOffset(documentOffset);
			int start = range.getOffset();
			String prefix = document.get(start, documentOffset - start);
			prefix = cutOffString(prefix);
			start = documentOffset - prefix.length();

			IEditorInput editor_input = Editor.getEditorInput();
			IFile file = ((IFileEditorInput) editor_input).getFile();
			IProject project = file.getProject();
			PDDLNature nature = PDDLNature.getPDDLNature(project);
			IPDDLCodeCompletionManager manager = nature
					.getCodeCompletionManager();
			baseProps = manager.getCodeCompletionProposals(document,
					documentOffset);

			List<String> completions = getCompletions(prefix);
			proposals = new CompletionProposal[completions.size()];
			int i = 0;
			for (Iterator<String> iter = completions.iterator(); iter.hasNext();) {
				String completion = (String) iter.next();
				proposals[i++] = new CompletionProposal(completion, start,
						documentOffset - start, completion.length());
			}
		} catch (Exception e) {
			DebugPlugin.log(e);
		}
		return proposals;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { ':', '?', '-' };
	}

	public String getErrorMessage() {
		return "No completions available.";
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getCompletions(String prefix) {
		List<String> completions = new LinkedList<String>();
		for (Iterator<PDDLCodeCompletionProposal> iter = baseProps.iterator(); iter
				.hasNext();) {
			String test = (String) iter.next().getText();
			if (testCompletion(test, prefix))
				completions.add(test);
		}
		return completions;
	}

	private boolean testCompletion(String completion, String prefix) {
		return completion.toLowerCase().startsWith(prefix.toLowerCase())
				&& (completion.lastIndexOf(".") == prefix.lastIndexOf("."));
	}

	private String cutOffString(String test) {
		for (int i = test.length() - 1; i >= 0; i--) {
			char c = test.charAt(i);
			if(!Character.isLetter(c) && (((c != ':') && (c != '?')) || Character.isWhitespace(c))){
				if(i == test.length()-1)
					return "";
				else
					return test.substring(i+1);
			}
		}
		return test;
	}
}