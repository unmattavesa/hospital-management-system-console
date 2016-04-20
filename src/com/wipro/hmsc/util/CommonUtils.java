package com.wipro.hmsc.util;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

/**
 * 
 * @author si255323
 *
 */
public class CommonUtils {

	public static void showBanner() {
		println("welcome\n\n");
	}

	public static void showApplicationEntryOptions() {
		println("[1] -> Administrator Login");
		println("[2] -> Doctor Login");
		println("[3] -> Patient Login / Registration");
		println("[4] -> Receptionist Login");
	}
	
	public static void showAdminOptions() {
		println("\n\n[1] -> Register a Doctor");
		println("[2] -> Delete Doctor Info");
		println("[3] -> Update Doctor Info");
		println("[4] -> List Registered Doctors");
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
