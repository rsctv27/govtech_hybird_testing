@test @test-web
Feature: user create order

  @scenario-web-1
  Scenario: user create order with filter sort price from highest price on search product page
    Given user logged in with email "standard_user" and password "secret_sauce"
    When user navigate to search product page
    And user set filter "sort price descending" on search product page
    And user verify product price from highest price on search product page
    And user click product page with index "0"
    And user verify product page from search product page
    And user click add to cart button
    And user navigate to cart page
    And user verify product cart page from product page
    And user navigate to checkout page
    And User fill data on checkout page:
      | First Name  | Last Name | Postal Code |
      | Rico | Citawan | 11460 |
    And user click continue button on checkout page
    And user verify product checkout page from cart page
    And user click finish button after checkout page
    And user should see order successfully
