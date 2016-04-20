package com.wipro.hmsc.domain;

/**
 * 
 * @author si255323
 *
 */
public class Admin extends User {
	
	public Admin(String userid, String pwd, String name, int age) {
		super(userid, pwd, "admin", name, age);
	}


	
}
