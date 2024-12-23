package stepFunction;

import static io.restassured.RestAssured.given;

import api.endpoints.ResourcePath;
import io.restassured.response.Response;

public class PostQuery {
	static Response response;
	public static Response getResponseForPostCall(String dataForBooking)
	{
	 try {
		response = 
				    given()
				    .baseUri(ResourcePath.basePath)
				    .basePath(ResourcePath.bookingPath)
				    .contentType("application/json")
				    .body(dataForBooking)
				    .when()
				    .post()
				    .then()
				    .extract().response();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return response;

}}
