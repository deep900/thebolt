/**
 * 
 */
package org.thebolt.log.properties;

/**
 * @author Pradheep
 *
 */
public class LoggerProperties {

	private LoggerInfo loggerInfo;

	public LoggerInfo getLoggerInfo() {
		return loggerInfo;
	}

	public void setLoggerInfo(LoggerInfo loggerInfo) {
		this.loggerInfo = loggerInfo;
	}

	@Override
	public String toString() {
		return "LoggerProperties [loggerInfo=" + loggerInfo + "]";
	}	
}
