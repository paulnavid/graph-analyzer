package graphanalyzer.view.listener;

import graphanalyzer.controller.settings.Settings;

/**
 * A listener interface for receiving changes in the application wide settings.
 * <p>
 * The class that is interested in a change of {@link Settings} implements this interface,
 * and the created object is registered using the addLocaleListener method.
 * When the Locale gets changed, the registered objects {@link #onSettingsChange} method is
 * invoked.
 * 
 * @author paulehler
 *
 */
public interface SettingsChangeListener {

	/**
	 * Implements changes that have to be made after the application wide settings have
	 * changed.
	 * 
	 * @param changedSettings the changed settings
	 */
	void onSettingsChange(Settings changedSettings);

}
