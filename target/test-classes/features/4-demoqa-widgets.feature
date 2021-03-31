
Feature: DemoQA - Widgets
  Background:
    Given I am on the "Home" page
    And   I click "Widgets"
    Then  I am on the "Widgets" page

  Scenario: Accordian
    When I click "Accordian option"
    And  I click "Section two heading"
    Then "Content" should contain "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old"
    When I click "Section three heading"
    Then "Content" should contain "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
    When I click "Section one heading"
    Then "Content" should contain "It was popularised in the 1960s with the release of Letraset sheets"

  Scenario: Auto Complete
    When I click "Auto complete option"
    And  I set "Multiple color field" to "Red"
    And  I set "Multiple color field" to "Green"
    And  I set "Multiple color field" to "Blue"
    Then "Multiple color container" should contain "Red"
    And  "Multiple color container" should contain "Green"
    And  "Multiple color container" should contain "Blue"
    When I set "Single color field" to "Purple"
    Then "Single color container" should contain "Purple"

  Scenario: Date Picker
    When I click "Date Picker option"
    And  I click "Select date"
    And  I set "Year field" to "1924"
    And  I set "Month field" to "March"
    And  I set "Date field" to "28"
    Then I see "Select date value" with the following data:
      | Value      |
      | 03/28/1924 |
    When I click "Select date and time"
    And  I set "Year field" to "2018"
    And  I set "Month field" to "March"
    And  I set "Date field" to "28"
    And  I set "Time field" to "21:00"
    Then I see "Select date and time value" with the following data:
      | Value                  |
      | March 28, 2018 9:00 PM |

  Scenario: Slider
    When I click "Slider option"
    And  I set "Slider ball" to "10"
    Then I see "Slider value" with the following data:
      | Value |
      | 10    |
    And  I set "Slider ball" to "40"
    Then I see "Slider value" with the following data:
      | Value |
      | 40    |

  Scenario: Progress bar
    When I click "Progress bar option"
    And  I set "Progress bar" to "44"
    Then I see "Progress bar" with the following data:
      | Value |
      | 44    |

  Scenario: Tabs
    When I click "Tabs option"
    Then "More tab" should be "disabled"
    And  I click "Origin tab"
    Then "Content" should contain "Contrary to popular belief, Lorem Ipsum is not simply random text."
    When I click "Use tab"
    Then "Content" should contain "Various versions have evolved over the years"
    When I click "What tab"
    Then "Content" should contain "unknown printer took a galley"
@run
  Scenario: Tool tips
    When I click "Tool Tips option"
    And  I hover over "Hover me to see button"
    Then "Button Tool tip" should contain "You hovered over the Button"
    When I hover over "Hover me to see field"
    Then "Text Field Tool tip" should contain "You hovered over the text field"
    When I hover over "Contrary"
    Then "Contrary Tool tip" should contain "You hovered over the Contrary"
    When I hover over "Section 1.10.32"
    Then "Section Tool tip" should contain "You hovered over the 1.10.32"

  Scenario: Menu
    When I click "Menu option"
    And  I hover over "Main Item 1"
    Then "SUB SUB LIST" should be "not visible"
    When I hover over "Main Item 3"
    Then "SUB SUB LIST" should be "not visible"
    When I hover over "Main Item 2"
    Then "SUB SUB LIST" should be "visible"
    When I hover over "SUB SUB LIST"
    Then "Sub Sub item 1" should be "visible"
    And  "Sub Sub item 2" should be "visible"
@run
  Scenario: Select Menu
    When I click "Select Menu option"
    And  I set "Select Value" to "Another root option"
    Then "Select Value" should contain "Another root option"
    When I set "Select One" to "Prof."
    Then  "Select One" should contain "Prof."
    When I set "Old Style Select Menu" to "Black"
    Then "Old Style Select Menu" should contain "Black"
    When I set "Multiselect drop down" to "Red"
    And  I set "Multiselect drop down" to "Green"
    And  I set "Multiselect drop down" to "Blue"
    Then "Multiselect drop down values" should contain "Red"
    And  "Multiselect drop down values" should contain "Green"
    And  "Multiselect drop down values" should contain "Blue"
    When I click "SAAB"
    And  I click "Audi"
    Then I see "Standard multi select" with the following data:
      | Checked |
      | SAAB    |
      | Audi    |


