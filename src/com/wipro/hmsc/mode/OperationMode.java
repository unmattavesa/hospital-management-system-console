package com.wipro.hmsc.mode;

/**
 * 
 * @author si255323
 *
 */
public interface OperationMode {

	boolean login();
	
	void start();

	void stop();
	
	boolean logout();

}
