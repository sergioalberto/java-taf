package com.sergiogq.taf.commons.drivers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sergiogq.taf.commons.Constants;
import com.sergiogq.taf.data.Data;

/**
 * The driver object of the framework
 */
public class Driver {

	public WebDriver driver;
	public static Driver instance;

	public Driver() {}

	public static Driver getInstance(String browserType) throws SecurityException, IOException {
		if(instance == null) {
			instance = new Driver(browserType);
		}
		return instance;
	}

	public Driver(String browserType) throws SecurityException, IOException{

		if (Data.isWillRunOnDocker()) {
			DesiredCapabilities dc = DesiredCapabilities.chrome();

	        if (browserType.contains(BrowserType.FIREFOX))
	            dc = DesiredCapabilities.firefox();

	        String host = System.getProperty("seleniumHubHost");

	        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), dc);
		} else {
			if (browserType.contains(BrowserType.CHROME)) {
				driver = ChromeDriver.createInstance();
			} else if (browserType.contains(BrowserType.FIREFOX)) {
				driver = new FireFoxDriver();
			} else if (browserType.contains(BrowserType.IE) || browserType.contains(BrowserType.EDGE)) {
				driver = InternetExplorerDriver.createInstance();
			}
			else {
				driver = ChromeDriver.createInstance();
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
	}

	public WebDriver obtenerDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void closeDriver(){
		driver.quit();
		instance = null;
	}

}
