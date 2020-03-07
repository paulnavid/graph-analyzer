package graphanalyzer.view.dialogs;

import javax.swing.JOptionPane;

/**
 * Message dialog to inform the user at any time.
 * <p>
 * Usage:
 * <pre>
 * MessageDialog.showMessage("The algorithm computed successfully.","Success"); // Open a new message dialog
 * 
 * MessageDialog.showWarning("Please provide a GraphML file.","Wrong data type"); // Open a new message dialog
 * 
 * MessageDialog.showMessage("Something went wrong, please restart the application.","Error"); // Open a new message dialog
 * </pre>
 * @author paulehler
 *
 */
public final class MessageDialog {
	
	private static final String DEFAULT_TITLE = "Graph Analyzer";
	
	private MessageDialog() {
		// Avoid initialization of class
	}
	
	/**
	 * Shows an information message dialog.
	 * 
	 * @param message  the text to be shwon as message dialog
	 * @param title  the title of the message dialog; if <tt>null</tt> the default title {@value #DEFAULT_TITLE} is used
	 */
	public static void showMessage(String message, String title) {
		show(message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Shows a warning message dialog.
	 * 
	 * @param message  the text to be shwon as message dialog
	 * @param title  the title of the message dialog; if <tt>null</tt> the default title {@value #DEFAULT_TITLE} is used
	 */
	public static void showWarning(String message, String title) {
		show(message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Shows an error message dialog to inform the user that something went wrong.
	 * 
	 * @param message  the text to be shwon as message dialog
	 * @param title  the title of the message dialog; if <tt>null</tt> the default title {@value #DEFAULT_TITLE} is used
	 */
	public static void showError(String message, String title) {
		show(message, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Display message dialog of given type.
	 * 
	 * @param messageText message text to display
	 * @param messageTitle title of dialog
	 * @param type type of message
	 */
	private static void show(String messageText, String messageTitle, int type) {
		if (messageTitle == null) {
			JOptionPane.showMessageDialog(null, messageText, DEFAULT_TITLE, type);
		} else {
			JOptionPane.showMessageDialog(null, messageText, messageTitle, type);
		}
        
    }
	
}
