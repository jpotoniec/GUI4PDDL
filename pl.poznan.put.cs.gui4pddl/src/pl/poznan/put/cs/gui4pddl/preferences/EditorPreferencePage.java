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
		addField(new ColorFieldEditor(Activator.PREF_QUESTION_COLOR,
				"&Variables", getFieldEditorParent()));
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