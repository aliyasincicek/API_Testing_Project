Feature: Get List Users

  Scenario: TC01 Get List Users
    Given user sets the necessary path params
    Given user sends the get request
    Then status code should be 200 for rooms
    Then verify that the response body should be as an expected




