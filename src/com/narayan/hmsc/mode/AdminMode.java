package com.narayan.hmsc.mode;

import static com.narayan.hmsc.db.DataBase.*;
import static com.narayan.hmsc.util.CommonUtils.learnOptionFromUser;
import static com.narayan.hmsc.util.CommonUtils.print;
import static com.narayan.hmsc.util.CommonUtils.println;
import static com.narayan.hmsc.util.CommonUtils.scanner;
import static com.narayan.hmsc.util.CommonUtils.showAdminOptions;

import java.util.Scanner;

import com.narayan.hmsc.domain.Doctor;
import com.narayan.hmsc.domain.User;

/**
 * 
 * @author unmattavesa
 * 
 */
public class AdminMode extends AbstractMode {

	@Override
	public void operate() {

		if (login()) {
			showAdminOptions();
			int option = learnOptionFromUser();
			println("----------------------------------------\n");
			switch (option) {
			case 1:
				registerDoctor();
				break;
			case 2:
				deleteDoctor();
				break;
			case 3:
				listRegisteredDoctors();
				break;
			case 7:
				logout();
				break;
			default:
				print("\nPlease Choose a valid option : ");
				operate();
			}

		}

	}

	private void listRegisteredDoctors() {
		boolean first = true, doctorsExist = false;
		for (User u : users) {
			if ("doctor".equalsIgnoreCase(u.getType())) {
				doctorsExist = true;
				Doctor d = (Doctor) u;
				if (first) {
					println("REGISTERED DOCTORS :: ");
					println("\t\t-----------------------------------------------------------------------------------------------------------------");
					println("\t	|	DOCTOR ID		|	DOCTOR NAME		|	SPECIALIZATION	|	EXPERIENCE	|");
					println("\t\t-----------------------------------------------------------------------------------------------------------------");
					first = false;
				}
				String id = d.getUserid().length() < 10 ? d.getUserid() + "\t"
						: d.getUserid();
				String name = d.getName().length() < 16 ? d.getName() + "\t"
						: d.getName();
				println("\t	|	" + id + "		|	" + name + "	|	"
						+ d.getSpecialization() + "	|	" + d.getExperience()
						+ "		|");
				println("\t\t-----------------------------------------------------------------------------------------------------------------");
			}
		}

		if (!doctorsExist) {
			println("No Registered Doctors Available!!!");
		}
		operate();
	}

	private void deleteDoctor() {
		Scanner scan = scanner();
		print("Enter the doctor Id to delete : ");
		String docId = scan.next();
		User u = find(docId);
		if (u != null && "doctor".equalsIgnoreCase(u.getType())) {
			println("Are you sure you want to delete " + u.getUserid() + "( "
					+ u.getName() + " ) : [y/n] ? ");
			String choice = scan.next();
			if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice)) {
				if (delete(docId)) {
					println("Doctor deleted successfully");
				} else {
					println("Failed to delete doctor. Please input a valid doctor id..");
				}
			}
		}
		operate();
	}

	private void registerDoctor() {
		Scanner scan = scanner();
		println("-----------------------------------------");
		println("********** ENTER DOCTOR DETAILS *********");
		println("-----------------------------------------");
		println("-------------------------------------------------------------------");
		print("|  First name : 		| 		");
		String firstName = scan.nextLine();
		println("-------------------------------------------------------------------");
		print("|  Last name  : 		| 		");
		String lastName = scan.nextLine();
		println("-------------------------------------------------------------------");
		print("|  Specialization : 		| 		");
		String specialization = scan.nextLine();
		println("-------------------------------------------------------------------");
		print("|  Experience (int) : 		| 		");
		int experience = scan.nextInt();
		println("-------------------------------------------------------------------");
		print("|  User Id : 			| 		");
		String userid = scan.next();
		println("-------------------------------------------------------------------");
		print("|  Age (int) :	 		| 		");
		int age = scan.nextInt();
		println("-------------------------------------------------------------------\n");

		Doctor doctor = new Doctor(userid, userid, firstName + " " + lastName, age);
		doctor.setSpecialization(specialization);
		doctor.setExperience(experience);

		save(doctor);

		if (exists(doctor)) {
			println("Doctor registration done successfully");
		}

		operate();

	}

}
