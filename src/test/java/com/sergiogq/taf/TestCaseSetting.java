package com.sergiogq.taf;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sergiogq.taf.commons.Constants;
import com.sergiogq.taf.commons.Log;
import com.sergiogq.taf.data.Data;

/**
 * General object to setting all the information that the test cases need
 */
public class TestCaseSetting {

	protected Browser browser;

	@Parameters({ "siteUrl", "userEmail", "userPassword", "browser", "willRunOnDocker" })
	@BeforeSuite
	public void beforeSuite(String siteUrl, String userEmail, String userPassword, String browser,
			boolean willRunOnDocker) {

		// Provide Log4j configuration settings
		DOMConfigurator.configure(Constants.RESOURCES+"/log4j.xml");

		Log.info("Starting the automation Suite");

		Data.setSiteUrl(siteUrl.toString());
		Data.setUserEmail(userEmail.toString());
		Data.setUserPassword(userPassword.toString());
		Data.setBrowser(browser.toString());
		Data.setWillRunOnDocker(willRunOnDocker);

		if (Data.getBrowser().contains(BrowserType.FIREFOX)) {
			Assert.assertTrue(false, "The Symphony platform does not support Firefox yet.");
		} else if (Data.getBrowser().contains(BrowserType.IE) || Data.getBrowser().contains(BrowserType.EDGE)) {
			Assert.assertTrue(false, "The Symphony platform does not support Microsoft Edge/IE yet.");
		}
	}

	@BeforeMethod
	public void beforeMethod() throws SecurityException, IOException {
		browser = new Browser(Data.getBrowser());
		browser.openSite();
		Log.info("Browser Opened");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		// this.closeBrowser();
	}

	@AfterMethod
	public void onTestFailure(ITestResult testResult){
		if(testResult.getStatus() == ITestResult.FAILURE){
          this.takeScreenshot();
          this.closeBrowser();
        }
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		this.closeBrowser();
	}

	/*
	 * Get the browser object
	 */
	public Browser browser(){
		return browser;
	}

	/*
	 * Close the browser driver
	 */
	public void closeBrowser(){
		browser.driver.closeDriver();
		Log.info("Browser closed");
	}

	/*
	 * Get the Selenium driver
	 */
	public WebDriver getDriver() {
		return browser.driver.obtenerDriver();
	}

	/**
	 * Take a screenshot and save the image on the local project
	 */
	public String takeScreenshot(){

		File directory = new File(Constants.SCREENSHOTS);
		if (! directory.exists()){
		    directory.mkdir();
		}

		try {
			String format = "png";
			UUID idOne = UUID.randomUUID();

			String fileName = idOne.toString().replaceAll("-", "")+"."+format;
			File src = ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(Constants.SCREENSHOTS + File.separator + fileName));
			return fileName;
		}
		catch (IOException e){
			System.out.println("Error while taking the screenshot.");
			return "";
		}
	}

}
