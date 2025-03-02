@ProductSearchCart
Feature: Product search and adding to cart

  Scenario: Search for a product and add it to the cart
    Given I am a user of amazoncom
    When user searches for "MacBook Pro"
    And click the first product
    And user adds the product to cart
    Then the product should be in the cart
