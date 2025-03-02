@SearchProduct
Feature: Search for a product on Amazon

  Scenario: User searches for a product
    Given I am a user of amazoncom
    When user searches for "MacBook Pro"
    Then search results should be displayed
