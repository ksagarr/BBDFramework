Feature: Verify that user is able to register successfully

  Scenario: User registration with valid credential
    Given user is on homepage
    When user click on register link
    And user select gender
    And validate gander is "Male"
    And user enter firstname "mayur" and lastname "kumble"
    And user select date of birth day "15" and Month "May" and Year "1994"
    And user enter email "mayur126@xyz.com"
    And user enter password "12345" and comformpassword "123456"
    And User click on register button
    Then user navigate to register resutt page
    And validate the massage "Your registration completed"
    And user click on continue button
    And user navigate to homepage
    And validate homepage the massage "Welcome to our store"