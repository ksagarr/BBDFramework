Feature: Verify that user is able to login succesfully

  Scenario: User login with valid credential
    Given user is on home page
    When user entered username "standard_user" and password "secret_sauce"
    And user clicked on login button
    Then user navigated to homepage
    And validate the message "Products"