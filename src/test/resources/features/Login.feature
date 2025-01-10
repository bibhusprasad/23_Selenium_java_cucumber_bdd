@login

Feature: WebDriver University - Login Page

  Scenario: Validate Successful login - Correct credentials
    Given I access the WebDriver University login page
    When I enter valid username webdriver
    And I enter valid password webdriver123
    And I click on login button
    Then I should be presented with a validation success alert message

  Scenario: Validate failure login - Incorrect credentials
    Given I access the WebDriver University login page
    When I enter invalid username
    And I enter invalid password
    And I click on login button
    Then I should be presented with a validation failure alert message