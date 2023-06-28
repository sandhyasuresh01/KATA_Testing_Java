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

  Scenario: Display the error alert
    Given I enter valid text in firstName lastName except email control
    When I select book room
    Then I show error

  Scenario: Fill up the necessary information required
    Given I am on the room booking form
    When I enter all text in all the form controls
    Then I validate the text in all form fields
