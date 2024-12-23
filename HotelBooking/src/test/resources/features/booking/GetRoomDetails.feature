#This feature will cover all the happy and unhappy scenarios of getting room booking
Feature: get booking details
Scenario: Fetching room booking details for valid room id
    Given I have set the url to get the user details
    When I submit request to get booking details for room number 600
    Then The response status should be 200
    And I verified booking has been done for user "savalas"
    
Scenario Outline: Featching room booking details for non existing room id
    Given I have set the url to get the user details
    When I submit request to get booking details for room number <roomNumber>
     Then The response status should be 200
     
  Examples:
  |fileName|statusCodeValue|
  |601|404|
  |"601"|400|     
