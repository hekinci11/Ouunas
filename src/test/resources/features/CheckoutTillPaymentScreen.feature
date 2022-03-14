@wp
Feature: Checkout till payment screen

  Background:
    Given As a user I  succesfully launch the website
    And As a user I should click account button
    And As a user I should login with valid credentials
    And Verify that homepage is displayed

  Scenario: Add items
    And As a user I could select MEN menu
    And As a user I could select TSHIRTS
    And As a user I could select "QASIMI TSHIRT"
    And As a user I could select size and colour and add it to bag
    And Verify that all selected items are in the bag
    And As a user I could click secure check-out button
    And As a User I could fill the address information field
    Then Verify that payment page is launched succesfully





