#This feature will cover all the happy and unhappy scenarios of room booking
Feature: Create a booking

  Scenario: Create a room booking with valid data
    Given I have user data in file "CreateARoomBooking_ValidValues.json"
    When I submit the booking request
    Then The response status should be 201
  
      
