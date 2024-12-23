#This feature will cover all the happy and unhappy scenarios of room booking
Feature: Create a booking

  Scenario: Create a room booking with valid data
    Given I have user data in file "CreateARoomBooking_ValidValues.json"
    When I submit the booking request
    Then The response status should be 201
    And Response is matching with request details
  
  Scenario Outline: Create a room booking with missing required fields
    Given I have user data in file <fileName>
    When I submit the booking request
    Then The response status should be <statusCodeValue>
  Examples:
  |fileName|statusCodeValue|
  |"CreateARoomBooking_invalidDataTypeOfFields.json"|400|
  |"CreateARoomBooking_InvalidDates"|400|
  |"CreateARoomBooking_MandatoryFieldsMissing.json"|400|
  |"CreateARoomBooking_AlreadyBooked.json"|409|
   
   
    
