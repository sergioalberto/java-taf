package com.sergiogq.taf.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sergiogq.taf.TestCaseSetting;
import com.sergiogq.taf.pages.HomePage;

/**
 * This test case checks if a user with valid credentials can sign in successfully.
 */
public class TC1_VerifyHomePage extends TestCaseSetting {

	private HomePage homePage;

	@BeforeMethod
	public void beforeTest() {
		homePage = PageFactory.initElements(this.getDriver(), HomePage.class);
	}

	@Test
	public void isHomePage() {
		// Verify if it was logged successfully
		boolean wasLogged = homePage.isHomePage(this.getDriver());
		Assert.assertTrue(wasLogged, "The user couldn't be logged.");
	}

}
