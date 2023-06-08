@get-place-holder @all-test
Feature: API Placeholder Surplus Testing

  @validate-json-schema
  Scenario: Validate json schema in response body
    Given set header application json
    When set parameter with param "id" has value a 6 in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And validation json schema type data response

  @search-by-id
  Scenario: User able to search by id
    Given set header application json
    When set parameter with param "id" has value a 2 in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And requests response contains the correct json data with key "[0].id" and value 2

  @search-by-user-id
  Scenario: User able to search by user id
    Given set header application json
    When set parameter with param "userId" has value a 12 in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And requests response contains the correct json data with key "[0].userId" and value 12

  @search-by-title
  Scenario: User able to search by title
    Given set header application json
    When set parameter with param "title" has value a "magnam facilis autem" in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And requests response contains the correct json data with key "[0].title" and value "magnam facilis autem"

  @search-by-id-and-userId
  Scenario: User able to search multiple param by user id and id
    Given set header application json
    When set parameter with param "userId" has value a 1 in request specification
    When set parameter with param "id" has value a 6 in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And requests response contains the correct json data with key "[0].userId" and value 1
    And requests response contains the correct json data with key "[0].id" and value 6

  @seacrh-10-user-by-id
  Scenario Outline: User able to search 10 user by id
    Given set header application json
    When set parameter with param "id" has value a <id> in request specification
    And request get api placeholder
    Then request response has a 200 response code
    And requests response contains the correct json data with key "[0].id" and value <id>
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
      | 5  |
      | 6  |
      | 7  |
      | 8  |
      | 9  |
      | 10 |