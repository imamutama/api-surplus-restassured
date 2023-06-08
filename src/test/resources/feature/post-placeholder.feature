@post-place-holder @smoke-test
Feature: Create user place holder

  @create-user-input-from-scenario
  Scenario: user created with value input from scenario
    Given set header application json
    When send request post api placeholder has a title value "Testing" body value "Testing Automation Surplus" and userId 13
    Then request response has a 201 response code
    And requests response contains the correct json data with key "title" and value "Testing"
    And requests response contains the correct json data with key "body" and value "Testing Automation Surplus"
    And requests response contains the correct json data with key "userId" and value 13

  @create-user-input-random
  Scenario: user created with value input random
    Given set header application json
    When send request post api placeholder has a title,body and userId value
    Then request response has a 201 response code

  @create-user-input-from-datatable
  Scenario Outline: user created with value input from data table
    Given set header application json
    When send request post api placeholder has a title value "<title>" body value "<body>" and userId <userId>
    Then request response has a 201 response code
    And requests response contains the correct json data with key "title" and value "<title>"
    And requests response contains the correct json data with key "body" and value "<body>"
    And requests response contains the correct json data with key "userId" and value <userId>
    Examples:
      | title     | body                 | userId |
      | Testing 1 | Testing Automation 1 | 14     |
      | Testing 2 | Testing Automation 2 | 15     |
      | Testing 3 | Testing Automation 3 | 16     |