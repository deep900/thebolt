/**
 * 
 */
package org.thebolt.core.scan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Pradheep
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AutoScanBeans {
	
	String[] packageNames = {};
}
