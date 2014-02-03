/*******************************************************************************
 * Copyright (c) 2014 Poznan University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Poznan University of Technology - initial API and implementation
 ******************************************************************************/
package pl.poznan.put.cs.gui4pddl.editor;

import java.util.ResourceBundle;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import pl.poznan.put.cs.gui4pddl.Activator;

public class PDDLEditor extends TextEditor {
	private final TokenManager tokenManager;
	private final PDDLEditor Editor;
	private final ResourceBundle resourceBundle;

	public PDDLEditor() {
		super();
		Editor = this;
		tokenManager = Activator.getDefault().getTokenManager();
		resourceBundle = Activator.getDefault().getResourceBundle();
		setSourceViewerConfiguration(new PDDLConfiguration(tokenManager,Editor));
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

//	protected void createActions() {
//		super.createActions();
//		ContentAssistAction action = new ContentAssistAction(resourceBundle,
//				"ContentAssistProposal.", this);
//		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
//		setAction("ContentAssistProposal", action);
//	}
	
	public final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets";
	public final static String EDITOR_MATCHING_BRACKETS_COLOR= "matchingBracketsColor";
	 
	@Override
	protected void configureSourceViewerDecorationSupport (SourceViewerDecorationSupport support) {
		super.configureSourceViewerDecorationSupport(support);		
	 
		char[] matchChars = {'(', ')'}; //which brackets to match		
		ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(matchChars ,
				IDocumentExtension3.DEFAULT_PARTITIONING);
		support.setCharacterPairMatcher(matcher);
		support.setMatchingCharacterPainterPreferenceKeys(EDITOR_MATCHING_BRACKETS,EDITOR_MATCHING_BRACKETS_COLOR);
	 
		//Enable bracket highlighting in the preference store
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, "128,128,128");
	}
}
