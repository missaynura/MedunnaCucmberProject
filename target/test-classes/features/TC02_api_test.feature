@e2e @api
Feature: Get the room and validate

  Scenario: Send the get request and do assertion
    Given send get request by id to read the room
    Then validate body
