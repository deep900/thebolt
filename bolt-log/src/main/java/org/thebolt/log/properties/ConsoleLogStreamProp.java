package org.thebolt.log.properties;

import java.util.Properties;

public class ConsoleLogStreamProp extends Properties {
	
	private String className;
	
	private String logFormatter;
	
	public ConsoleLogStreamProp(){
		
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.setProperty("className", className);
		this.className = className;
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
		return "ConsoleLogStreamProp [className=" + className + ", logFormatter=" + logFormatter + "]";
	}

}
