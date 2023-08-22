Feature: Verify user able to order product successfully

  Scenario: Validate user order product successfully
    Given User launch the url
    When Click on login link
    And Enter email "mayur126@xyz.com" and password "123456"
    And Click on login button
    And User move to tab "Computers "
    And User click on "Notebooks "
    And User add notebook <notebook> in addcart "Lenovo Thinkpad X1 Carbon Laptop"Examples:
      | Asus N551JK-XO076H Laptop            |
      | HP Envy 6-1180ca 15.6-Inch Sleekbook |
      | Lenovo Thinkpad X1 Carbon Laptop     |
    And User click on shopcart
    And User click on terms and checkout button
    And User enter shiping address details like country "United States" and state "Alaska" and city "Lake Vita" and address "53181 Beryl Fort Apt. 514" and pin "415578" and phone "945454558"
    And User click on continue button
    And User select shiping method and click on continue
    And User select payment method and click on continue
    And User click on continue
    And User validate billing address name "mayur kumble" and email "Email: mayur126@xyz.com" and phone "Phone: 945454558" and city-state-zip "Lake Vita,Alaska,415578" and country "United States"
    And User validate shiping address name "mayur kumble" and email "Email: mayur126@xyz.com" and phone "Phone: 945454558" and city-state-zip "Lake Vita,Alaska,415578" and country "United States"
    And User valiadte products contains <products>
      | HP Envy 6-1180ca 15.6-Inch Sleekbook |
      | Asus N551JK-XO076H Laptop            |
      | Lenovo Thinkpad X1 Carbon Laptop     |
    And Validate total price "$4,320.00"
    Then User validate order massage "Your order has been successfully processed!"
    And User click on continue and navigate to home page

