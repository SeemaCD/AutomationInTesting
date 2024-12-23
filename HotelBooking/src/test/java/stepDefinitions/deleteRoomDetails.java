package stepDefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import stepFunction.*;

public class deleteRoomDetails {
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
	@When("I delete the booking request")
	public void i_delete_the_booking_request() {
		 response= DeleteQuery.getResponseForDeleteCall(dataForBooking);	
	   
	}
	@Then("The response status should be {int}")
	public void the_response_status_should_be (int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
	    
	}

}
