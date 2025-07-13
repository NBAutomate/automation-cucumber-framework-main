

Feature: Hotel Booking with Excel Data
  As a customer
  I want to book hotel rooms using different data sets
  So that I can test multiple booking scenarios

  Background:
    Given user launches the Hotel Booking Website

  @functional @datadriven
  Scenario: Create multiple bookings from Excel data
    When user creates bookings from Excel file "HotelBookingData.xlsx" sheet "ValidBookings"
    Then all bookings should be created successfully
    And booking confirmations should be displayed

  @functional @datadriven @negative
  Scenario: Test invalid booking data from Excel
    When user attempts bookings from Excel file "HotelBookingData.xlsx" sheet "InvalidBookings"
    Then appropriate error messages should be displayed
    And bookings should not be created
