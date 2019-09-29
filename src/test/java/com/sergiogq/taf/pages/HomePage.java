package com.sergiogq.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sergiogq.taf.commons.Constants;

/**
 * The Symphony home page
 */
public class HomePage {

	/**
	 * Selectors section
	 */

	@FindBy(css = ".site-branding .site-title")
	private WebElement title;

	/**
	 * Where the functions live, to interact with the HTML page
	 */

	/*
	 * Verify if the home page is shown
	 */
	public boolean isHomePage(WebDriver driver) {
		try {
			(new WebDriverWait(driver, Constants.TIMEOUT)).until(ExpectedConditions.visibilityOf(title));
		} catch (Exception e) {
			return false;
		}
		return title.isDisplayed();
	}

}
