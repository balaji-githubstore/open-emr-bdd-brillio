Feature: Login
  In order to maintain the health records
  As a admin
  I want to access the openemr portal

  Scenario: Valid Credential
    Given I have browser with openemr application
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select the language as 'English (Indian)'
    And I click on login
    Then I should get access to the portal with title as 'OpenEMR'

  Scenario: Invalid Credential
    Given I have browser with openemr application
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select the language as 'English (Indian)'
    And I click on login
    Then I should get the message as 'Invalid username or password'
