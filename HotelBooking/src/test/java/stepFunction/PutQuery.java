package stepFunction;

import static io.restassured.RestAssured.given;

import api.endpoints.ResourcePath;
import io.restassured.response.Response;

public class PutQuery {
	static Response response;
	public static Response getResponseForPutCall(String dataForBooking)
	{
	 try {
		response = 
				    given()
				    .baseUri(ResourcePath.basePath)
				    .basePath(ResourcePath.putPath)
				    .when()
				    .put()
				    .then()
				    .extract().response();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return response;

}
}
