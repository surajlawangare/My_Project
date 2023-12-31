Feature: Login functionality test

  Scenario: Check login with valid credentials
    Given user is on login page
    When user enters valid username and password
    And clicks on the login button
    Then user is navigated to homepage

  Scenario: Check login with invalid credentials
    Given user is on login page
    When user enters invalid username and password
    And clicks on the login button
    Then error message is displayed - invalid credentials
