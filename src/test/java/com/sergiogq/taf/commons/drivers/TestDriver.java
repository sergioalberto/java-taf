package com.sergiogq.taf.commons.drivers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

/**
 * The driver base
 */
public interface TestDriver {

	static final int IMPLICT_TIME = 30;
	static final TimeUnit IMPLICT_TIME_UNIT = TimeUnit.SECONDS;
	
	public void get(String domine, String user, String pass);

	public void moveToElement(WebElement element);

	public void doubleClick(WebElement element);
	 
	public void clickAndHold(WebElement element);
	  
	public void dragAndDrop(WebElement source, WebElement target);

	public void waitToElementBeVisible(final WebElement... element);
	 
	public void waitToElementBeEnabled(final WebElement... element);
	 
	public void waitToElementBeSelected(final WebElement... element);
	 
	public String getBrowserVersion();
}
