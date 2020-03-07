package graphanalyzer.view.dialogs;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.WindowConstants;

import graphanalyzer.controller.MainController;
import graphanalyzer.view.MainGUI;

/**
 * Dialag that displays possible graphs that can be created via a button click.
 * <p>
 * In the future this class can easily be extended, because for further
 * different graph variations (e.g. undirected graphs or weighted graphs) you
 * only need to add the particular button and an ActionListener which then
 * informs the controller that a desired graph was requested.
 * 
 * @author paulehler
 *
 */
public class NewGraphDialog {

	private ResourceBundle rb;

	/**
	 * Creates a simple dialog to choose a specific graph variation.
	 * 
	 * e.g. a new directed graph
	 * 
	 * @param controller
	 * @param gui
	 */
	public NewGraphDialog(MainController controller, MainGUI gui) {

		// Set resource bundle according to current Locale
		rb = gui.getResourceBundle();

		JDialog dialog = new JDialog(gui.getFrame());
		dialog.setLayout(new GridLayout());
		dialog.setTitle(rb.getString("newgraphdialog.title"));

		// Initialize components
		JButton directedGraphBtn = new JButton(rb.getString("newgraphdialog.button.directedgraph"));

		// Add ActionListener to components
		directedGraphBtn.addActionListener(event -> {
			dialog.dispose();
			controller.requestNewDirectedGraph();
		});

		// Add components to dialog
		dialog.add(directedGraphBtn);

		// Settings for dialog
		dialog.setSize(300, 80);
		dialog.setLocationRelativeTo(gui.getFrame()); // Place Dialog in the middle of the parent frame
		dialog.setResizable(false);
		dialog.setAlwaysOnTop(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

}
