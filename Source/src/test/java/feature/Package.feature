Feature: NewOrder

  Scenario: Choose price
    Given user complete first form
    When user write user data
    And user write recipient data
    And user choose delivery place
    And user write declaration
    And user choose three checkbox
    Then user go to next page