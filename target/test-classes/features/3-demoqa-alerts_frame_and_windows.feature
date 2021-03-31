
Feature: DemoQA - Alerts, Frame And Windows page
  Background:
    Given I am on the "Home" page
    And   I click "Alerts frame and windows"
    Then  I am on the "Alerts frame and windows" page

  Scenario: Browser windows - new tab
    When I click "Browser Windows option"
    And  I click "New tab button"
    And  I switch to new tab
    Then "Sample title" should contain "This is a sample page"

  Scenario: Browser windows - new window
    When I click "Browser Windows option"
    And  I click "New window button"
    And  I switch to new tab
    Then "Sample title" should contain "This is a sample page"
@run
  Scenario: Alerts - see alert
    When I click "Alerts option"
    And  I click "Alert button"
    Then Alert window should contain "You clicked a button"

  Scenario: Alerts - see alert after 5 seconds
    When I click "Alerts option"
    And  I click "Timer Alert button"
    And  I wait for "6" seconds
    Then Alert window should contain "This alert appeared after 5 seconds"

  Scenario: Alerts - confirm alert - Ok
    When I click "Alerts option"
    And  I click "Confirm Alert button"
    And  I accept alert window
    Then "Confirm Result" should contain "You selected Ok"

  Scenario: Alerts - confirm alert - Cancel
    When I click "Alerts option"
    And  I click "Confirm Alert button"
    And  I dismiss alert window
    Then "Confirm Result" should contain "You selected Cancel"

  Scenario: Alerts - prompt
    When I click "Alerts option"
    And  I click "Prompt Alert button"
    And  I set Alert window value to "You would love to know, eh ?"
    And  I accept alert window
    Then "Prompt result" should contain "You entered You would love to know, eh ?"
