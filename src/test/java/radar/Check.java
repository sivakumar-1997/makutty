package radar;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Check {
	//----------------------getting previous values -----------------//
	@Test(enabled = true)
	public void get_req() {
		given().when().get("http://localhost:3000/users").then().statusCode(200).and().log().all();
	}
	//-----------------------------posting values --------------------------//
	@Test(priority = 1,enabled = true)
	public void post_req() {
		JSONObject obj = new JSONObject();
		obj.put("Firstname", "venkat");
		obj.put("Lastname", "Mani");
		obj.put("dept", "Qty_Assurance");
		obj.put("subjectId", "2");
		given().header("Content-Type","application/json").body(obj.toJSONString())
		.when()
				.post("http://localhost:3000/users/")
		.then().statusCode(201);
	}
	//-----------------------------put request ----------------------------//
	@Test(priority = 2 , enabled = true)
	public void put_req() { 
		JSONObject obj = new JSONObject();
		obj.put("Firstname", "Kala");
		obj.put("Lastname", "G");
		obj.put("dept", "Qty_Assurance");
		obj.put("subjectId", "2");
		given().header("Content-Type","application/json").accept(ContentType.JSON).body(obj.toJSONString())
		.when().put("http://localhost:3000/users/2").then().statusCode(200).and().log().all();
	}
	//-----------------------------delete request-------------------------//
	@Test(priority = 3,enabled = false)
	public void del_req() {
		given().when().delete("http://localhost:3000/users/3").then().statusCode(200).and().log().all();
	}@Test(priority = 4,enabled = true)
	public void finalget_req() {  
		given().when().get("http://localhost:3000/users");
		
	}
}
