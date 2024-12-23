package stepFunction;

import static io.restassured.RestAssured.given;

import api.endpoints.ResourcePath;
import io.restassured.response.Response;

public class DeleteQuery {
	static Response response;
	public static Response getResponseForDeleteCall(String dataForBooking)
	{
	 try {
		response = 
				    given()
				    .baseUri(ResourcePath.basePath)
				    .basePath(ResourcePath.deletePath)
				    .when()
				    .delete()
				    .then()
				    .extract().response();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return response;

}
}
