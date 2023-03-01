package restAssured.project;

import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class POSTRequest extends TestBase {

public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPOSTData() {
		
		map.put("id", "27");
		map.put("email", "itsme1723@gmail.com");
		map.put("first_name", "shweta");
		map.put("last_name", "singh");
		
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users";
		logger.info("BaseURL specified");
	}
	
	@Test
	public void verifyResponse() {
		logger.info("Inside POST method");
		RestAssured
			.given()
				.contentType("application/json")
				.body(map)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(201)
			.and()
				.body("email", is("itsme1723@gmail.com"))
				.log().all();
		logger.info("Response Code Verified");
		//System.out.println(RestAssured.given().get().body().asString());
}
	@Test
	public void testErrorLogs() {
		String s = "shweta";
		try {
		int a = Integer.parseInt(s);
		
	}catch(NumberFormatException e) {
		e.printStackTrace();
		logger.error(e.getMessage());
	}
		}
	
}
