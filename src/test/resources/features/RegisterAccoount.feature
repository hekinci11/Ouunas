@wp
Feature: Register Account

  Background:

    Given As a user I  succesfully launch the website
    And As a user I should click account button
    And As a user I should login with valid credentials
    And Verify that homepage is displayed
    And As a user I should hover over to Account menu and click it
    And Verify that customer page is displayed

  Scenario: Edit email address
    And As a user I could click edit button
    Then EmailBox should not be clickable
    Then Verfy that Not Editable message is displayed

  Scenario: Verify email address
    And Verify that the valid email address and the address shown must match.





