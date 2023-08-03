/**
 * 
 */
package org.thebolt.core.context;

import java.util.List;
import java.util.Map;

/**
 * This interface defines the functionalities of the ApplicationEnvironment.
 * 
 * This helps to maintain the dependency inversion.
 * 
 * @author Pradheep
 *
 */
public interface ApplicationEnvironment {

	/**
	 * Loads the bean and maintains the state of the object.
	 * 
	 * @param beanName
	 * @param classname
	 * @param beanType
	 * @return
	 */
	public boolean loadBean(String beanName, String classname, BeanType beanType);

	/**
	 * Returns the complete collection of the beans discovered / or loaded in
	 * the application.
	 * 
	 * @return
	 */
	public Map<String, Object> getAllApplicationBeans();
	
	/**
	 * Returns the bean instance by name.
	 * @param beanName
	 * @return
	 */
	public Object getBeanByName(String beanName);

	/**
	 * Loads the application properties for core module.
	 */
	public void loadProperties();

	/**
	 * Removes the bean instance by the name.
	 * @param beanName
	 */
	public void removeBean(String beanName);

	/**
	 * Discovers the bean definitions in the application automatically and loads
	 * in the environment.
	 * 
	 * @return
	 */
	public List<String> discoverBeansOnStartup();
}
