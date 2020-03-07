package graphanalyzer;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import graphanalyzer.controller.MainController;

/**
 * Main class to start SCC application.
 * 
 * @author paulehler
 *
 */
public class GraphAnalyzerMain {
	private static final String MAC = "Mac";
    private static final String OS_NAME_KEY = "os.name";

	public static void main(String[] args)  {
		if (!System.getProperty(OS_NAME_KEY).startsWith(MAC)) {
          	try {
					UIManager.setLookAndFeel(
							UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
            	new MainController();
            } 
        }); 
		
	}
	
	private GraphAnalyzerMain() {
		// avoid initialization 
	}

}
