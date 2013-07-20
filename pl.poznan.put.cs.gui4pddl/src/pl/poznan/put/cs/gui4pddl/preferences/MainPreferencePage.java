package pl.poznan.put.cs.gui4pddl.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.Activator;

public class MainPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {
	public MainPreferencePage() {
		super(FieldEditorPreferencePage.GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	public void createFieldEditors() {
		IntegerFieldEditor portEditor = new IntegerFieldEditor(
				Activator.PREF_PORT,
				"&Port number for viewer (effective after restart):",
				getFieldEditorParent());
		portEditor.setValidRange(1000, 65535);
		addField(portEditor);
	}

	public void init(IWorkbench workbench) {
	}
}