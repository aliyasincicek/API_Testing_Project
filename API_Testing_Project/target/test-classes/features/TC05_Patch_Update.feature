Feature: Patch

  Scenario: TC05 Patch
    Given user sets the path params for patch method
    Given user makes a patch request
    Then verify Status Code
    And user Validates the Changes