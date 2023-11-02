Feature: Verify Homepage components for opencart e-commerce website

  Background:
    Given I launch the application
 @RegressionTesting
  Scenario: Verify various components on home page
    Given User on Home page
    Then Verify headers components on home page
      | 123456789     |
      | My Account    |
      | Wish List (0) |
      | Shopping Cart |
      | Checkout      |
    And Verify various feature components
