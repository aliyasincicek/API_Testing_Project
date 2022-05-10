Feature: Get Single User

  Scenario: TC02 Get Single User

    Given user sets the path params
    Given user sends the get single request
    Then status code should be 200
    Then verify that the Response body should be as an expected