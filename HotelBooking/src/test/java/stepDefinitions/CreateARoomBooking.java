package stepDefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import stepFunction.PostQuery;




public class CreateARoomBooking {
	String dataForBooking;
    Response response;
	
	@Given("I have user data in file {string}")
	public void i_have_user_data_in_file(String fileName) {
		try {
			dataForBooking = new String(Files.readAllBytes(Paths.get("./src/test/resources/testData/"+fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("I submit the booking request")
	public void i_submit_the_booking_request() {
	   response= PostQuery.getResponseForPostCall(dataForBooking);
	    
	}
	@Then("The response status should be {int}")
	public void the_response_status_should_be (int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
	    
	}



}
