/**
 * 
 */
package org.thebolt.core.scan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.thebolt.core.context.BeanType;
import org.thebolt.core.context.DefaultApplicationEnvironment;

/**
 * @author Pradheep
 *
 */
public class AutoScanBeansTest {

	private DefaultApplicationEnvironment appEnvironment = null;

	@Before
	public void init() {
		appEnvironment = DefaultApplicationEnvironment.getInstance();
	}

	@Test
	public void testScanBoltBeans() {
		System.out.println("Testing the auto scan bolt beans");
		appEnvironment.loadBean("autoBeanLoader","org.thebolt.core.scan.AutoBeanLoader", BeanType.NEW_INSTANCE);
		AutoBeanLoader autoBeanLoader = (AutoBeanLoader) appEnvironment.getBeanByName("autoBeanLoader");
		Assert.assertNotNull(autoBeanLoader.scanBoltBeans("org"));
	}
}
