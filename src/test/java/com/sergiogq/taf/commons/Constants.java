package com.sergiogq.taf.commons;

import org.openqa.selenium.remote.BrowserType;

/**
 * Constants of the automation framework
 */
public class Constants {

	public static final int TIMEOUT = 5;
	public static final int MID_TIMEOUT = TIMEOUT * 2;
	public static final int LONG_TIMEOUT = TIMEOUT * 4;

	public static final String RESOURCES = "src/main/resources";
	public static final String BROWSER = BrowserType.CHROME;
	public static final String CHROME_DRIVER = "src/main/resources/chromedriver";
	public static final String INTERNET_EXPLORER_DRIVER = "src/main/resources/IEDriverServer.exe";

	public static final String SCREENSHOTS = "screenshots";

}
