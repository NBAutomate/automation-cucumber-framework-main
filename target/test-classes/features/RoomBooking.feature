Feature: Booking Functionality
  As a customer I want to book Shady Meadows BnB room
  So that I can secure accommodation for my travel

  Background:
    Given user launches the Hotel Booking Website

  @functional @smoke @booking
  Scenario: Verify hotel information display
    When user views the hotel information section
    Then hotel name should be displayed
    And hotel description should be displayed
    And hotel image should be displayed
    And hotel contact information should be displayed

  @functional @smoke @booking
  Scenario: Search for available rooms with valid dates
    When user clicks on Book Now button
    And user enter check-in date as "13/10/2025"
    And user enter check-out date as "15/10/2025"
    And user clicks on check availability button
    Then user should see available rooms displayed
    And user should see room details with prices


  @functional @positive @booking
  Scenario: Successfully create a B&B Room booking
    When user clicks on Book Now button
    And user enter check-in date as "13/10/2025"
    And user enter check-out date as "15/10/2025"
    And user clicks on check availability button
    And user selects the desired room
    And user see the price summary
    And user clicks Reserve Now button
    And user fill booking form with personal details
      | firstname | lastname   | email                | phone         |
      | Katy      | Perry      | katy.perry@test.com  | 441234567890  |
    And user clicks Reserve Now button
    Then booking should be created successfully
    And booking confirmation should be displayed

  @functional @booking
  Scenario: Verify room booking form is displayed
    When user navigates to booking section
    Then booking form should be displayed
    And firstname field should be present
    And lastname field should be present
    And email field should be present
    And phone field should be present

  @functional @negative @booking
  Scenario: Booking with invalid email format
    When user navigates to booking section
    And user fills booking form with invalid email
      | firstname  | lastname     | email     | phone         |
      | David      | Beckham      | invalid   | 441234567890  |
    And user clicks Reserve Now button
    Then error message should be displayed
    And booking should not be created

  @nonfunctional @performance @booking
  Scenario: Verify page load performance
    When user launches the Hotel Booking Website
    Then page should load within 5 seconds
    And all images should load properly

  @nonfunctional @usability @test @booking
  Scenario: Verify responsive design
    When user views the website on different screen sizes
    Then layout should adapt to mobile view
    And layout should adapt to tablet view
    And layout should adapt to desktop view

