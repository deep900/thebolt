/**
 * 
 */
package org.thebolt.log.formatter.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thebolt.log.LogInformation;
import org.thebolt.log.formatter.StandardFormatter;

/**
 * @author deep90
 *
 */
@DisplayName("Standard Formatter Test")
public class StandardFormatterTest {
	
	StandardFormatter formatter;

	@BeforeAll
	public void init(){
		formatter = new StandardFormatter();
	}
	
	@Test
	public void testFormatter(){
		LogInformation information = getLogInformationWithError();
		formatter.formatMessage(information);
		Assertions.assertTrue();
	}
	
	private LogInformation getLogInformationWithError(){
		
	}
}
