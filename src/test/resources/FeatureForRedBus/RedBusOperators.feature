Feature: RedBus Operators view and prints

  Scenario: View and interact with Private Bus Operators
    Given User navigate to application URL and verify Home page
    When User click on View All for the Private Bus Operators section
    And Click the operator directories with the alphabet I then R and then back to A
    And User scroll to the end of the page
    And User click on pagination page 3
    Then User print all the operators listed in an output file
