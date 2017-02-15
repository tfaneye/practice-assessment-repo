Feature: Create multiple hotel entry
  As a customer service personnel
  I want to enter multiple customers
  So that I can have them stored in the Database

  Scenario Outline: Test to create multiple customer entry
    Given I have successfully signed in with "<username>" and "<password>"
    When I enter the following customer details: "<hotelName>", "<address>", "<owner>", "<phoneNumber>", "<email>" and click on create button
    Then I should see a record containing the name of the owner "<name>"
    Examples: Test data
      | username | password | hotelName          | address           | owner  | phoneNumber | email            | name   |
      | admin    | password | HMRC 3 Star Hotel  | 1, Newcastle road | John   | 0123456789  | john@email.com   | John   |
      | admin    | password | HMRC 5 Star Hotel  | 2, Newcastle road | Kelvin | 0123456789  | kelvin@email.com | Kelvin |
      | admin    | password | HMRC 7 Star Hotel  | 3, Newcastle road | Brian  | 0123456789  | brian@email.com  | Brian  |
      | admin    | password | HMRC 10 Star Hotel | 4, Newcastle road | Daniel | 0123456789  | daniel@email.com | Daniel |