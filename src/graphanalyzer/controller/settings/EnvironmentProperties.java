package graphanalyzer.controller.settings;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

/**
 * 
 * @deprecated
 * 
 * @author Paul Ehler
 *
 */
@Deprecated(forRemoval=true)
public class EnvironmentProperties {
	
	private String OS_NAME_PROPERTY = "os.name";
	
	private int resolutionWidth;
	private int resolutionHeight;
	private int taskBarHeight;
	
	private String osName;
	
	/**
	 * 
	 */
	public EnvironmentProperties() {
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        DisplayMode displayMode = environment.getDefaultScreenDevice().getDisplayMode();
        
        osName = System.getProperty(OS_NAME_PROPERTY);
        
        if (osName.equals("Mac OS X")) {
			taskBarHeight = 27; // default taskbar height of mac os
		} else {
			taskBarHeight = 50;
		}
        
        resolutionWidth = displayMode.getWidth();
        resolutionHeight = displayMode.getHeight() - taskBarHeight;
        System.out.println(resolutionWidth + "  " + resolutionHeight);
	}

	/**
	 * 
	 * @return  resolutionWidth
	 */
	public int getResolutionWidth() {
		return resolutionWidth;
	}

	/**
	 * 
	 * @return  resolutionHeight
	 */
	public int getResolutionHeight() {
		return resolutionHeight;
	}

}
