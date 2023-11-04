Feature:Login functionality for opencart e-commerce website

  Background:
    Given I launch the application

#@smoke
  Scenario: Successful login with valid credentials
    Given User should on login page
    When I have entered a valid username and password
      | username            | password    |
      | ravivp123@gmail.com | pawar@12345 |

    When I click on login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid credentials
    Given User should on login page
    Given I have entered a invalid "<username>" and "<password>"
    When I click on login button
    Then I should see an error message indicating "<error_message>"
    Examples:
      | username          | password        | error_message                                         |
      | invalid@gmail.com | invalidpassword | Warning: No match for E-Mail Address and/or Password. |
      | valid@gmail.com   | password        | Warning: No match for E-Mail Address and/or Password. |

#  @smoke
  Scenario: Navigating forgotten password page
    Given User should on login page
    When I click on forgotten password link
    Then I should redirect to the password reset page

  #@smoke
  Scenario: Verify login with invalid credential
    Given User should on login page
    When User enter invalid credential
      | email           | password    |
      | ravi2@gmail.com | password    |
      | rv@gmail.com    | 2333        |
      | __@outlook.com  | pawar@12345 |
    Then I click on login button
    Then I should see an error message on login page


