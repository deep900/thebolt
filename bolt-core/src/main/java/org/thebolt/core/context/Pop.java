package org.thebolt.core.context;

import org.thebolt.core.scan.BoltBean;

@BoltBean
public class Pop {
	
	public static int cnt = 0;
	
	public Pop(){
		cnt++;
	}
	
	public String sayHello(){
		return "Hello";
	}
	
	public int getCnt(){
		return cnt;
	}
}
