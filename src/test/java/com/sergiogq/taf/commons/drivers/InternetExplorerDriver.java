package com.sergiogq.taf.commons.drivers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;

import com.sergiogq.taf.commons.Constants;

/**
 * The Internet Explorer driver object
 */
public class InternetExplorerDriver extends org.openqa.selenium.ie.InternetExplorerDriver implements  TestDriver {

	public InternetExplorerDriver(){
		super();
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public InternetExplorerDriver(org.openqa.selenium.Capabilities capabilities) {
		  manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public InternetExplorerDriver(int port) {
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public InternetExplorerDriver(InternetExplorerDriverService service) {
		super(service);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	private static void loadExe(){
		//System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", Constants.INTERNET_EXPLORER_DRIVER);
	}

	public static InternetExplorerDriver createInstance() {
		loadExe();
		return new InternetExplorerDriver();
	}

	public static InternetExplorerDriver createInstance(org.openqa.selenium.Capabilities capabilities) {
		  loadExe();
		  return  new InternetExplorerDriver(capabilities);
	}

	public static InternetExplorerDriver createInstance(int port) {
		loadExe();
		return new InternetExplorerDriver(port);
	}

	public static InternetExplorerDriver createInstance(InternetExplorerDriverService service) {
	  loadExe();
	  return  new InternetExplorerDriver(service);
	}

	public void quit(){
		 super.quit();
    }

	public void get(String domine, String user, String pass){
		 get("https://"+user+":"+pass+"@"+domine);       
    }

	public void moveToElement(WebElement element){
		Actions builder = new Actions(this); 
		builder.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element){
		Actions builder = new Actions(this); 
		builder.doubleClick(element).build().perform();
	}

	public void clickAndHold(WebElement element){
		 Actions builder = new Actions(this); 
		 builder.clickAndHold(element).build().perform();
	 }

	 public void dragAndDrop(WebElement source, WebElement target){
		 Actions builder = new Actions(this); 
		 builder.dragAndDrop(source, target).build().perform();
	 }

	 public void waitToElementBeVisible(final WebElement... element){}

	 public void waitToElementBeEnabled(final WebElement... element){}

	 public void waitToElementBeSelected(final WebElement... element){}

	 public String getBrowserVersion(){
		 return this.getCapabilities().getVersion();
	 }	 
}
