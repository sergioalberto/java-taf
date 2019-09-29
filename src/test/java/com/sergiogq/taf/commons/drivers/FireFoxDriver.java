package com.sergiogq.taf.commons.drivers;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

/**
 * The Firefox driver object
 */
public class FireFoxDriver extends org.openqa.selenium.firefox.FirefoxDriver implements TestDriver {

	public FireFoxDriver() throws SecurityException, IOException{		
		afterSetUp();
	}

	public FireFoxDriver(FirefoxProfile profile) throws SecurityException, IOException{
		afterSetUp();
	}

	private void afterSetUp() throws SecurityException, IOException{
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
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

	public boolean isElementPresent(By by){
	    return this.findElements(by).size() != 0;
	}

	public void waitToElementBeSelected(final WebElement... element){}

	public String getBrowserVersion(){
		return this.getCapabilities().getVersion();
	}

}
