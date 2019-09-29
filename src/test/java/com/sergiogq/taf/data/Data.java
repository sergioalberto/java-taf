package com.sergiogq.taf.data;

/**
 * Object to save all the data that the automation needs
 */
public class Data {
	
	private static String siteUrl;
	private static String userEmail;
	private static String userPassword;
	private static String browser;
	private static boolean willRunOnDocker;

	/**
	 * @return the siteUrl
	 */
	public static String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * @param siteUrl the siteUrl to set
	 */
	public static void setSiteUrl(String siteUrl) {
		Data.siteUrl = siteUrl;
	}

	/**
	 * @return the userEmail
	 */
	public static String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public static void setUserEmail(String userEmail) {
		Data.userEmail = userEmail;
	}

	/**
	 * @return the userPassword
	 */
	public static String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public static void setUserPassword(String userPassword) {
		Data.userPassword = userPassword;
	}

	/**
	 * @return the browser
	 */
	public static String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public static void setBrowser(String browser) {
		Data.browser = browser;
	}

	public static boolean isWillRunOnDocker() {
		return willRunOnDocker;
	}

	public static void setWillRunOnDocker(boolean willRunOnDocker) {
		Data.willRunOnDocker = willRunOnDocker;
	}

}
