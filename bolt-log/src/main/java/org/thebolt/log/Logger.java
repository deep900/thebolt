/**
 * 
 */
package org.thebolt.log;

/**
 * @author Pradheep
 *
 */
public interface Logger {

	public void log(LogInformation logInformation);	
	
	
	public void loadProperties();
	
	/**
	 * Loads the different formats of log output formats.
	 */
	public void loadLogStreamOutFormats();	
}
