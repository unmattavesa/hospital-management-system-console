package com.wipro.hmsc.mode;

import static com.wipro.hmsc.util.CommonUtils.learnOptionFromUser;
import static com.wipro.hmsc.util.CommonUtils.print;
import static com.wipro.hmsc.util.CommonUtils.println;
import static com.wipro.hmsc.util.CommonUtils.scanner;
import static com.wipro.hmsc.util.CommonUtils.showAdminOptions;

import java.util.Scanner;

import com.wipro.hmsc.db.DataBase;
import static com.wipro.hmsc.db.DataBase.*;
import com.wipro.hmsc.domain.Doctor;
import com.wipro.hmsc.domain.User;

/**
 * 
 * @author si255323
 *
 */
public class AdminMode extends AbstractMode {
	
	
	@Override
	public void start() {
		
		if(login()) {
			 showAdminOptions();
			 int option = learnOptionFromUser();
			 
			 switch(option) {
				case 1  : registerDoctor(); break;
				case 2  : deleteDoctor(); break;
				case 3  : updateDoctor(); break;
				case 4  : listRegisteredDoctors(); break;
				default : println("default"); start();	
			}
			 
		}
		
	}

	private void listRegisteredDoctors() {
		for(User u : users) {
			if("doctor".equalsIgnoreCase(u.getType())) {
				System.out.println(u.getName());
			}
		}
		start();
	}

	private void updateDoctor() {
		
		
	}

	private void deleteDoctor() {
		// TODO Auto-generated method stub
		
	}

	private void registerDoctor() {
		Scanner scan = scanner();
		println("\n\n-----------------------------------------");
		println("********** ENTER DOCTOR DETAILS *********");
		println("-----------------------------------------");
		println("-----------------------------------------------------------");
		print("|  First name : 		| 		");
		String firstName = scan.nextLine();
		println("-----------------------------------------------------------");
		print("|  Last name  : 		| 		");
		String lastName = scan.nextLine();
		println("-----------------------------------------------------------");
		print("|  Specialization : 		| 		");
		String specialization = scan.nextLine();
		println("-----------------------------------------------------------");
		print("|  Experience (int) : 		| 		");
		int experience = scan.nextInt();
		println("-----------------------------------------------------------");
		print("|  User Id : 			| 		");
		String userid = scan.next();
		println("-----------------------------------------------------------");
		print("|  Age (int) :	 		| 		");
		int age = scan.nextInt();
		println("-----------------------------------------------------------\n");
		
		Doctor doc = new Doctor(userid, userid, firstName +" " + lastName, age);
		doc.setSpecialization(specialization);
		doc.setExperience(experience);
		
		DataBase.insertUser(doc);
		
		if(DataBase.exists(doc)) {
			System.out.println("Doctor registration done successfully");
		}

		start();
		
	}

	@Override
	public void stop() {
		
	}

	
}
