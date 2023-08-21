package FirstRestAssuredProgram;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Demo3_PUT_Request {


	@Test
	public void test_2_put() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Manisha");
		request.put("job", "Automation Test Engineer");
		
		System.out.println(request.toJSONString());
		
		given().
		when().
		put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).log().all();

	}
}
