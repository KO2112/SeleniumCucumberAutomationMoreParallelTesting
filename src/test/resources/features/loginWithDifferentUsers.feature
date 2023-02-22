Feature: Login with different users
# @wip
  Scenario Outline: login with student and librarian
    Given user is on login page
    When user login with "<username>" and "<password>"
    Then account holder name should be "<name>"
    Examples:
      | username           | password | name            |
      | student27@Library  | EluZrsAu | Test Student 27 |
      | student28@Library  | t393UQs3 | Test Student 28 |
      | student29@1library | g8EyNm98 | Test Student 29 |
      | student30@Library  | QX6FWzj6 | Test Student 30 |
      | student31@library  | yEKjyg5T | Test Student 31 |
      | student32@library  | RqJkWmUu | Test student 32 |
      | student33@library  | 4V3Kd1YG | Test Student 33 |
      | student34@library  | JysGHP8G | Test Student 34 |
      | student35@library  | r200kz9m | Test Student 35 |
      | student36@library  | WV2WrNrk | Test Student 36 |
      | student370Library  | sqs981TY | Test Student 37 |
      | student38@Library  | nca2fAGL | Test Student 38 |
      | student39@library  | kCrQEt6x | Test Student 39 |
      | student40@Library  | ZkFJCg0d | Test Student 40 |
