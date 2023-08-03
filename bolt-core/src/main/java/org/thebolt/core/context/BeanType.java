package org.thebolt.core.context;

/**
 * This class specifies the type of Bean to be created by the ApplicationEnvironment.
 * 
 * @author Pradheep
 *
 */
public enum BeanType {
	SINGLETON,NEW_INSTANCE,SESSION,EVICTABLE;
}
