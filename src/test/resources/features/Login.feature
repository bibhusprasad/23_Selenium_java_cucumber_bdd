@login

Feature: WebDriver University - Login Page

  Background:
    Given I access the WebDriver University login page
    When I enter valid username webdriver

  Scenario: Validate Successful login - Correct credentials
    And I enter valid password webdriver123
    And I click on login button
    Then I should be presented with a validation success alert message

  Scenario: Validate failure login - Incorrect credentials
    And I enter invalid password
    And I click on login button
    Then I should be presented with a validation failure alert message