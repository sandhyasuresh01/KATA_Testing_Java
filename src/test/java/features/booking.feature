Feature: Book a room

@book
Scenario: Option to book a room is available on the page
Given I am on the home page
When I browse through the page
Then I have the option to book a room

  Scenario: Option to fill up the information required
    Given I am on the book a room option
    When I select book this room option
    Then I have the option to see form controls to fill up necessary information