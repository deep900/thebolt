/**
 * 
 */
package org.thebolt.core.context;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.thebolt.log.impl.BoltLogger;

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
		loadBean("logger", "org.thebolt.log.impl.BoltLogger", BeanType.SINGLETON);
	}

	private static DefaultApplicationEnvironment applicationEnvironment = new DefaultApplicationEnvironment();

	public static DefaultApplicationEnvironment getInstance() {
		return applicationEnvironment;
	}

	public synchronized boolean loadBean(String beanName, String className, BeanType beanType) {
		Object bean = null;
		switch (beanType) {
		case NEW_INSTANCE:
			bean = getObject(className);
			break;
		case SINGLETON:
			if (applicationBeanMap.contains(className)) {
				System.out.println("Bean already loaded.");
				return true;
			}
			bean = getInstance(className);
			if (null == bean) {
				bean = getObject(className);
			}
			break;
		default:
			break;
		}
		if (null != bean) {
			applicationBeanMap.put(beanName, bean);
			return true;
		}
		return false;
	}

	private Object getObject(String className) {
		try {
			Class classObj = Class.forName(className);
			try {
				Constructor cons = classObj.getConstructor(null);
				try {
					return cons.newInstance(null);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {					
					e.printStackTrace();
					return null;
				}
			} catch (NoSuchMethodException | SecurityException e) {			
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
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
		System.out.println("Loading the properties ");
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

	public Object getInstance(String className) {
		Class classObj;
		try {
			classObj = Class.forName(className);
			Method[] methods = classObj.getMethods();
			for (int y = 0; y < methods.length; y++) {
				Method obj = methods[y];
				System.out.println("Printing the method name :" + obj.getName());
				if (obj.getName().equalsIgnoreCase("getInstance")) {
					return obj.invoke(null, null);
				}
			}
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
