@e2e @database_test
Feature: Database room test

  Scenario: Get the room and validate
    Given connect to database
    Then read the room and validate body