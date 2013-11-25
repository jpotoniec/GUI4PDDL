package pl.poznan.put.cs.gui4pddl.editor;

import java.awt.List;
import java.util.Iterator;

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

public abstract class PDDLCompletionAssistant implements IContentAssistProcessor {
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int documentOffset, PDDLEditor editor) {
		ICompletionProposal[] proposals = null;
		try {
			IDocument document = viewer.getDocument();
			IRegion range = document.getLineInformationOfOffset(documentOffset);
			int start = range.getOffset();
			String prefix = document.get(start, documentOffset - start);
			
			
			IEditorInput editor_input = editor.getEditorInput();
			IFile file = ((IFileEditorInput) editor_input).getFile();
			IProject project = file.getProject();
			PDDLNature nature = PDDLNature.getPDDLNature(project);
			//PDDLCompletionManager manager = nature.getCompletionManager();
			//List completions = manager.
			
			/*int i = 0;
			for (Iterator iter = completions.iterator(); iter.hasNext();) {
				String completion = (String) iter.next();
				proposals[i++] = new CompletionProposal(completion, start,
						documentOffset - start, completion.length());*/
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
}