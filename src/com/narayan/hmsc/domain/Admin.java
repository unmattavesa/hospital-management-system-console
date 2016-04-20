package com.narayan.hmsc.domain;

/**
 * 
 * @author unmattavesa
 *
 */
public class Admin extends User {
	
	public Admin(String userid, String pwd, String name, int age) {
		super(userid, pwd, "admin", name, age);
	}


	
}
