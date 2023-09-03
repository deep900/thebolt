/**
 * 
 */
package org.thebolt.log.stream.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.thebolt.log.LogFormatter;
import org.thebolt.log.LogInformation;
import org.thebolt.log.LogStream;

/**
 * This class is the file log stream , writes the logs into a file based system.
 * 
 * Supports logs rolling after the predefined size in the application.yaml file.
 * 
 * @author Pradheep
 *
 */
public class FileLogStream extends LogStream {

	private LogFormatter logFormatter;

	private File outputFile;

	private int fileSizeInMB = 5;

	private static final long BYTEMBCONFACTOR = 1048576l;

	private int fileNamePart = 1;

	private String currentDateNamePart;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyyZ");	
	
	public FileLogStream(Properties properties) {
		super(properties);
		currentDateNamePart = getFileNameDatePart();
		buildLogStream(properties);
	}

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
	public synchronized void writeLog(LogInformation logInformation) {
		//Write the log file and then compare the file size.
		checkLogFileAndCreateNewInstance();
	}

	public void buildLogStream(Properties logStreamProperties) {		
		try {
			String logFileName = logStreamProperties.getProperty("logFilePath");
			if (null == logFileName || logFileName.isEmpty()) {
				throw new IllegalArgumentException(
						"Log file property \"logFilePath\" is missing in the application.yaml");
			}
			outputFile = new File(logFileName + String.valueOf(fileNamePart) + ".log");
			if(!outputFile.exists()) {
				System.out.println(outputFile.createNewFile() ? "Log file created successfully" : "Unable to create the log file");
			}
			System.out.println("Writting the logs in path :" + outputFile.getAbsolutePath());
			String fileSize = logStreamProperties.getProperty("maxFileSizeInMB");
			if (null == fileSize || fileSize.isEmpty()) {
				System.out.println("Warning: Rolling file size will be taken as 5MB");
			} else {
				fileSizeInMB = Integer.parseInt(fileSize);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}		
	}

	private boolean isLogFileReachedThreshold() {
		long fileSizeInBytes = this.outputFile.length();
		return fileSizeInMB > (fileSizeInBytes / BYTEMBCONFACTOR);
	}

	private String getFileNameSuffix() {
		String cDateNamePart = getFileNameDatePart();
		if (currentDateNamePart.equalsIgnoreCase(cDateNamePart)) {
			fileNamePart++;
		} else {
			currentDateNamePart = cDateNamePart;
			fileNamePart = 1;
		}
		return currentDateNamePart + "_" + fileNamePart;
	}

	private String getFileNameDatePart() {
		return sdf.format(new Date());
	}

	private void checkLogFileAndCreateNewInstance() {
		if (isLogFileReachedThreshold()) {
			
		}
	}
	
	public void init(){
		
	}
}
