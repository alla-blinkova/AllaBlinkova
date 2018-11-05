Feature: JDI website tests.

  Scenario: Service Page interface test
    Given I am on "Home Page"
    Then The browser title is Home Page
    When I login as user "Piter Chailovskii"
    Then Name is displayed and equals to "PITER_CHAILOVSKII"'s name
    Then 4 pictures are displayed on the page
    And 4 texts are displayed under pictures
    And 2 texts - headline and description - are displayed above pictures
    When I click on "Service" button in Header

    Then Dropdown contains following options:
    |Support            |
    |Dates              |
    |Complex Table      |
    |Simple Table       |
    |User Table         |
    |Table With Pages   |
    |Different Elements |
    |Performance        |
    When I click on "Service" subcategory in the left section

    Then Dropdown of left section contains following options:
    |Support            |
    |Dates              |
    |Complex Table      |
    |Simple Table       |
    |User Table         |
    |Table With Pages   |
    |Different Elements |
    |Performance        |
    When I click on "Service" button in Header
    And I click on "DIFFERENT_ELEMENTS" button in Service dropdown
    Then 4 checkboxes, 4 radios, 1 dropdown, 2 buttons are displayed
    And Left section is displayed
    And Right section is displayed
    When I click on "WATER, WIND" checkboxes
    Then Log row for CHECKBOX is displayed. Name of element and status (for checkboxes): WATER, true
    And Log row for CHECKBOX is displayed. Name of element and status (for checkboxes): WIND, true
    When I select "SELEN" radiobutton
    Then Log row for RADIOBUTTON is displayed. Name of element and status (for checkboxes): SELEN
    When I select "YELLOW" in dropdown
    Then Log row for DROPDOWN is displayed. Name of element and status (for checkboxes): YELLOW
    When I click on "WATER, WIND" checkboxes
    Then Log row for CHECKBOX is displayed. Name of element and status (for checkboxes): WATER, false
    And Log row for CHECKBOX is displayed. Name of element and status (for checkboxes): WIND, false