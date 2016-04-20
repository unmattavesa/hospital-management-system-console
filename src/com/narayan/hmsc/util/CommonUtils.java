package com.narayan.hmsc.util;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/**
 * 
 * @author unmattavesa
 *
 */
public class CommonUtils {

	public static void showBanner() {
		println("********************************************************************");
		println("***************** WIPRO SUPER SPECIALITY HOSPITAL ******************");
		println("********************************************************************\n");
	}

	public static void showApplicationEntryOptions() {
		println("\n[1] -> Administrator Login");
		println("[2] -> Doctor Login");
		println("[3] -> Patient Login / Registration");
		println("[4] -> Receptionist Login");
		println("----------------------------------------");
	}
	
	public static void showAdminOptions() {
		println("----------------------------------------\n");
		println("**** ADMIN OPERATIONS ****");
		println("\n[1] -> Register a Doctor");
		println("[2] -> Delete Doctor Info");
		println("[3] -> List Registered Doctors");
		println("[4] -> Add Receptionist");
		println("[5] -> Delete Receptionist");
		println("[6] -> List Receptionists");
		println("[7] -> Logout");
		println("----------------------------------------");
	}

	public static Scanner scanner() {
		return new Scanner(in);
	}
	
	public static void println(String content) {
		out.println(content);
	}
	public static void print(String content) {
		out.print(content);
	}
	
	public static int learnOptionFromUser() {
		out.print("Please enter your choice : ");
		return scanner().nextInt();
	}
}
