Feature:
  Test API feature

  Scenario: Test simple GET operation by getting a single user
    Given I perform GET operation with content type JSON
    And I search for the specific user "api/users/2"
    Then I should get the response with code 200

  Scenario: 1 Demonstrating that user is able to send request and get appropriate request for SINGLE user info
    Given User sets the link and contentType for request
    When User sends the request to the api
    Then Status Code is 200
    And Response body is equal to test.json
    And Response body contains FIRST_NAME filed with JANET value

  Scenario: 2 Demonstrating that user is able to send request and get appropriate request for MULTIPLY users info
    Given User sets the link and contentType for request
    When User sends GET request to /api/users/page=2 api
    Then Status Code is 200
    And Response body is equal to listOfUsers.json
    And Response body contains data-1.email filed with lindsay.ferguson@reqres.in value

  Scenario: 3 Demonstrating that user is able to send POST request and get status code 201
    Given User sets the link and contentType for request
    When User sends POST request to /api/users with body post.json
    Then Status Code is 201
