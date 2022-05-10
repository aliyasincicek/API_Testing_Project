Feature: Put

  Scenario: TC04 Put
    Given user sets the path params for put method
    Given user makes a put request
    Then verify Status code
    And user validates the Changes