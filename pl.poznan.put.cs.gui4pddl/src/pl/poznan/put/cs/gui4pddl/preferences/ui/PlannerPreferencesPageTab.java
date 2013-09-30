package pl.poznan.put.cs.gui4pddl.preferences.ui;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import pl.poznan.put.cs.gui4pddl.Activator;
import pl.poznan.put.cs.gui4pddl.preferences.helpers.PlannerPreferencesStore;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;

/**
 * TabFolder tab - planner arguments settings
 *
 */
public class PlannerPreferencesPageTab {

	private FileFieldEditor plannerFile;
	private StringFieldEditor plannerName;
	private Button newArgumentButton;
	private Button editArgumentButton;
	private Button removeArgumentButton;
	private Button savePlannerButton;
	private Button removePlannerButton;
	private AddEditArgumentsDialog addEditArgumentsDialog;
	private final Table argumentsTable;
	private PlannerPreferences preferences;
	private TabFolder tabFolder;

	public StringFieldEditor getPlannerName() {
		return plannerName;
	}

	public FileFieldEditor getPlannerFile() {
		return plannerFile;
	}

	public PlannerPreferences getPlannerPreferences() {
		return preferences;
	}

	public PlannerPreferencesPageTab(Composite parent,
			final PlannerPreferences pref, final PreferencePage page,
			final TabFolder tabFolder, int style) {

		this.tabFolder = tabFolder;
		
		this.preferences = pref;
		final Composite fParent = parent;

		plannerName = new StringFieldEditor("Planner Name", "Planner Name",
				parent);
		plannerName.fillIntoGrid(parent, 3);
		plannerName.setEmptyStringAllowed(false);

		plannerFile = new FileFieldEditor("Planner File", "Planner File", true,
				StringFieldEditor.VALIDATE_ON_KEY_STROKE, parent);
		plannerFile.fillIntoGrid(parent, 3);
		plannerFile.setEmptyStringAllowed(false);

		plannerName.setStringValue(pref.getPlannerName());
		plannerFile.setStringValue(pref.getPlannerFilePath());

		plannerName.setPreferencePage(page);
		plannerFile.setPreferencePage(page);
		
		Composite tableComposite = new Composite(parent, SWT.NONE);
		
		

		argumentsTable = new Table(tableComposite, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL);
		GridData tableGridData = new GridData(GridData.FILL_BOTH);
		tableGridData.horizontalSpan = 2;
		tableComposite.setLayoutData(tableGridData);
		
		argumentsTable.setLayoutData(tableGridData);
		TableColumnLayout layout = new TableColumnLayout();
		tableComposite.setLayout( layout );


		argumentsTable.setLinesVisible(true);
		
		argumentsTable.setHeaderVisible(true);

		
		String[] titles = { "Name", "Text" };
		
		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(argumentsTable, SWT.CENTER);
			column.setText(titles[loopIndex]);
			layout.setColumnData( column, new ColumnWeightData( 50 ) );
			column.setResizable(false);
		}
		
		Composite tableButtonsComposite = new Composite(parent, SWT.NONE);
		GridLayout tableButtonsGridLayout = new GridLayout();
		tableButtonsComposite.setLayout(tableButtonsGridLayout);
		GridData tableButtonsGridData = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_FILL);
		tableButtonsGridData.horizontalSpan = 1;
		tableButtonsComposite.setLayoutData(tableButtonsGridData);

		GridData buttonsGridData = new GridData(GridData.FILL_HORIZONTAL);
		buttonsGridData.minimumWidth = 150;


		newArgumentButton = new Button(tableButtonsComposite, SWT.PUSH);
		newArgumentButton.setText("New Argument");
		newArgumentButton.setLayoutData(buttonsGridData);
		
		editArgumentButton = new Button(tableButtonsComposite, SWT.PUSH);
		editArgumentButton.setText("Edit Argument");
		editArgumentButton.setLayoutData(buttonsGridData);

		removeArgumentButton = new Button(tableButtonsComposite, SWT.PUSH);
		removeArgumentButton.setText("Remove Argument");
		removeArgumentButton.setLayoutData(buttonsGridData);

		editArgumentButton.setEnabled(false);
		removeArgumentButton.setEnabled(false);
		
		Label sep = new Label(tableButtonsComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		sep.setLayoutData(buttonsGridData);
		
		removePlannerButton = new Button(tableButtonsComposite, SWT.PUSH);
		removePlannerButton.setText("Remove Planner");
		removePlannerButton.setLayoutData(buttonsGridData);
		
		
		savePlannerButton = new Button(tableButtonsComposite, SWT.PUSH);
		savePlannerButton.setText("Save Planner");
		savePlannerButton.setLayoutData(buttonsGridData);
		

		addPropertyChangeListenersToPlannerFields(page, tabFolder);
		addListenersToArgumentsTable();
		addSelectionListenerToArgumentsButtons(fParent);
		addSelectionListenerToSaveButton(fParent);
		addSelectionListenerToRemoveButton(fParent);

		if (pref.getArgumentsMap() != null)
			setArguments(pref.getArgumentsMap());

	}

	private void addPropertyChangeListenersToPlannerFields(final PreferencePage page, final TabFolder tabFolder) {
		getPlannerName().setPropertyChangeListener(
				new IPropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent ev) {
						if (getPlannerName().isValid()
								&& getPlannerFile().isValid()
								&& getPlannerFile().getStringValue().length() > 1) {
							page.setValid(true);
							if (PlannerPreferencesStore.getPlannerPreferences().get(
									getPlannerName().getStringValue()) != null
									&& getPlannerName().getStringValue() != preferences
											.getPlannerName())
								savePlannerButton.setEnabled(false);
							else
								savePlannerButton.setEnabled(true);
						} else {
							page.setValid(false);
							savePlannerButton.setEnabled(false);
						}
						tabFolder.getSelection()[0].setText(getPlannerName()
								.getStringValue());

					}
				});

		getPlannerFile().setPropertyChangeListener(
				new IPropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						if (getPlannerName().isValid()
								&& getPlannerFile().isValid()
								&& getPlannerFile().getStringValue().length() > 1) {
							page.setValid(true);
							savePlannerButton.setEnabled(true);
						} else {
							page.setValid(false);
							savePlannerButton.setEnabled(false);
						}

					}
				});

		if (plannerFile.getStringValue().length() < 2) {
			plannerFile.setStringValue(" ");
			plannerFile.setStringValue("");
			page.setValid(false);

		}
	}
	
	private void addSelectionListenerToArgumentsButtons(final Composite fParent) {
		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == newArgumentButton) {
					addEditArgumentsDialog = new AddEditArgumentsDialog(
							fParent.getShell());
					int result = addEditArgumentsDialog.open();
					if (result == Dialog.OK) {

						if (isUniqueInTable(argumentsTable,
								addEditArgumentsDialog.getName())) {
							TableItem tableItem = new TableItem(argumentsTable,
									SWT.CENTER);
							tableItem.setText(new String[] {
									addEditArgumentsDialog.getName(),
									addEditArgumentsDialog.getText() });
						} else {
							MessageDialog.openError(fParent.getShell(),
									"Error", "Argument name already exsists!");
						}
					}
				} else if (event.widget == removeArgumentButton) {
					argumentsTable.remove(argumentsTable.getSelectionIndex());
					argumentsTable.forceFocus();

				} else if (event.widget == editArgumentButton) {
					addEditArgumentsDialog = new AddEditArgumentsDialog(
							fParent.getShell());
					TableItem item = argumentsTable.getItem(argumentsTable
							.getSelectionIndex());
					addEditArgumentsDialog.setName(item.getText(0));
					addEditArgumentsDialog.setText(item.getText(1));
					int result = addEditArgumentsDialog.open();

					if (result == Dialog.OK) {
						if (isUniqueInTable(argumentsTable,
								addEditArgumentsDialog.getName())) {
							item.setText(0, addEditArgumentsDialog.getName());
							item.setText(1, addEditArgumentsDialog.getText());
						} else {
							MessageDialog.openError(fParent.getShell(),
									"Error", "Argument name already exsists!");
						}
					}
				}
			}
		};
		
		newArgumentButton.addListener(SWT.Selection, listener);
		removeArgumentButton.addListener(SWT.Selection, listener);
		editArgumentButton.addListener(SWT.Selection, listener);
	}
	
	private void addListenersToArgumentsTable() {
		argumentsTable.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (argumentsTable.getSelectionIndex() < 0) {
					editArgumentButton.setEnabled(false);
					removeArgumentButton.setEnabled(false);
				} else {
					editArgumentButton.setEnabled(true);
					removeArgumentButton.setEnabled(true);
				}
			}
		});
		
		argumentsTable.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {		
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if (argumentsTable.getSelectionIndex() < 0) {
					editArgumentButton.setEnabled(false);
					removeArgumentButton.setEnabled(false);
				} else {
					editArgumentButton.setEnabled(true);
					removeArgumentButton.setEnabled(true);
				}
				
			}
		});
	}
	
	private void addSelectionListenerToSaveButton(final Composite fParent) {
		Listener saveListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == savePlannerButton) {
					
					boolean saveOk = PlannerPreferencesStore.savePlannerPreferences(plannerName.getStringValue(),plannerFile.getStringValue(),getArguments(),preferences);
					if (saveOk) {
						preferences = PlannerPreferencesStore.getPlannerPreferences().get(plannerName.getStringValue());
						MessageDialog.openInformation(fParent.getShell(), "Save successfull", "Planner preferences has been saved correctly.");
					} else {
						throw new RuntimeException("Could not save planner preferences");
					}
				}
			}
		};
		savePlannerButton.addListener(SWT.Selection, saveListener);
	}
	
	private void addSelectionListenerToRemoveButton(final Composite fParent) {
		Listener removeListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				if (event.widget == removePlannerButton) {
					boolean dialogOk = MessageDialog.openConfirm(fParent.getShell(), "Remove planner preferences", "Are you sure?");
					if (dialogOk) {
						boolean removeOk = PlannerPreferencesStore.removePlannerPreferences(preferences);
						if (PlannerPreferencesStore.getPlannerPreferences().size() == 0) {
							tabFolder.setVisible(false);
						}
						if (removeOk) {
							tabFolder.getSelection()[0].dispose();
							MessageDialog.openInformation(fParent.getShell(), "Planner Preferences removed", "Planner preferences has been removed");
						} else {
							throw new RuntimeException("Could not remove planner preferences");
						}
					}
					
				}
				
			}
			
		};
		removePlannerButton.addListener(SWT.Selection, removeListener);
	}

	private boolean isUniqueInTable(Table table, String text) {
		TableItem[] items = table.getItems();
		for (TableItem item : items) {
			if (item.getText(0).equals(addEditArgumentsDialog.getName())) {
				return false;
			}
		}
		return true;
	}

	public Map<String, String> getArguments() {
		Map<String, String> arguments = new TreeMap<String, String>();
		for (int i = 0; i < argumentsTable.getItemCount(); i++) {
			TableItem item = argumentsTable.getItem(i);
			arguments.put(item.getText(0), item.getText(1));
		}

		return arguments;

	}

	public void setArguments(Map<String, String> arguments) {
		for (String key : arguments.keySet()) {
			TableItem item = new TableItem(argumentsTable, SWT.CENTER);
			item.setText(0, key);
			item.setText(1, arguments.get(key));
		}
	}

}
