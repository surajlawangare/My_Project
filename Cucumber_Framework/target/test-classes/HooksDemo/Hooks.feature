Feature: Check ogin functionality

  @smoke
  Scenario: 
    Given browser is open
    When enters username and password
    And click on login button
    Then logout successfully

  Scenario: 
    Given browser is open
    When enters username and password
    And click on login button
    Then logout successfully
