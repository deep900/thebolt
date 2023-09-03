/**
 * 
 */
package org.thebolt.core.scan;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.thebolt.core.context.ApplicationEnvironment;
import org.thebolt.core.context.DefaultApplicationEnvironment;
import org.thebolt.log.impl.BoltLogger;

/**
 * @author Pradheep
 *
 */
public final class AutoBeanLoader {
	
	private ApplicationEnvironment applicationEnvironment = DefaultApplicationEnvironment.getInstance();
	
	public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
	    Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
	    return reflections.getSubTypesOf(Object.class)
	      .stream()
	      .collect(Collectors.toSet());
	}
	
	/**
	 * Scans all the beans annotated with @BoltBean automatically.
	 * @param rootPackageName
	 * @return
	 */
	public Map<Object,Object> scanBoltBeans(String rootPackageName) {		
		Set<Class> classObjs = findAllClassesUsingReflectionsLibrary(rootPackageName);
		getLogger().logMessage("Classes:" + classObjs,Level.INFO);
		Map<Object,Object> boltBeanMap = new HashMap<Object,Object>();
		classObjs.forEach(classObj -> {
			Class obj = (Class) classObj;
			Annotation annotation = obj.getAnnotation(BoltBean.class);
			System.out.println(annotation);
			if(null != annotation) {
				boltBeanMap.put(annotation, obj);
			}
		});
		return boltBeanMap;
	}

	private Class getClass(String className, String packageName) {
		try {
			return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private BoltLogger getLogger(){
		return (BoltLogger) this.applicationEnvironment.getBeanByName("logger");
	}
	
	private void loadBoltBeansInAppEnv(){
		getLogger().logMessage("Loading the bolt beans", Level.INFO);
	}
}
