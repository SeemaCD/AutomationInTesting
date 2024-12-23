package stepFunction;

import static io.restassured.RestAssured.given;

import api.endpoints.ResourcePath;
import io.restassured.response.Response;

public class GetRoomDetails {
	static Response response;
	public static Response getResponseForGetCall(String dataForBooking)
	{
	 try {
		response = 
				    given()
				    .baseUri(ResourcePath.basePath)
				    .basePath(ResourcePath.bookingPath)
				    .when()
				    .get()
				    .then()
				    .extract().response();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return response;

}
}
