package com.brillio.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature/Login.feature"}
		,glue = {"com.brillio.stepdefinitions"}
		//,dryRun = true
		,monochrome = true
		//,publish = false
		,plugin = {"html:target/cucumber-report.html","json:target/cucumber-report.json"}
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
