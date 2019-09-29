package com.sergiogq.taf.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * All the common functions that may be used by the project (Bot Style - Design Pattern)
 */
public class ActionBot {

	private static JavascriptExecutor jse;

	/**
	 * Looking for some element in the page object
	 */
	public static boolean isElementPresent(WebDriver driver, By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Get the locator from a WebElement
	 * @param element
	 * @return
	 */
	public static String[] getLocatorFromWebElement(WebElement element) {
	    return element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "").split(":");
	}

	/**
	 * Move the scroll to the element target
	 * @param driver
	 * @param element
	 */
	public static void scroll(WebDriver driver, WebElement element) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element); 
	}

}
