/**
 * 
 */
package org.thebolt.log.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.thebolt.log.LogInformation;
import org.thebolt.log.LogStream;
import org.thebolt.log.Logger;
import org.thebolt.log.properties.ConsoleLogStreamProp;
import org.thebolt.log.properties.FileLogStreamProp;
import org.thebolt.log.properties.LoggerProperties;
import org.thebolt.log.stream.impl.ConsoleLogStream;
import org.thebolt.log.stream.impl.FileLogStream;
import org.thebolt.log.stream.impl.StandardLogInformation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * Bolt Logger implemenation, takes care of logging requests to different
 * formats.
 * 
 * @author Pradheep
 *
 */
public class BoltLogger implements Logger {

	private List<LogStream> logStreams = new ArrayList<LogStream>();

	private static BoltLogger boltLogger = new BoltLogger();

	private LogStreamBuilder<LogStream> logStreamBuilder = new LogStreamBuilder<>();

	private LoggerProperties properties;

	public static BoltLogger getInstance() {
		return boltLogger;
	}

	private BoltLogger() {
		properties = loadProperties();
		loadLogStreamOutFormats();
		System.out.println("Loaded " + logStreams.size() + " log streams");
	}

	public void log(LogInformation logInformation) {
		logStreams.parallelStream().forEach(logStream -> {
			logStream.writeLog(logInformation);
		});
	}

	private LoggerProperties loadProperties() {
		System.out.println("Loading the bolt logger properties");
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.yaml");
		try {
			LoggerProperties loggerProperties = mapper.readValue(inputStream, LoggerProperties.class);
			System.out.println(loggerProperties.toString());
			return loggerProperties;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void loadLogStreamOutFormats() {
		if (null != properties) {
			FileLogStreamProp fileLogStreamProp = properties.getLoggerInfo().getFileLogStreamProp();
			FileLogStream fileLogStream = (FileLogStream) logStreamBuilder.createLogStream(fileLogStreamProp,
					FileLogStream.class);
			if (null != fileLogStream) {
				logStreams.add(fileLogStream);
			}
			ConsoleLogStreamProp consoleLogStreamProp = properties.getLoggerInfo().getConsoleLogStreamProp();
			ConsoleLogStream consoleLogStream = (ConsoleLogStream) logStreamBuilder
					.createLogStream(consoleLogStreamProp, ConsoleLogStream.class);
			if (null != consoleLogStream) {
				logStreams.add(consoleLogStream);
			}
		} else {
			System.out.println("Unable to read the properties file.");
		}
	}

	public void logMessage(String message, Level logLevel) {
		LogInformation logInformation = getBasicLogInformation(message,logLevel);
		logInformation.setThrowable(null);
		log(logInformation);
	}

	public void logMessage(String message, Throwable err, Level logLevel) {
		LogInformation logInformation = getBasicLogInformation(message,logLevel);
		logInformation.setThrowable(err);
		log(logInformation);
	}

	private LogInformation getBasicLogInformation(String message, Level logLevel) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String callerClass = ste.getClassName();
		String callerMethod = ste.getMethodName();
		LogInformation logInformation = new StandardLogInformation();
		logInformation.setMethodName(callerMethod);
		logInformation.setClassName(callerClass);
		logInformation.setLogMessage(message);
		logInformation.setLogLevel(logLevel);
		return logInformation;
	}

	public static void main(String args[]) {
		BoltLogger boltLogger = getInstance();
	}
}
