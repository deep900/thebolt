/**
 * 
 */
package org.thebolt.log.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.thebolt.log.LogStream;

/**
 * @author Pradheep
 *
 */
public final class LogStreamBuilder<T extends LogStream> {
	
	protected T createLogStream(Properties properties,Class classRef) {
		try {
			Class<?> fileLogStreamClass = Class.forName((String) properties.get("className"));
			System.out.println("Creating :" + properties.get("className"));
			Constructor<?> constructor = fileLogStreamClass.getConstructor(Properties.class);			
			return (T) constructor.newInstance(properties);				
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
}
