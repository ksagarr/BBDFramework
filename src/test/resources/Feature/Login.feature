Feature: Verify user able to login
  Scenario: Validate massgae after login
    Given User launch the url
    When Click on login link
    And Enter email "mayur126@xyz.com" and password "123456"
    And Click on login button
    And Validate title massage "Welcome to our store"
    And Click on myaacount link
    And User navigate to myaccount page
    Then validate firstname "mayur" and lastname "kumble"
    And  validate email "mayur126@xyz.com"