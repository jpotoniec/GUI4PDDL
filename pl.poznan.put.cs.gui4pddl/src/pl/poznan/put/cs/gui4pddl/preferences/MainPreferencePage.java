package pl.poznan.put.cs.gui4pddl.preferences;

import java.util.Map;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

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

		addField(new BooleanFieldEditor(Activator.PREF_SHOW_PLAN_BROWSER,
				"&Show Plan Browser after finish planning process.",
				getFieldEditorParent()));

	}


	public void init(IWorkbench workbench) {

	}
}