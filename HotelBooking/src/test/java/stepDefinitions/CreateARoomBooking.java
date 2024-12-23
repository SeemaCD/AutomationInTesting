package stepDefinitions;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import api.payload.BookingDetails;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import stepFunction.PostQuery;

import static org.hamcrest.Matchers.*;


public class CreateARoomBooking {
	String dataForBooking;
    Response response;
    ObjectMapper objectMapper = new ObjectMapper();
	
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
	
	@And("Response is matching with request details")
	public void and_response_is_matching_with_request_details()
	{
		BookingDetails bookingDetails = null;
		try {
			bookingDetails = objectMapper.readValue(dataForBooking, BookingDetails.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat("firstname", is(equalTo(bookingDetails.getFirstname())));
		assertThat("lastname", is(equalTo(bookingDetails.getLastname())));
		assertThat("checkin", is(equalTo(bookingDetails.getBookingDates().getCheckin())));
		
		
	}



}
