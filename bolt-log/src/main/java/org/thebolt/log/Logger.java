/**
 * 
 */
package org.thebolt.log;

import java.util.Map;

/**
 * @author Pradheep
 *
 */
public interface Logger {

	public void log(LogInformation logInformation);
	
	/**
	 * Loads the different formats of log output formats.
	 */
	public void loadLogStreamOutFormats();	
}
