package FirstRestAssuredProgram;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample {

	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost(){
		
//		Object[][] data = new Object [2][2];
//		
//		data[0][0]= "Albert";
//		data[0][1]= "Developer";
//		
//		data[1][0]= "Shreya";
//		data [1][1] = "Singer";
//		
//		return data;
//		
		
		return new Object[][] {
			{"Thomas","Scientist"},
			{"Graham","Scientist"}
		};
	}
	
	@Test(dataProvider = "dataForPost")
	public void test_post(String name, String job) {
		
		JSONObject request = new JSONObject();
		
		request.put("name", name);
		request.put("job", job);

		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@DataProvider(name = "dataForDelete")
	public Object[][] dataForDelete(){
		return new Object[][] {
			{"Thomas","Scientist"}
		};
	}

	@Test(dataProvider = "dataForDelete")
	public void test_2_delete(String name, String job) {
		
		
		given().
		when().
		delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();

	}
}
