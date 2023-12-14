@test-api
Feature: Fake API Activities

  Background:
    Given client get authorization using oauth2

  @scenario-api-1
  Scenario: GET Activities
    When client send "GET" request "/api/v1/Activities"
    Then client should see response with status code "200"

  @scenario-api-2
  Scenario: POST Activities
    When client create activities with method POST
      | title      | govtech_activities           |
      | dueDate    | 2023-12-14T06:45:47.819Z     |
    Then client should see response with status code "200"

  @scenario-api-3
  Scenario: GET Activities with id
    When client get activities with method GET with id
    Then client should see response with status code "200"

  @scenario-api-4
  Scenario: PUT Activities with id
    When client update activities with method PUT with id
    Then client should see response with status code "200"

  @scenario-api-5
  Scenario: DELETE Activities with id
    When client delete activities with method DELETE with id
    Then client should see response with status code "200"