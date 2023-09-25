Feature: feature to test login functionality

  Scenario Outline: Validate username and password
    Given browser is open
    When enters <username> and <password>
    And click on login button
    Then logout successfully
    
    Examples: 
    | username | password |
    | standard_user | secret_sauce |
    | locked_out_user | secret_sauce |
    | problem_user | secret_sauce |
    | performance_glitch_user | secret_sauce |
