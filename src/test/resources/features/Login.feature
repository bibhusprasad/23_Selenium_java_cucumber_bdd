@login

Feature: WebDriver University - Login Page

  Background:
    Given I access the WebDriver University login page

  Scenario: Validate Successful login - Correct credentials
    When I enter valid username webdriver
    And I enter valid password webdriver123
    And I click on login button
    Then I should be presented with a validation success alert message

  Scenario: Validate failure login - Incorrect credentials
    When I enter valid username webdriver
    And I enter invalid password password123
    And I click on login button
    Then I should be presented with a validation failure alert message

  Scenario Outline: Validate - Successful and Unsuccessful Login
    When I enter a username <username>
    And I enter a password <password>
    And I click on login button
    Then I should be presented with the following login validation message <loginValidationMessage>

    Examples:
    | username  | password     | loginValidationMessage |
    | webdriver | webdriver123 | validation succeeded   |
    | webdriver | password123  | validation failed      |
    | joe_blogs | password1    | validation failed      |


