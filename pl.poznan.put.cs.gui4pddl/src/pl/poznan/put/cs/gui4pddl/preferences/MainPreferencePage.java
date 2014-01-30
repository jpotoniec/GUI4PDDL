package pl.poznan.put.cs.gui4pddl.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
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

		addField(new BooleanFieldEditor(Activator.PREF_SHOW_PLAN_BROWSER,
				"&Show Plan Browser after finish planning process.",
				getFieldEditorParent()));

	}


	public void init(IWorkbench workbench) {

	}
}