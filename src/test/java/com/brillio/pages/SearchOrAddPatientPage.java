package com.brillio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brillio.base.WebDriverKeywords;

public class SearchOrAddPatientPage extends WebDriverKeywords{
	private By patFrameLocator = By.xpath("//iframe[@name='pat']");
	private By firstnameLocator = By.id("form_fname");

	private WebDriver driver;

	public SearchOrAddPatientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectPatFrame() {
		driver.switchTo().frame(driver.findElement(patFrameLocator));
	}

	public void enterFirstName(String firstname) {
		driver.findElement(firstnameLocator).sendKeys(firstname);
	}

	public String getAlertTextAndHandleIt() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());

		String text = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		return text;
	}

}
