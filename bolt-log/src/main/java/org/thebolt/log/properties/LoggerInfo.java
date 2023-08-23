package org.thebolt.log.properties;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoggerInfo {
	
	@JsonProperty("FileLogStream")
	private FileLogStreamProp fileLogStreamProp;
	
	@JsonProperty("ConsoleLogStream")
	private ConsoleLogStreamProp consoleLogStreamProp;
	
	public FileLogStreamProp getFileLogStreamProp() {
		return fileLogStreamProp;
	}
	public void setFileLogStreamProp(FileLogStreamProp fileLogStreamProp) {
		this.fileLogStreamProp = fileLogStreamProp;
	}
	public ConsoleLogStreamProp getConsoleLogStreamProp() {
		return consoleLogStreamProp;
	}
	public void setConsoleLogStreamProp(ConsoleLogStreamProp consoleLogStreamProp) {
		this.consoleLogStreamProp = consoleLogStreamProp;
	}
	@Override
	public String toString() {
		return "LoggerInfo [fileLogStreamProp=" + fileLogStreamProp + ", consoleLogStreamProp=" + consoleLogStreamProp
				+ "]";
	}
}
