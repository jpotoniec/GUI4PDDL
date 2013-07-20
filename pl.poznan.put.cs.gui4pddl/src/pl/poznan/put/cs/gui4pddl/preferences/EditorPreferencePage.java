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
		addField(new ColorFieldEditor(Activator.PREF_FORMAT_COLOR,
				"&Formats", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_DEFINE_COLOR,
				"&Definitions", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_KEYWORD_COLOR,
				"&Keywords", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_DEFAULT_COLOR,
				"&Others", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_VALUE_COLOR,
				"&Values", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_QUESTION_COLOR,
				"&Questions", getFieldEditorParent()));
		addField(new ColorFieldEditor(Activator.PREF_COMPARE_COLOR,
				"&Comparators", getFieldEditorParent()));
		// etc...
	}
	// ...

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub
		
	}
}