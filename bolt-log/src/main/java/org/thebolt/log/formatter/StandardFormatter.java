/**
 * 
 */
package org.thebolt.log.formatter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.thebolt.log.LogFormatter;
import org.thebolt.log.LogInformation;
import org.thebolt.log.stream.impl.StandardLogInformation;

/**
 * @author Pradheep
 *
 */
public class StandardFormatter implements LogFormatter {
	
	private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	private PrintStream printStream = new PrintStream(outputStream);	
	
	public String formatMessage(LogInformation logInformation) {
		StringBuilder formatMessage = new StringBuilder();
		formatMessage = formatMessage.append(getCurrentDateWithZone());		
		formatMessage.append(" [" + logInformation.getLogLevel() + "]");
		if(null != logInformation.getClassName()) {
			formatMessage.append(" " + logInformation.getClassName());
		}
		if(null != logInformation.getMethodName()) {
			formatMessage.append(": " + logInformation.getMethodName());
		}
		formatMessage.append(" ["+Thread.currentThread().getName() + "] ");
		if(null != logInformation.getThrowable()){
			logInformation.getThrowable().printStackTrace(printStream);
			byte[] logDataInBytes = outputStream.toByteArray();
			String logInfo = new String(logDataInBytes);
			formatMessage.append(logInfo);
			outputStream.reset();
			try {
				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(null != logInformation.getLogMessage()) {
			formatMessage.append(logInformation.getLogMessage());
		}
		return formatMessage.toString();
	}
	
	private String getCurrentDateWithZone(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		return sdf.format(new Date());
	}
	
	public static void main(String args[]) {
		LogInformation log = new StandardLogInformation();
		log.setLogLevel(Level.INFO);
		log.setLogMessage("Transaction failed");
		log.setThrowable(new RuntimeException("Hello World"));
		log.setClassName(log.getClass().getName());
		log.setMethodName("Main");
		StandardFormatter sf = new StandardFormatter();
		System.out.println(sf.formatMessage(log));		
	}
}
