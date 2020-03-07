package graphanalyzer.view.dialogs;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import graphanalyzer.controller.MainController;
import graphanalyzer.view.MainGUI;

/**
 * Dialog to show and edit system wide settings.
 * <p>
 * 
 * 
 * @author paulehler
 *
 */
public class SettingsDialog {

	/**
	 * A ResourceBundle that is used for internationalization of all drawn dialogs
	 */
	private ResourceBundle rb;

	/**
	 * Constructor of SettingsDialog.
	 * 
	 * @param controller main controller
	 * @param gui        parent gui
	 */
	public SettingsDialog(MainController controller, MainGUI gui) {

		// Set resource bundle according to current Locale
		rb = gui.getResourceBundle();

		JDialog dialog = new JDialog(gui);
		dialog.setTitle(rb.getString("settingsdialog.title"));

		// Initialize all components for dialog
		JPanel container = new JPanel();

		JLabel chooseLanguageLabel = new JLabel(rb.getString("settingsdialog.label.chooselanguage"));
		JComboBox<String> languagesCombo = new JComboBox<>(
				controller.getSettings().getDisplayNamesOfProvidedLocales().toArray(new String[0]));
		languagesCombo.setSelectedItem(controller.getSettings().getDisplayNameOfLocale());

		JCheckBox showTutorial = new JCheckBox(rb.getString("settingsdialog.checkbox.showtutorial"),
				controller.getSettings().showTutorial());

		JButton applyButton = new JButton(rb.getString("settingsdialog.button.apply"));
		JButton closeButton = new JButton(rb.getString("settingsdialog.button.close"));

		// Add ActionListeners where needed
		applyButton.addActionListener(event -> {
			dialog.dispose();
			if (languagesCombo.getSelectedItem().equals("Deutsch")
					|| languagesCombo.getSelectedItem().equals("German")) {
				controller.getSettings().setLanguage(Locale.GERMANY);
			} else {
				controller.getSettings().setLanguage(Locale.ENGLISH);
			}
			controller.getSettings().setShowTutorial(showTutorial.isSelected());
		});

		closeButton.addActionListener(event -> dialog.dispose());

		// Add components to container
		container.add(chooseLanguageLabel);
		container.add(languagesCombo);
		container.add(showTutorial);
		container.add(applyButton);
		container.add(closeButton);

		// Add container to dialog
		dialog.add(container);

		dialog.setSize(300, 150);
		dialog.setAlwaysOnTop(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(gui.getFrame());
		dialog.setVisible(true);
	}

}
