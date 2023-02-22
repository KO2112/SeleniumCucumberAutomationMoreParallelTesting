@Regression @Smoke @Login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts.
  and dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background: For the test scenarios in the feature file, user is expected to be on login page
    Given user is on the library login page
  @Librarian @Employee
  Scenario:Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @Student @db
  Scenario: login as student
      When user enters student name
      And user enters student password
      Then user should see the dashboard
  @Admin @Employee
  Scenario: Login as admin
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard
