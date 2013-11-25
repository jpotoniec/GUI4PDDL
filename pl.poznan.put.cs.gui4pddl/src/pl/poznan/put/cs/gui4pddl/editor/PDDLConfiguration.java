package pl.poznan.put.cs.gui4pddl.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import pl.poznan.put.cs.gui4pddl.editor.scanners.CommentScanner;
import pl.poznan.put.cs.gui4pddl.editor.scanners.DefaultScanner;
import pl.poznan.put.cs.gui4pddl.editor.scanners.PDDLPartitionScanner;

public class PDDLConfiguration extends SourceViewerConfiguration {
	private final TokenManager tokenManager;

	public PDDLConfiguration(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return PDDLPartitionScanner.getLegalContentTypes();
	}

	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer dr;
		dr = new DefaultDamagerRepairer(new DefaultScanner(tokenManager));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		
		dr = new DefaultDamagerRepairer(new CommentScanner(tokenManager));
		reconciler.setDamager(dr, PDDLPartitionScanner.PDDL_COMMENT);
		reconciler.setRepairer(dr, PDDLPartitionScanner.PDDL_COMMENT);

		return reconciler;
	}

	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(new PDDLCompletionAssistant(),
				IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.enableAutoInsert(true);
		return assistant;
	}
}