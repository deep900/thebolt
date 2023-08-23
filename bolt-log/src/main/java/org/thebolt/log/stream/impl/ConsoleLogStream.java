/**
 * 
 */
package org.thebolt.log.stream.impl;

import java.util.Properties;

import org.thebolt.log.LogFormatter;
import org.thebolt.log.LogInformation;
import org.thebolt.log.LogStream;

/**
 * @author Pradheep
 *
 */
public class ConsoleLogStream extends LogStream {
	
	private LogFormatter logFormatter;

	public ConsoleLogStream(Properties logStreamProperties) {
		super(logStreamProperties);	
	}

	@Override
	public LogFormatter getLogFormatter() {		
		return logFormatter;
	}

	@Override
	public void setLogFormatter(LogFormatter logFormatter) {
		this.logFormatter = logFormatter;
	}

	@Override
	public void writeLog(LogInformation logInformation) {
				
	}

}
