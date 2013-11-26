package pl.poznan.put.cs.gui4pddl.editor;

import java.util.Iterator;
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
import pl.poznan.put.cs.gui4pddl.codemodel.IPDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeCompletionManager;
import pl.poznan.put.cs.gui4pddl.codemodel.PDDLCodeCompletionProposal;

public class PDDLCompletionAssistant implements IContentAssistProcessor {

	private final PDDLEditor Editor;

	public PDDLCompletionAssistant(PDDLEditor Editor) {
		this.Editor = Editor;
	}

	@SuppressWarnings("null")
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset) {
		ICompletionProposal[] proposals = null;
		try {
			IDocument document = viewer.getDocument();
			IRegion range = document.getLineInformationOfOffset(documentOffset);
			int start = range.getOffset();
			//String prefix = document.get(start, documentOffset - start);

			IEditorInput editor_input = Editor.getEditorInput();
			IFile file = ((IFileEditorInput) editor_input).getFile();
			IProject project = file.getProject();
			PDDLNature nature = PDDLNature.getPDDLNature(project);
			IPDDLCodeCompletionManager manager = nature
					.getCodeCompletionManager();
			List<PDDLCodeCompletionProposal> completions = manager
					.getCodeCompletionProposals(document, documentOffset);
			proposals = new CompletionProposal[completions.size()];
			int i = 0;
			for (Iterator<PDDLCodeCompletionProposal> iter = completions.iterator(); iter.hasNext();) {
				String completion = (String) iter.next().getText();
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
		return new char[] { ':', '?', '-' };
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}
}