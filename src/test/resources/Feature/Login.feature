@login
Feature: Login
  In order to maintain the health records
  As a admin
  I want to access the openemr portal
  
  Background:
	Given I have 'ch' browser with openemr application

	@high @invalid
  Scenario: Invalid Credential
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select the language as 'English (Indian)'
    And I click on login
    Then I should get the message as 'Invalid username or password123'

	@valid
  Scenario Outline: Valid Credential
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select the language as '<language>'
    And I click on login
    Then I should get access to the portal with title as 'OpenEMR'

    Examples: 
      | username  | password  | language         |
      | admin     | pass      | English (Indian) |
      | physician | physician | English (Indian) |

      
      