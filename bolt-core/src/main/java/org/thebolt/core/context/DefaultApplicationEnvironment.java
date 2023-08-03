/**
 * 
 */
package org.thebolt.core.context;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is the default application environment implementation.
 * 
 * @author Pradheep
 *
 */
public class DefaultApplicationEnvironment implements ApplicationEnvironment {

	private ConcurrentHashMap<String, Object> applicationBeanMap = new ConcurrentHashMap<String, Object>();

	private DefaultApplicationEnvironment() {
		loadProperties();
	}

	private static DefaultApplicationEnvironment applicationEnvironment = new DefaultApplicationEnvironment();

	public static DefaultApplicationEnvironment getInstance() {
		return applicationEnvironment;
	}

	public synchronized boolean loadBean(String beanName, String className, BeanType beanType) {
		if (applicationBeanMap.containsKey(beanName)) {
			switch (beanType) {
			case NEW_INSTANCE:
				try {
					Object bean = getObject(className);
					if (null != bean) {
						applicationBeanMap.put(beanName, bean);
					}
				} catch (Exception err) {
					
				}
				break;
			default:
				break;
			}
		}
		return false;
	}

	private Object getObject(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {

		}
		return null;
	}

	public Map<String, Object> getAllApplicationBeans() {
		return Collections.unmodifiableMap(applicationBeanMap);
	}

	public Object getBeanByName(String beanName) {
		if (null != beanName && !beanName.isEmpty()) {
			return applicationBeanMap.get(beanName);
		} else {
			throw new IllegalArgumentException("Bean name cannot be empty or null");
		}
	}

	public void loadProperties() {

	}

	public void removeBean(String beanName) {
		if (null != beanName && !beanName.isEmpty()) {
			applicationBeanMap.remove(beanName);
		} else {

		}
	}

	public List<String> discoverBeansOnStartup() {
		return null;
	}
}
