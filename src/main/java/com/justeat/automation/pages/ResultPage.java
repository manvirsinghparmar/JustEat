package com.justeat.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.justeat.automation.base.TestBase;

public class ResultPage extends TestBase {

	@FindBy(css = "div.c-resultHeader-titleContainer")
	WebElement searchResult;

	public ResultPage() {
		PageFactory.initElements(wd, this);
	}

	public String getTotalResturantFoundText() {
		return searchResult.getText();
	}

}
