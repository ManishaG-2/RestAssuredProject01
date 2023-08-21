package FirstRestAssuredProgram;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HttpRequests {
	
	int id;
	@Test (priority = 1)
	
	void getUsers() {
		
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		  
		  .then()
		     .statusCode(200)
		     .body("page",equalTo(2))
		     .log().all();
	}
	
	@Test (priority = 2)
	void createUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("name","John");
		data.put("job", "Trainer");
		
		id = given()
		   .contentType("application/json")
		   .body(data)
		   
		   .when()  
		      .post("https://reqres.in/api/users")
		      .jsonPath().getInt("id");
		
	
	}
	/*@Test (priority = 3, dependsOnMethods = {"createUser"})
	
	void updateUser() {
       HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("name","smith");
		data.put("job", "teacher");
		
		 given()
		   .contentType("application/json")
		   .body(data)
		   
		   .when()  
		      .put("https://reqres.in/api/users"+id)
		     
		    
		    .then()
		      .statusCode(200)
		      .log().all();
		    
	}*/

}
