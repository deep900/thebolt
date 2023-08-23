package org.thebolt.log.properties;

import java.util.Properties;

public class FileLogStreamProp extends Properties{

	private String className;

	private String logFilePath;

	private String maxFileSizeInMB;

	private String maxNumOfFilesToMaintain;

	private String rollingFiles;

	private String logFormatter;
	
	public FileLogStreamProp(){
		
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.setProperty("className",className);
		this.className = className;
	}

	public String getLogFilePath() {
		return logFilePath;
	}

	public void setLogFilePath(String logFilePath) {
		this.setProperty("logFilePath", logFilePath);
		this.logFilePath = logFilePath;
	}

	public String getMaxFileSizeInMB() {
		return maxFileSizeInMB;
	}

	public void setMaxFileSizeInMB(String maxFileSizeInMB) {
		this.setProperty("maxFileSizeInMB", maxFileSizeInMB);
		this.maxFileSizeInMB = maxFileSizeInMB;
	}

	public String getMaxNumOfFilesToMaintain() {
		return maxNumOfFilesToMaintain;
	}

	public void setMaxNumOfFilesToMaintain(String maxNumOfFilesToMaintain) {
		this.setProperty("maxNumOfFilesToMaintain", maxNumOfFilesToMaintain);
		this.maxNumOfFilesToMaintain = maxNumOfFilesToMaintain;
	}

	public String getRollingFiles() {
		return rollingFiles;
	}

	public void setRollingFiles(String rollingFiles) {
		this.setProperty("rollingFiles", rollingFiles);
		this.rollingFiles = rollingFiles;
	}

	public String getLogFormatter() {
		return logFormatter;
	}

	public void setLogFormatter(String logFormatter) {
		this.setProperty("logFormatter", logFormatter);
		this.logFormatter = logFormatter;
	}

	@Override
	public String toString() {
		return "FileLogStreamProp [className=" + className + ", logFilePath=" + logFilePath + ", maxFileSizeInMB="
				+ maxFileSizeInMB + ", maxNumOfFilesToMaintain=" + maxNumOfFilesToMaintain + ", rollingFiles="
				+ rollingFiles + ", logFormatter=" + logFormatter + "]";
	}
}
