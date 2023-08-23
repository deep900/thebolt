/**
 * 
 */
package org.thebolt.log.stream.impl;

/**
 * @author Pradheep
 *
 */
public enum LogStreamType {
	FILELOGSTREAM("org.thebolt.log.stream.impl.FileLogStream"),
	KAFKALOGSTREAM("org.thebolt.log.stream.impl.KafkaLogStream"),
	CONSOLELOGSTREAM("org.thebolt.log.stream.impl.ConsoleLogStream");
	
	public final String label;
	
	private LogStreamType(String label) {
		this.label = label;
	}
	
	@Override 
	public String toString() { 
	    return this.label; 
	}
}
