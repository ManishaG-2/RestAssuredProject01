package FirstRestAssuredProgram;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Request {

	
	@Test
	
	public void postData() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
	//	map.put("name","Manisha");
	//	map.put("job", "Automation Test Engineer");
		
		JSONObject request = new JSONObject();
		request.put("name", "Manisha");
		request.put("job", "Automation Test Engineer");
		
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users")
		.then()
		.statusCode(201);

		

	}
	
	//@Test
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "Manisha");
		request.put("job", "Automation Test Engineer");
		
		given()
		     .contentType("application/json; charset=utf-8")
		     .body(request)
		     
		.when()
		    .post("https://reqres.in/api/users")
		
		.then()
		    .statusCode(201)
		    .body("name",equalTo ("morpheus"))
		    .body("job",equalTo("leader"))
		    .body("id",equalTo("258"));
	}
	
	
	
	
}
