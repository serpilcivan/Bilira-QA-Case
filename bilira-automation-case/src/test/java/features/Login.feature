@Login
Feature: User tries to login to amazon.com with valid and invalid credentials

  Scenario: Login with valid credentials
    Given I am a user of amazoncom
    When user enters valid email "serpilcivan17@gmail.com"
    And user enters valid password "Simurg17*"
    Then user should be logged in successfully


