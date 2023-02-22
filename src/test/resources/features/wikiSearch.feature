Feature: Wikipedia search functionallity and verification

  @WSF-45234

  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on wikipedia home page
    When User types "Steve Jobs" home page
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on wikipedia home page
    When User types "Steve Jobs" home page
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

    @soccer
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on wikipedia home page
    When User types "<searchValue>" home page
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header

    Examples: search values we are going to be using in this scenario is as below
      | searchValue       | expectedTitle     | expectedMainHeader |
      | Steve Jobs        | Steve Jobs        | Steve Jobs         |
      | Cristiano Ronaldo | Cristiano Ronaldo | Cristiano Ronaldo  |
      | Bob Marley        | Bob Marley        | Bob Marley         |
      | Chuck Norris      | Chuck Norris      | Chuck Norris       |
      | Antony Hopkins    | Antony Hopkins    | Antony Hopkins     |
      | Marie Curie       | Marie Curie       | Marie Curie        |


