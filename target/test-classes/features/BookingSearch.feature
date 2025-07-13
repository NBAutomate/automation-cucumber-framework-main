Feature: Hotel Booking Search Functionality
  As a user
  I want to search for hotel rooms
  So that I can book accommodation for my stay

  Background:
    Given I am on the hotel booking homepage

  @functional @smoke
  Scenario: Search for available rooms with valid dates
    When I enter check-in date as "2025-10-01"
    And I enter check-out date as "2025-10-05"
    And I click on search button
    Then I should see available rooms displayed
    And I should see room details with prices

  @functional @regression
  Scenario: Search with invalid date range
    When I enter check-in date as "2025-10-05"
    And I enter check-out date as "2025-10-01"
    And I click on search button
    Then I should see error message "Check-out date must be after check-in date"

  @functional @edge-case
  Scenario: Search with same check-in and check-out dates
    When I enter check-in date as "2025-10-01"
    And I enter check-out date as "2025-10-01"
    And I click on search button
    Then I should see error message "Minimum stay of 1 night required"

  @functional @regression
  Scenario: Search without entering dates
    When I click on search button without entering dates
    Then I should see validation errors for required fields

  @functional @positive
  Scenario: Filter search results by price range
    When I enter check-in date as "2025-08-01"
    And I enter check-out date as "2025-08-05"
    And I click on search button
    And I filter results by price range "50-150"
    Then I should see rooms within the selected price range

  @functional @booking
  Scenario: Complete room booking process
    When I enter check-in date as "2025-08-01"
    And I enter check-out date as "2025-08-05"
    And I click on search button
    And I select the first available room
    And I fill booking details:
      | firstName | lastName | email           | phone      |
      | John      | Doe      | john@test.com   | 1234567890 |
    And I click on book room button
    Then I should see booking confirmation message
    And I should receive booking confirmation details