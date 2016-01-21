Feature: Search Page

  Background:
    Given that I go to Springer homepage

  Scenario: Perform a simple valid search
    When I input the query "bad" on the search bar
    Then I press the button search
    Then I should get directed to the "search results" page
    And I should see a "results list"
    And I should see a "filters box"
    And I should see a "details header"
    And I should see some amount of results

  Scenario: Perform a faulty search
    When I input the query "%&/($" on the search bar
    Then I press the button search
    Then I should get directed to the "search results" page
    And I should see 0 results

