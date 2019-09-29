package com.sergiogq.taf.commons;

import org.apache.log4j.Logger;
import org.testng.Reporter;

/*
 * Class to allow the Logger feature on the automation framework
 */
public class Log {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName){
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		System.out.println("****************************************************************************************");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("****************************************************************************************");
	}

	//This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName){
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXX             \"+\"-E---N---D-\"+\"             XXXXXXXXXXXXXXXXXXXXXX");
	}

	// Need to create these methods, so that they can be called  
	public static void info(String message) {
		Reporter.log(message);
		Log.info(message);
		System.out.println(message);
	}

	public static void warn(String message) {
		Reporter.log(message);
		Log.warn(message);
		System.out.println(message);
	}

	public static void error(String message) {
		Reporter.log(message);
		Log.error(message);
		System.out.println(message);
	}

	public static void fatal(String message) {
		Reporter.log(message);
		Log.fatal(message);
		System.out.println(message);
	}

	public static void debug(String message) {
		Reporter.log(message);
		Log.debug(message);
		System.out.println(message);
	}

}
