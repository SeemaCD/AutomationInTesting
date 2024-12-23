package stepDefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class getRoomDetails {

	String dataForBooking;
	Response response;
	

	@Given("I have set the url to get the user details")
	public void i_have_set_the_url_to_get_the_user_details() {
		try {
			dataForBooking = new String(Files.readAllBytes(Paths.get("./src/test/resources/testData/GetARoomBooking.json")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	@When("I submit request to get booking details for room number {int}")
	public void i_submit_request_to_get_booking_details_for_room_number(Integer int1) {
	   
	}
	@Then("The response status should be {int}")
	public void the_response_status_should_be (int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
	    
	}



}
