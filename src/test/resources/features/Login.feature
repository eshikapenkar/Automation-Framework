Feature: Login functionality

  Scenario: Valid login
    Given user is on login page
    When user enters username "standard_user" and password "secret_sauce"
    Then user should be logged in

  Scenario: Invalid login
    Given user is on login page
    When user enters username "wrong" and password "wrong"
    Then error message should be displayed