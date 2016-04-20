package com.wipro.hmsc.mode;

import static com.wipro.hmsc.util.CommonUtils.println;
import static com.wipro.hmsc.util.CommonUtils.scanner;

import java.util.Scanner;

import com.wipro.hmsc.db.DataBase;
import com.wipro.hmsc.domain.User;

/***
 * 
 * @author si255323
 *
 */
public abstract class AbstractMode implements OperationMode {

	protected boolean loggedIn;
	
	@Override
	public boolean login() {
		if(!loggedIn) {
			Scanner scan = scanner();
			println("Enter username : ");
			String username = scan.next(); 
			println("Enter password : ");
			String password = scan.next();
			if(DataBase.exists(new User(username, password, "", "", 1))) {
				println("user valid");
				loggedIn = true;
			}else {
				println("user invalid");
				loggedIn = false;
			}	
		}
		return loggedIn;
	}

	@Override
	public boolean logout() {
		return loggedIn = false;
		
	}

}
