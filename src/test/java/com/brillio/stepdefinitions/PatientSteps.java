package com.brillio.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.brillio.base.AutomationHooks;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSteps {

	@When("I click on patient menu")
	public void i_click_on_patient_menu() {
		AutomationHooks.driver.findElement(By.xpath("//div[normalize-space()='Patient']")).click();
	}

	@When("I click on new-search menu")
	public void i_click_on_new_search_menu() {
		AutomationHooks.driver.findElement(By.xpath("//div[normalize-space()='New/Search']")).click();
	}

	@When("I fill the form")
	public void i_fill_the_form(DataTable dataTable) {
		
		System.out.println(dataTable);
		List<Map<String,String>> lists= dataTable.asMaps();
		
		String firstname=lists.get(0).get("firstname");
		String lastname=lists.get(0).get("lastname");
		String dob=lists.get(0).get("dob");
		String gender=lists.get(0).get("gender");
		
		AutomationHooks.driver.switchTo().frame(AutomationHooks.driver.findElement(By.xpath("//iframe[@name='pat']")));
		AutomationHooks.driver.findElement(By.id("form_fname")).sendKeys(firstname);
		
	}

	@When("I click on create new patient")
	public void i_click_on_create_new_patient() {

	}

	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() {
	
	}

	@When("I store the alert text and handle it")
	public void i_store_the_alert_text_and_handle_it() {
		
	}

	@When("I close happy birthday popup if avaiable")
	public void i_close_happy_birthday_popup_if_avaiable() {
		
	}

	@Then("I should have the alert text contains {string}")
	public void i_should_have_the_alert_text_contains(String string) {
	
	}

	@Then("I should get the added patient name as {string}")
	public void i_should_get_the_added_patient_name_as(String string) {
		
	}

}
