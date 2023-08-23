/**
 * 
 */
package org.thebolt.log.stream.impl;

import java.util.Properties;

import org.thebolt.log.LogFormatter;
import org.thebolt.log.LogInformation;
import org.thebolt.log.LogStream;

/**
 * Kafka implementation of log stream. Where the logs are written in kafka topics.
 * 
 * @author Pradheep
 *
 */
public class KafkaLogStream extends LogStream {

	public KafkaLogStream(Properties logStreamProperties) {
		super(logStreamProperties);		
	}

	@Override
	public LogFormatter getLogFormatter() {		
		return null;
	}

	@Override
	public void setLogFormatter(LogFormatter logFormatter) {		
		
	}

	@Override
	public void writeLog(LogInformation logInformation) {		
		
	}
}
