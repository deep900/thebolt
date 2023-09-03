/**
 * 
 */
package org.thebolt.log.formatter.test;

import java.util.logging.Level;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.thebolt.log.LogInformation;
import org.thebolt.log.formatter.StandardFormatter;

/**
 * @author Pradheep
 *
 */
public class StandardFormatterTest {
	
	StandardFormatter formatter;
	LogInformation logInformation;

	@BeforeAll
	public void init(){
		formatter = new StandardFormatter();
		logInformation.setClassName("Test Class");
		logInformation.setLogLevel(Level.ALL);
		logInformation.setLogMessage("Message");
		logInformation.setMethodName("Method name");
		logInformation.setThrowable(new RuntimeException("Test"));		
	}
	
	@Test
	public void testFormatter(){
		Assert.assertNotNull(formatter.formatMessage(logInformation));
	}	
}
