package com.narayan.hmsc.main;

import static com.narayan.hmsc.util.CommonUtils.learnOptionFromUser;
import static com.narayan.hmsc.util.CommonUtils.showApplicationEntryOptions;
import static com.narayan.hmsc.util.CommonUtils.showBanner;

import com.narayan.hmsc.mode.AdminMode;

/**
 * 
 * @author unmattavesa
 *
 */
public class HMSApp {

	public static void main(String[] args) {
		showBanner();

		HMSApp hmsApp = new HMSApp();
		hmsApp.manage();
				
	}

	private void manage() {
		showApplicationEntryOptions();
		int mode = learnOptionFromUser();
		
		switch(mode) {
			case 1  : startAdminMode(); break;
			case 2  : System.out.println("2"); break;
			case 3  : System.out.println("3"); break;
			case 4  : System.out.println("4"); break;
			default : System.out.println("default"); break;	
		}
	}

	private void startAdminMode() {
		AdminMode adminMode = new AdminMode();
		adminMode.operate();
	}

	
}
