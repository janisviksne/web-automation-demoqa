Feature: DemoQA - Interactions
  Background:
    Given I am on the "Home" page
    And   I click "Interactions"
    Then  I am on the "Interactions" page


  Scenario: Selectable interactions
    When I click "Selectable option"
    And I click "First list group item"
    Then "First list group item" sh