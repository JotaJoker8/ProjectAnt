@Testt
Feature: Test Sescam app correct functionality login

@Test1
Scenario Outline: As a user I want to enter in the Sescam app
    Given I navigate to the Sescam app
    And Access button is disabled
    When Write <correctUser> and <correctPassword>
    And click on the access button
    Then I enter in the Sescam app

    Examples:
    | correctUser | correctPassword |
    |    aall32   |    aall32       |

@Test2
Scenario Outline: I want to see the login error message
    Given Navigate to the app
    When Enter <incorrectUser> and <incorrectPassword> incorrect
    And I click on the access button
    Then It shows login error message 
    And Recover contents of message
    And Input border is red

    Examples:
    | incorrectUser | incorrectPassword |
    |    aall31     |      aall32       |     