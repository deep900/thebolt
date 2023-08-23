/**
 * 
 */
package org.thebolt.log;

import java.util.Properties;

/**
 * This is the specification which specifies how the log has to be written to a
 * file , DB, Message Queue etc..
 * 
 * @author Pradheep
 *
 */
public abstract class LogStream {

	public abstract LogFormatter getLogFormatter();

	public abstract void setLogFormatter(LogFormatter logFormatter);
	
	/**
	 * Write the log in the specified format.
	 * @param logInformation
	 */
	public abstract void writeLog(LogInformation logInformation);
	
	public LogStream(Properties logStreamProperties){
		
	}
}
