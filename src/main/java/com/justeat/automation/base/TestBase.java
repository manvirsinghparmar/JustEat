package com.justeat.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;

	public static void intialisation() {

		WebDriverManager.chromedriver().setup();

		wd = new ChromeDriver();

		wd.get("https://www.just-eat.co.uk/");

		wd.manage().deleteAllCookies();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void tearDown() {
		wd.quit();
	}

}
