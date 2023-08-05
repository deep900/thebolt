/**
 * 
 */
package org.thebolt.log.stream.impl;

import java.io.File;
import java.util.Properties;

import org.thebolt.log.LogFormatter;
import org.thebolt.log.LogInformation;
import org.thebolt.log.LogStream;

/**
 * @author Pradheep 
 *
 */
public class FileLogStream implements LogStream {

	private LogFormatter logFormatter;	
	
	private File outputFile;
	
	private FileLogStream() {
		
	}
	
	private static FileLogStream fileLogStream;

	public LogFormatter getLogFormatter() {
		return this.logFormatter;
	}

	public void setLogFormatter(LogFormatter logFormatter) {
		this.logFormatter = logFormatter;
	}

	/**
	 * This will be called by the Logger Implementation for writing the log to
	 * files.
	 */
	public void writeLog(LogInformation logInformation) {
		
	}

	public LogStream buildLogStream(Properties logStreamProperties) {		
		if(null == fileLogStream) {
			
		}
		return fileLogStream;
	}
}
