Feature: Create hotel entry
  As a customer service personnel
  I want to enter a customer
  So that I can have them stored in the Database

  Scenario Outline: Test to create one customer entry
    Given I have successfully signed in with "<username>" and "<password>"
    When I enter the following customer details: "<hotelName>", "<address>", "<owner>", "<phoneNumber>", "<email>" and click on create button
    Then I should see a record containing the name of the owner "<name>"
    Examples: Test data
      |username|password| hotelName  | address            | owner | phoneNumber | email           | name  |
      |admin   |password| HMRC Hotel | 1, New Castle road | Tunde | 0123456789  | tunde@email.com | Tunde |