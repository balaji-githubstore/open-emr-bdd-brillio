package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.brillio.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By languageLocator = By.xpath("//select[@name='languageChoice']");
	private By loginLocator = By.cssSelector("#login-button");
	private By ackLicCertLocator = By.partialLinkText("Acknowledgments");
	private By errorLocator = By.xpath("//div[contains(text(),'Invalid')]");

	//private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
	}

	public void enterUsername(String username) {
		enterTextUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		enterTextUsingLocator(passwordLocator, password);
	}

	public void selectLanguageByText(String text) {
		selectDropdownUsingText(languageLocator, text);
	}

	public void clickOnLogin() {
		clickUsingLocator(loginLocator);
	}

	public void clickOnAcknowledgmentsLicensingAndCertification() {
		clickUsingLocator(ackLicCertLocator);
	}

	public String getInvalidErrorMessage() {
		return getTextUsingLocator(errorLocator);
	}
}
