/**
 * 
 */
package org.thebolt.core.scan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.thebolt.core.context.BeanType;

/**
 * @author Pradheep
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BoltBean {

	String beanScope = BeanType.SINGLETON.name();
}
