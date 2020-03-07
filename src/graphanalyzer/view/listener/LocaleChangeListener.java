package graphanalyzer.view.listener;

import java.util.Locale;

/**
 * A listener interface for receiving changes in the application wide Locale.
 * <p>
 * The class that is interested in a change of Locale implements this interface,
 * and the created objject is registered using the addLocaleListener method.
 * When the Locale gets changed, the registered objects onLocaleChangeMethod is
 * invoked.
 * 
 * @author paulehler
 *
 */
public interface LocaleChangeListener {

	/**
	 * Implements changes that have to be made after the application wide Locale has
	 * changed.
	 * 
	 * @param currentLocale the new Locale to use
	 */
	void onLocaleChange(Locale currentLocale);
}
