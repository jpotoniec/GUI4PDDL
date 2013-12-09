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
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import pl.poznan.put.cs.gui4pddl.preferences.PlannerPreferencePage;
import pl.poznan.put.cs.gui4pddl.preferences.model.PlannerPreferences;
import pl.poznan.put.cs.gui4pddl.preferences.model.manager.PlannerPreferencesManager;

/**
 * TabFolder tab - planner arguments settings
 * 
 */
public class PlannerPreferencesPageTabItem {

	private FileFieldEditor plannerFile;
	private StringFieldEditor plannerName;
	private Button newArgumentButton;
	private Button editArgumentButton;
	private Button removeArgumentButton;
	// private Button savePlannerButton;
	private Button removePlannerButton;
	private Button planViewDialogButton;
	private PlannerArgumentsDialog addEditArgumentsDialog;
	private Table argumentsTable;
	private PlannerPreferences preferences;
	private PlannerPreferencePage page;
	private PlanViewDialog planViewDialog;

	private static final int PLANNER_NAME_TEXT_LIMIT = 30;

	public PlannerPreferencesPageTabItem(final PlannerPreferences preferences,
			final PlannerPreferencePage page, final TabFolder tabFolder) {

		this.preferences = preferences;
		this.page = page;

		TabItem item = new TabItem(tabFolder, SWT.NULL);

		Composite tabItemComposite = createAndSetCompositeOfTabItem(tabFolder,
				item);
		plannerName = createPlannerNameFieldEditor(tabItemComposite);
		plannerFile = createPlannerFileFieldEditor(tabItemComposite);

		plannerName.setTextLimit(PLANNER_NAME_TEXT_LIMIT);

		argumentsTable = createArgumentsTable(tabItemComposite);

		planViewDialog = new PlanViewDialog(tabItemComposite.getShell());
		planViewDialog
				.setRegexp((preferences.getPlanViewFilePattern() != null) ? preferences
						.getPlanViewFilePattern() : "");

		Composite tableButtonsComposite = createTableButtonsComposite(tabItemComposite);

		newArgumentButton = createTableButton(tableButtonsComposite,
				"New Argument");
		editArgumentButton = createTableButton(tableButtonsComposite,
				"Edit Argument");
		removeArgumentButton = createTableButton(tableButtonsComposite,
				"Remove Argument");

		editArgumentButton.setEnabled(false);
		removeArgumentButton.setEnabled(false);

		createTableButtonsSeparator(tableButtonsComposite);

		removePlannerButton = createTableButton(tableButtonsComposite,
				"Remove Planner");
		/*
		 * savePlannerButton = createTableButton(tableButtonsComposite,
		 * "Save Planner");
		 */

		createTableButtonsSeparator(tableButtonsComposite);

		planViewDialogButton = createTableButton(tableButtonsComposite,
				"Plan View");

		addPropertyChangeListenerToPlannerNameFieldEditor(tabFolder);
		addPropertyChangeListenerToPlannerFileFieldEditor();

		addListenersToArgumentsTable();

		addSelectionListenerToNewArgumentButton(tabItemComposite);
		addSelectionListenerToEditArgumentButton(tabItemComposite);
		addSelectionListenerToRemoveArgumentButton(tabItemComposite);

		// addSelectionListenerToSavePlannerButton(tabItemComposite);
		addSelectionListenerToRemovePlannerButton(tabItemComposite, tabFolder);

		addSelectionListenerToPlanViewDialogButton();

		if (this.preferences.getArgumentsMap() != null)
			setArguments(this.preferences.getArgumentsMap());

		/*
		 * if (plannerFile.getStringValue().isEmpty()) {
		 * savePlannerButton.setEnabled(false); }
		 */

		item.setControl(tabItemComposite);

	}

	private Composite createAndSetCompositeOfTabItem(TabFolder tabFolder,
			TabItem item) {

		item.setText(preferences.getPlannerName());
		Composite tabItemComposite = new Composite(tabFolder, SWT.NONE);
		GridLayout tabItemGridLayout = new GridLayout();
		tabItemGridLayout.numColumns = 3;

		tabItemComposite.setLayout(tabItemGridLayout);
		tabItemComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		return tabItemComposite;
	}

	private StringFieldEditor createPlannerNameFieldEditor(
			Composite tabItemComposite) {
		StringFieldEditor plannerName = new StringFieldEditor("Planner Name",
				"Planner Name", tabItemComposite);
		plannerName.fillIntoGrid(tabItemComposite, 3);
		plannerName.setEmptyStringAllowed(false);
		plannerName.setStringValue(preferences.getPlannerName());

		return plannerName;
	}

	private FileFieldEditor createPlannerFileFieldEditor(
			Composite tabItemComposite) {
		FileFieldEditor plannerFile = new FileFieldEditor("Planner File",
				"Planner File", true, StringFieldEditor.VALIDATE_ON_KEY_STROKE,
				tabItemComposite);
		plannerFile.fillIntoGrid(tabItemComposite, 3);
		plannerFile.setEmptyStringAllowed(false);
		plannerFile.setStringValue(preferences.getPlannerFilePath());

		return plannerFile;
	}

	private Table createArgumentsTable(Composite tabItemComposite) {
		Composite tableComposite = new Composite(tabItemComposite, SWT.NONE);
		Table argumentsTable = new Table(tableComposite, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL);
		GridData tableGridData = new GridData(GridData.FILL_BOTH);
		tableGridData.horizontalSpan = 2;
		tableComposite.setLayoutData(tableGridData);

		TableColumnLayout layout = new TableColumnLayout();
		tableComposite.setLayout(layout);

		argumentsTable.setLinesVisible(true);
		argumentsTable.setHeaderVisible(true);

		String[] titles = { "Name", "Text" };
		for (int i = 0; i < titles.length; i++) {
			final TableColumn column = new TableColumn(argumentsTable,
					SWT.CENTER);
			column.setText(titles[i]);
			layout.setColumnData(column, new ColumnWeightData(50));
			column.setResizable(true);
			column.setMoveable(false);
			column.addControlListener(new ControlAdapter() {
				public void controlResized(ControlEvent e) {
					if (column.getWidth() < 5)
						column.setWidth(5);

				}
			});
		}
		return argumentsTable;
	}

	private Composite createTableButtonsComposite(Composite tabItemComposite) {
		Composite tableButtonsComposite = new Composite(tabItemComposite,
				SWT.NONE);
		GridLayout tableButtonsGridLayout = new GridLayout();
		tableButtonsComposite.setLayout(tableButtonsGridLayout);
		GridData tableButtonsGridData = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING
						| GridData.HORIZONTAL_ALIGN_FILL);
		tableButtonsGridData.horizontalSpan = 1;
		tableButtonsComposite.setLayoutData(tableButtonsGridData);

		return tableButtonsComposite;
	}

	private Button createTableButton(Composite tableButtonsComposite,
			String text) {
		GridData buttonsGridData = new GridData(GridData.FILL_HORIZONTAL);
		buttonsGridData.minimumWidth = 150;

		Button button = new Button(tableButtonsComposite, SWT.PUSH);
		button.setText(text);
		button.setLayoutData(buttonsGridData);

		return button;
	}

	private void createTableButtonsSeparator(Composite tableButtonsComposite) {
		GridData buttonsGridData = new GridData(GridData.FILL_HORIZONTAL);
		buttonsGridData.minimumWidth = 150;

		Label separator = new Label(tableButtonsComposite, SWT.SEPARATOR
				| SWT.HORIZONTAL);
		separator.setLayoutData(buttonsGridData);
	}

	private void addPropertyChangeListenerToPlannerNameFieldEditor(
			final TabFolder tabFolder) {
		plannerName.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent ev) {

				// setSavePlannerButtonEnabledIfConfigurationValid();
				page.checkIfAllPageTabItemsAreValid();
				tabFolder.getSelection()[0].setText(plannerName
						.getStringValue());
			}
		});
	}

	private void addPropertyChangeListenerToPlannerFileFieldEditor() {
		plannerFile.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {

				page.checkIfAllPageTabItemsAreValid();
				// setSavePlannerButtonEnabledIfConfigurationValid();
			}
		});
	}

	public boolean checkIfTabItemIsValidAndSetErrorMessages() {
		boolean valid = true;

		if (plannerName.isValid() && plannerFile.isValid()
				&& plannerFile.getStringValue().length() > 0) {

			// if plannerName has been changed to name that exists
			if (PlannerPreferencesManager.getManager().getPlannerPreferences()
					.get(plannerName.getStringValue()) != null
					&& !plannerName.getStringValue().equals(
							preferences.getPlannerName())) {
				page.setErrorMessage("Planner name of "
						+ plannerName.getStringValue() + " already exists");
				// savePlannerButton.setEnabled(false);
				page.setValid(false);
				valid = false;
			} else {
				page.setErrorMessage(null);
				// savePlannerButton.setEnabled(true);
				page.setValid(true);
				valid = true;
			}
		} else {
			page.setErrorMessage("Planner file/name of "
					+ plannerName.getStringValue() + " is not correct");
			page.setValid(false);
			// savePlannerButton.setEnabled(false);
			valid = false;
		}

		// if plannerName is correct
		String name = plannerName.getStringValue();
		boolean validString = true;
		for (char c : name.toCharArray()) {
			if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)
					|| c == '.' || c == '_' || c == '-') {
				validString = true;

			} else {
				validString = false;
				break;
			}
		}
		if (validString && valid) {
			page.setErrorMessage(null);
			// savePlannerButton.setEnabled(true);
			page.setValid(true);
		} else if (!validString) {
			page.setErrorMessage("Planner name of "
					+ plannerName.getStringValue() + " is not correct");
			// savePlannerButton.setEnabled(false);
			page.setValid(false);
		}

		return validString && valid;
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

	private void addSelectionListenerToNewArgumentButton(final Composite fParent) {
		newArgumentButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				addEditArgumentsDialog = new PlannerArgumentsDialog(fParent
						.getShell());
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
						MessageDialog.openError(fParent.getShell(), "Error",
								"Argument name already exsists!");
					}
				}
			}
		});
	}

	private void addSelectionListenerToEditArgumentButton(
			final Composite fParent) {
		editArgumentButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				addEditArgumentsDialog = new PlannerArgumentsDialog(fParent
						.getShell());
				TableItem item = argumentsTable.getItem(argumentsTable
						.getSelectionIndex());
				String oldName = item.getText(0);
				String oldText = item.getText(1);
				addEditArgumentsDialog.setName(oldName);
				addEditArgumentsDialog.setText(oldText);
				int result = addEditArgumentsDialog.open();

				if (result == Dialog.OK) {

					if (isUniqueInTable(argumentsTable,
							addEditArgumentsDialog.getName())
							|| addEditArgumentsDialog.getName().equals(oldName)) {
						item.setText(0, addEditArgumentsDialog.getName());
						item.setText(1, addEditArgumentsDialog.getText());
					} else {
						MessageDialog.openError(fParent.getShell(), "Error",
								"Argument name already exsists!");
					}
				}
			}
		});
	}

	private void addSelectionListenerToRemoveArgumentButton(
			final Composite fParent) {
		removeArgumentButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				argumentsTable.remove(argumentsTable.getSelectionIndex());
				argumentsTable.forceFocus();
			}
		});
	}

	/*
	 * private void addSelectionListenerToSavePlannerButton(final Composite
	 * fParent) {
	 * 
	 * savePlannerButton.addSelectionListener(new SelectionAdapter() {
	 * 
	 * @Override public void widgetSelected(SelectionEvent arg0) { boolean
	 * saveOk = PlannerPreferencesStore
	 * .savePlannerPreferences(plannerName.getStringValue(),
	 * plannerFile.getStringValue(), getArguments(), planViewDialog.getRegexp(),
	 * preferences); if (saveOk) { preferences = PlannerPreferencesStore
	 * .getPlannerPreferences().get( plannerName.getStringValue());
	 * MessageDialog.openInformation(fParent.getShell(), "Save successfull",
	 * "Planner preferences has been saved correctly."); } else {
	 * MessageDialog.openError(fParent.getShell(), "Error while saving",
	 * "Could not save planner preferences. Restart Eclipse and try again.");
	 * throw new RuntimeException( "Could not save planner preferences"); } }
	 * }); }
	 */

	public boolean savePlannerPreferences() {
		boolean saveOk = PlannerPreferencesManager.getManager()
				.savePlannerPreferences(plannerName.getStringValue(),
						plannerFile.getStringValue(), getArguments(),
						planViewDialog.getRegexp(), preferences);
		if (saveOk) {
			preferences = PlannerPreferencesManager.getManager()
					.getPlannerPreferences().get(plannerName.getStringValue());
		}

		return saveOk;
	}

	public boolean preferencesChanged() {
		boolean temp = (!plannerName.getStringValue().equals(
				preferences.getPlannerName()))
				|| (!plannerFile.getStringValue().equals(
						preferences.getPlannerFilePath()))
				|| (!planViewDialog.getRegexp().equals(
						preferences.getPlanViewFilePattern()));

		Map<String, String> map = getArguments();

		boolean argsChanged = false;

		if (map != null && preferences.getArgumentsMap() != null) {
			if (map.size() != preferences.getArgumentsMap().size()) {
				argsChanged = true;
			} else {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					if (!preferences.getArgumentsMap().containsKey(
							entry.getKey())
							|| !preferences.getArgumentsMap()
									.get(entry.getKey())
									.equals(entry.getValue())) {
						argsChanged = true;
						break;
					}
				}
			}

		} else if (map == null && preferences.getArgumentsMap() == null) {
			argsChanged = false;
		} else {
			argsChanged = true;
		}

		// TODO zmienic metode porownywania map
		/*if (map != null && map.size() > 0
				&& preferences.getArgumentsMap() != null
				&& preferences.getArgumentsMap().size() > 0) {
			for (String key : map.keySet()) {
				if (preferences.getArgumentsMap().containsKey(key)) {
					argsChanged = argsChanged
							|| (!preferences.getArgumentsMap().get(key)
									.equals(map.get(key)));
				} else {
					argsChanged = true;
					break;
				}
			}
		}
		if (map != null && map.size() > 0
				&& preferences.getArgumentsMap() != null
				&& preferences.getArgumentsMap().size() > 0) {
			for (String key : preferences.getArgumentsMap().keySet()) {
				if (map.containsKey(key)) {
					argsChanged = argsChanged
							|| (!preferences.getArgumentsMap().get(key)
									.equals(map.get(key)));
				} else {
					argsChanged = true;
					break;
				}
			}
		}*/
		return argsChanged || temp;
	}

	private void addSelectionListenerToRemovePlannerButton(
			final Composite fParent, final TabFolder tabFolder) {
		removePlannerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				boolean dialogOk = MessageDialog.openConfirm(
						fParent.getShell(), "Remove planner preferences",
						"Are you sure?");
				if (dialogOk) {
					boolean removeOk = PlannerPreferencesManager.getManager()
							.removePlannerPreferences(preferences);
					if (removeOk) {
						tabFolder.getSelection()[0].dispose();
						if (tabFolder.getItemCount() == 0) {
							tabFolder.setVisible(false);
							page.setValid(true);
							page.setErrorMessage(null);
						}

						MessageDialog.openInformation(fParent.getShell(),
								"Planner Preferences removed",
								"Planner preferences has been removed");
					} else {
						MessageDialog.openError(
								fParent.getShell(),
								"Error while removing",
								"Could not remove planner preferences. Check if the file is in use by another program.");
						throw new RuntimeException(
								"Could not remove planner preferences");
					}
				}
			}
		});
	}

	private void addSelectionListenerToPlanViewDialogButton() {
		planViewDialogButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				planViewDialog.open();

			}

		});
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

	private Map<String, String> getArguments() {
		Map<String, String> arguments = new TreeMap<String, String>();
		for (int i = 0; i < argumentsTable.getItemCount(); i++) {
			TableItem item = argumentsTable.getItem(i);
			arguments.put(item.getText(0), item.getText(1));
		}

		return arguments;
	}

	private void setArguments(Map<String, String> arguments) {
		for (String key : arguments.keySet()) {
			TableItem item = new TableItem(argumentsTable, SWT.CENTER);
			item.setText(0, key);
			item.setText(1, arguments.get(key));
		}
	}

}
