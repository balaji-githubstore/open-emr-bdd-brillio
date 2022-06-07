package com.brillio.stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brillio.base.AutomationHooks;
import com.brillio.pages.LoginPage;
import com.brillio.pages.MainPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps  {

	private AutomationHooks hooks;
	private LoginPage login;
	private MainPage main;
	
	
	public LoginSteps(AutomationHooks hooks)
	{
		this.hooks=hooks;
		//System.out.println(hooks.count);
		
		//hooks.count=hooks.count+10;
		
		//System.out.println(hooks.count);
	}
	

	@Given("I have browser with openemr application")
	public void i_have_browser_with_openemr_application() {
		
		hooks.launchBrowser("ch");
		initPageObject();
	}
	
	@Given("I have {string} browser with openemr application")
	public void i_have_browser_with_openemr(String browser) {
		
		hooks.launchBrowser(browser);
		initPageObject();
	}

	public void initPageObject() {
		login = new LoginPage(hooks.driver);
		main = new MainPage(hooks.driver);
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		login.enterUsername(username);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		login.enterPassword(password);
	}

	@When("I select the language as {string}")
	public void i_select_the_language_as(String language) {
		login.selectLanguageByText(language);
	}

	@When("I click on login")
	public void i_click_on_login() {
		login.clickOnLogin();
	}

	@Then("I should get access to the portal with title as {string}")
	public void i_should_get_access_to_the_portal_with_title_as(String expectedTitle) {

		main.waitForPresenceOfPatientMenu();
		Assert.assertEquals(expectedTitle, main.getMainPageTitle());
	}

	@Then("I should get the message as {string}")
	public void i_should_get_the_message_as(String expectedError) {
		String actualError = login.getInvalidErrorMessage();
		Assert.assertTrue("Assertion on invalid error message", actualError.contains(expectedError)); // expect true
	}
}
