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
package pl.poznan.put.cs.gui4pddl.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.Activator;

public class EditorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	public EditorPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("PDDL editor settings:");
	}

	public void createFieldEditors() {
		addField(new ColorFieldEditor(Activator.PREF_COMMENT_COLOR,
				"&Comments", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_VALUE_COLOR,
				"&Keywords", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_VARIABLE_COLOR,
				"&Variables", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_KEYWORD_COLOR,
				"&Keywords", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_BRACKET_COLOR,
				"&Brackets", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_DEFAULT_COLOR,
				"&Others", getFieldEditorParent()));
		// etc...
	}
	// ...

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}
}
