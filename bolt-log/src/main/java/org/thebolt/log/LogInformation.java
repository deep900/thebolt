/**
 * 
 */
package org.thebolt.log;

import java.util.logging.Level;
/**
 * @author Pradheep
 *
 */
public abstract class LogInformation {
	
	private String logMessage;
	
	private Throwable throwable;
	
	private Level logLevel;
	
	private String className;
	
	private String methodName;	

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public Level getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(Level logLevel) {
		this.logLevel = logLevel;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}		
}
