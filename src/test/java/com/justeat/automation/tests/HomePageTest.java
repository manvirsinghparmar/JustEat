package com.justeat.automation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.justeat.automation.base.TestBase;
import com.justeat.automation.pages.HomePage;
import com.justeat.automation.pages.ResultPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	ResultPage resultPage;

	@BeforeMethod
	public void setUp() {
		intialisation();
		homePage = new HomePage();
		homePage.clickAcceptCookies();
	}

	@Test
	public void validateSearchFunctionalityWithValidPostalCode() {
		homePage.enterText("AR51 1AA");
		homePage.selectFromAutoSuggestion();
		resultPage = homePage.clickSearchButton();
		String totalRestList = resultPage.getTotalResturantFoundText();
		Assert.assertTrue(totalRestList.contains("open restaurants"));

	}
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
