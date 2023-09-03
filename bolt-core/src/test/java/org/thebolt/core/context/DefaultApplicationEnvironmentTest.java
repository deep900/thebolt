/**
 * 
 */
package org.thebolt.core.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.thebolt.core.scan.AutoBeanLoader;

/**
 * @author Pradheep
 *
 */
public class DefaultApplicationEnvironmentTest {
	

	private DefaultApplicationEnvironment appEnvironment = null;
	

	@Before
	public void init() {
		appEnvironment = DefaultApplicationEnvironment.getInstance();
	}

	@Test
	public void testAppEnvironment() {
		Assert.assertNotNull(appEnvironment);
		Assert.assertNotNull(appEnvironment.getBeanByName("logger"));
	}
	
	@Test
	public void testBeanCreation(){
		appEnvironment.loadBean("pop", "org.thebolt.core.context.Pop", BeanType.NEW_INSTANCE);
		Assert.assertNotNull(appEnvironment.getBeanByName("pop"));
		Pop popObj = (Pop) appEnvironment.getBeanByName("pop");
		Assert.assertEquals("Hello", popObj.sayHello());
	}	
}
