package com.sergiogq.taf.commons.drivers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.sergiogq.taf.commons.Constants;

/**
 * The Chrome driver object
 */
public class ChromeDriver extends org.openqa.selenium.chrome.ChromeDriver implements  TestDriver {

	public ChromeDriver(){
		super();
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public ChromeDriver(ChromeDriverService service){
		super(service);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public ChromeDriver(org.openqa.selenium.Capabilities capabilities){
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public ChromeDriver(ChromeOptions options){
		super(options);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	public ChromeDriver(ChromeDriverService service, ChromeOptions options){
		super(service, options);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	private static void loadExe(){
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
	}

	public static ChromeDriver createInstance(){
		loadExe();
		return new ChromeDriver();
	}

	public static ChromeDriver createInstance(ChromeDriverService service){
		loadExe();
		return new ChromeDriver(service);
	}

	public static ChromeDriver createInstance(org.openqa.selenium.Capabilities capabilities){
		loadExe();
		return new ChromeDriver(capabilities);
	}

	public static ChromeDriver createInstance(ChromeOptions options){
		loadExe();
		return new ChromeDriver(options);
	}

	public static ChromeDriver createInstance(ChromeDriverService service, ChromeOptions options){
		loadExe();
		return new ChromeDriver(service, options);
	}

	public void quit(){
		 super.quit();
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

	public String getBrowserVersion(){
		return this.getCapabilities().getVersion();
	}

	public void waitToElementBeVisible(WebElement... element) {
		// TODO Auto-generated method stub
	}

	public void waitToElementBeEnabled(WebElement... element) {
		// TODO Auto-generated method stub
	}

	public void waitToElementBeSelected(WebElement... element) {
		// TODO Auto-generated method stub
	}

	public void get(String domine, String user, String pass) {
		get("https://"+user+":"+pass+"@"+domine);
	}

}
