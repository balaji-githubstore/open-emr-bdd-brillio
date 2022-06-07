package com.brillio.base;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationHooks {
	public WebDriver driver;
	//public int count=1;
	
	public void launchBrowser(String browserName)
	{
		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demo.openemr.io/b/openemr");
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		System.out.println(scenario.getName());
		System.out.println(scenario.isFailed());
		
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] byteArr=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(byteArr, "image/png", scenario.getName());
		}
		
		
		driver.quit();
	}
	

}
