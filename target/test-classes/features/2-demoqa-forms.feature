
Feature: DemoQA - Forms page
  Background:
    Given I am on the "Home" page
    And   I click "Forms"
    Then  I am on the "Forms" page

  Scenario: Practice form
    When I click "Practice form option"
    And  I set "First name field" to "Leeroy"
    And  I set "Last name field" to "Jenkins"
    And  I set "Email field" to "example@testdevlab.com"
    And  I click "Other radio button"
    And  I set "Mobile number field" to "0123456789"
    And  I click "Date of birth"
    And  I set "Year field" to "1924"
    And  I set "Month field" to "March"
    And  I set "Date field" to "28"
    And  I set "Subject field" to "Maths"
    And  I click "Music checkbox"
    And  I set "Upload picture" to "/files/nani.jpeg"
    And  I set "Current address field" to "Area 35, Northern Minnesota, USA"
    And  I set "State field" to "Haryana"
    And  I set "City field" to "Karnal"
    And  I click "Submit button"
    Then I see "Submittion form" with the following data:
      | First name | Last name | Email                  | Mobile number | Date of birth | Subject | Current address                  | State   | City   | Gender | Hobbies | Picture   |
      | Leeroy     | Jenkins   | example@testdevlab.com | 0123456789    | 28 March,1924 | Maths   | Area 35, Northern Minnesota, USA | Haryana | Karnal | Other  | Music   | nani.jpeg |
