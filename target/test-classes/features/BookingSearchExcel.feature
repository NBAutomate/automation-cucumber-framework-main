Feature: Hotel Booking Search with Excel Data
  As a user
  I want to search for hotel rooms using various test data
  So that I can validate different search scenarios

  Background:
    Given I am on the hotel booking homepage

  @functional @data-driven
  Scenario Outline: Search for rooms with multiple date combinations
    When I enter check-in date as "<checkin_date>"
    And I enter check-out date as "<checkout_date>"
    And I click on search button
    Then I should see "<expected_result>"

    Examples:
      | checkin_date | checkout_date | expected_result        |
      | 2025-08-01   | 2025-08-05    | available rooms        |
      | 2025-08-10   | 2025-08-15    | available rooms        |
      | 2025-08-20   | 2025-08-25    | available rooms        |

  @functional @data-driven @excel
  Scenario: Search for rooms using Excel test data
    When I read test data from Excel file "BookingTestData.xlsx"
    And I perform search with Excel data
    Then I should validate results against expected outcomes

  @functional @data-driven @negative
  Scenario Outline: Search with invalid data combinations
    When I enter check-in date as "<checkin_date>"
    And I enter check-out date as "<checkout_date>"
    And I click on search button
    Then I should see error message "<error_message>"

    Examples:
      | checkin_date | checkout_date | error_message                           |
      | 2025-08-05   | 2025-08-01    | Check-out date must be after check-in  |
      | 2025-07-01   | 2025-07-02    | Check-in date cannot be in the past     |
      | invalid      | 2025-08-05    | Please enter valid date format          |

  @performance @load
  Scenario: Performance test for search functionality
    When I perform search operations "10" times concurrently
    Then each search should complete within "5" seconds
    And system should handle concurrent requests properly