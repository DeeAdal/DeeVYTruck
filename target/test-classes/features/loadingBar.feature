
Feature: User login to page

  // Verifying loading bar is hard?? How

  @loadingBar
  Scenario: Login
    Given url
    When User puts in userName
    And User puts in Password
    And User clicks on login Button
    Then User waits for loading bar
    And User on home page with Dashboard WebTitle
