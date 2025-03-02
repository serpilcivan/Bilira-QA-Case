@EmptyCart
Feature: Empty cart

  Scenario: User empties the cart
    Given I am a user of amazoncom
    When user searches for "Macbook Pro"
    And click the first product
    And user adds the product to cart
    And the product should be in the cart
    And user empties the cart
    Then the cart should be empty
