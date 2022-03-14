@log
Feature: Facebook Login

  Scenario: login
    Given As a user I  succesfully launch the website
    And As a user I should click account button
    And As a user I could click Facebook button
    And As a user I should login with valid credentials in Facebook
    Then Verify that homepage is displayed