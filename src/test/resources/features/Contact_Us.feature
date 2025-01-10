Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the WebDriver University contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful Submission - Specific Data
    Given I access the WebDriver University contact us page
    When I enter a specific first name john
    And I enter a specific last doe
    And I enter a specific email address johndoe@gmail.com
    And I enter a specific comment "Hello how are you?"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

