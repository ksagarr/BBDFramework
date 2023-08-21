Feature: user purchesed product successfully

  Scenario: user purchesed backpack
    Given user is on home page
    When user entered username "standard_user" and password "secret_sauce"
    And user clicked on login button
    Given user selected the product "Sauce Labs Backpack"
    When user navigated to cart page
    And user clicked on checkout page and navogated to checkout page
    And validate the added product "Sauce Labs Backpack"
    And user entered firstname "abcd" lastname "1234" and Zip code "123456"
    And user clicked on continue page
    Then user navigated to payment page
    And validate the final price of product "$32.39"
    And user clicked on finish button
    And validate with completed message "THANK YOU FOR YOUR ORDER"