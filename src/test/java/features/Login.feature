Feature: Application Login

  Scenario: Login with valid credentials
    Given Open any Browser
    And Navigate to Login page
    When User enters username as "r03app_student5" and password as "123abc" into the fields
    And User clicks on Login button
    Then Verify user is able to successfully login
