
Feature: Access all modules of the app

// Would not let me create snippet by makin dryRun True. I commented out the snippet I created by right clicking

  @US1
  Scenario Outline : Log in as a driver
    Given User is on the VyTrack home page
    When User enters "<Username>"
    And user enters password UserUser123
    And User clicks on Log In button
    Then User waits for loading bar
    And User should see the home page with Dashboard WebTitle
    And User "should" see all four modules on the main page
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


    Examples: valid credentials
      | Username |
      | user160  |
      | user165  |
