Feature: Post

  Scenario: TC03 Post

    Given user sets the path params for post method
    Given user makes a post request
    Then verify status code
    And user validates the changes

