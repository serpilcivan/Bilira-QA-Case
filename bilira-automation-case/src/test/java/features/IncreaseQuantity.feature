@IncreaseQuantity
Feature: Increase product quantity in cart

  Scenario: User increases the product quantity in cart
    Given I am a user of amazoncom
    When user searches for "Macbook Pro"
    And click the first product
    And user adds the product to cart
    And the product should be in the cart
    And user increases the product quantity
    Then the product quantity should be increased
