@patient
Feature: Patient
  In order to maintain patient records 
  As a admin
  I want to add,edit,delete the patient records

  @addpatient @high
  Scenario Outline: Add Valid Patient Record1
    Given I have browser with openemr application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select the language as '<language>'
    And I click on login
    And I click on patient menu
    And I click on new-search menu
    And I fill the form
      | firstname   | lastname   | dob           | gender   |
      | <firstname> | <lastname> | <dateofbirth> | <gender> |
    And I click on create new patient
    And I click on confirm create new patient
    And I store the alert text and handle it
    And I close happy birthday popup if avaiable
    Then I should have the alert text contains '<expectedalert>'
    And I should get the added patient name as '<expectpatientname>'
#		  And I should get the added patient name as 'Medical Record Dashboard - <firstname> <lastname>'
    Examples: 
      | username  | password  | language         | firstname | lastname | dateofbirth | gender | expectedalert | expectpatientname                   |
      | admin     | pass      | English (Indian) | John      | Ken      | 2022-06-07  | Male   | Tobacco       | Medical Record Dashboard - John Ken |
      | physician | physician | English (Indian) | Bala      | Dina     | 2022-06-06  | Male   | Tobacco       | Medical Record Dashboard - Bala Dina |
