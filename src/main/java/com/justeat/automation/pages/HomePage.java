package com.justeat.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.justeat.automation.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = "button[data-test-id=accept-all-cookies-button]")
	WebElement acceptCookies;

	@FindBy(css = "input[name=postcode]")
	WebElement searchField;

	@FindBy(css = "button[type='submit']")
	WebElement searchButton;

	@FindBy(css = "button[data-test-id=searchBtnClear]")
	WebElement clearButton;

	@FindBy(id = "errorMessage")
	WebElement invalidPostCodeErrorMessage;

	@FindBy(id = "errorMessage")
	WebElement emptySearchFieldErrorMessage;

	public HomePage() {
		PageFactory.initElements(wd, this);
	}

	public void clickAcceptCookies() {
		acceptCookies.click();
	}

	public void enterText(String postalCode) {
		searchField.sendKeys(postalCode);
	}

	public void clickCrossButton() {
		clearButton.click();
	}

	public String getInvalidPostalCodeErrorMessage() {
		return invalidPostCodeErrorMessage.getText();
	}

	public String getEmptySearchFieldErrorMessage() {
		return emptySearchFieldErrorMessage.getText();
	}

	public ResultPage clickSearchButton() {
		searchButton.submit();
		return new ResultPage();
	}

	public void selectFromAutoSuggestion() {
		Actions act = new Actions(wd);
		act.sendKeys(Keys.DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

}
