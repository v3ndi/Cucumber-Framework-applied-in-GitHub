Feature: searching feature

  Scenario Outline: a guest when searching GitHub
    Given user visits the site as guest (not logged in)
    When The user wants to search for the term "<keyWord>" from the landing page search field
    And initiates the search
    Then A count of matching results should be displayed
    And verifies the facebook project as the first result
    Examples:
      |keyWord|
      |create-react-app|

  Scenario: a guest is searching for about section on GitHub
    Given User is a guest (not logged in) on GitHub's landing page
    When The user clicks the About button in the landing page footer
    Then Confirm that the content on the page provides information about GitHub's purpose, mission, and related details