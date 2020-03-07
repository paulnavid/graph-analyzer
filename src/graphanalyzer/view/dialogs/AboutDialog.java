package graphanalyzer.view.dialogs;

import java.awt.GridBagLayout;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.html.HTMLEditorKit;

import graphanalyzer.view.MainGUI;

/**
 * Dialog that informs the user about software version and author of the code.
 * 
 * @author paulehler
 *
 */
public class AboutDialog {
	
	/**
	 * An instance of MainGUI
	 */
	private MainGUI parent;
	
	/**
	 * Contructor of AboutDialog.
	 * 
	 * @param gui parent gui
	 */
	public AboutDialog(MainGUI gui) {
		this.parent = gui;
		
		ResourceBundle rb = gui.getResourceBundle();
		
		JTextPane text = new JTextPane();
		text.setEditorKit(new HTMLEditorKit()); // Set content type to HTML
		text.setText(rb.getString("aboutdialog.content"));
		text.setEditable(false);
		text.setFocusable(false);
		text.setOpaque(false);
		text.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE); // Use EditorPane styling over
		
		JDialog dialog = new JDialog(parent);
		dialog.setLayout(new GridBagLayout());
		dialog.setTitle(rb.getString("aboutdialog.title"));
		dialog.setSize(400, 200);
		dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(parent);
		dialog.setVisible(true);

		dialog.add(text);
        
	}

}
