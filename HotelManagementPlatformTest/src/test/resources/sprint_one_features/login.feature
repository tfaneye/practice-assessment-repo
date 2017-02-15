@wip
Feature: Login
  As a customer Service Personnel
  I want login to the Hotel application
  So that I create Customer entry

  Scenario: Test for login functionality
    Given I am on the Home page of the Hotel application
    When I supply username "admin" and password "password"
    Then I should see a Logout "logout"