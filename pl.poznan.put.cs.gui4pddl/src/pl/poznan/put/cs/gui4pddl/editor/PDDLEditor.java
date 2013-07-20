package pl.poznan.put.cs.gui4pddl.editor;

import java.util.ResourceBundle;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

import pl.poznan.put.cs.gui4pddl.Activator;

public class PDDLEditor extends TextEditor {
	private final TokenManager tokenManager;
	private final ResourceBundle resourceBundle;

	public PDDLEditor() {
		super();
		tokenManager = Activator.getDefault().getTokenManager();
		resourceBundle = Activator.getDefault().getResourceBundle();
		setSourceViewerConfiguration(new PDDLConfiguration(tokenManager));
		setDocumentProvider(new PDDLDocumentProvider());
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	protected boolean affectsTextPresentation(PropertyChangeEvent event) {
		return super.affectsTextPresentation(event)
				|| tokenManager.affectsTextPresentation(event);
	}

	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		tokenManager.handlePreferenceStoreChanged(event);
		super.handlePreferenceStoreChanged(event);
	}

	/*protected void createActions() {
		super.createActions();
		ContentAssistAction action = new ContentAssistAction(resourceBundle,
				"ContentAssistProposal.", this);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction("ContentAssistProposal", action);
	}*/
}