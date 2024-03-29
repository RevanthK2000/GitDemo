import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.payLoad;

public class Post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*RestAssured.baseURI = "https://rahulshettyacademy.com/";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payLoad.AddPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)"); */
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payLoad.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
	   String PlaceId = js.getString("place_id");
	   System.out.println("place_id = "+ PlaceId);
	   
	   //update the added place
	   
	   String newAddress = "70 Summer Walk, USA";
	   
	   given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json").body("{\r\n"
	   		+ "\"place_id\":\""+PlaceId+"\",\r\n"
	   		+ "\"address\":\""+newAddress+"\",\r\n"
	   		+ "\"key\":\"qaclick123\"\r\n"
	   		+ "}").when().put("maps/api/place/update/json")
	   .then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
	   
	   // Get the place
	   
	   String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id", PlaceId).when().get("maps/api/place/get/json")
	   .then().assertThat().log().all().statusCode(200).extract().response().asString();
	   
	   JsonPath js1 = new JsonPath(getPlaceResponse);
	   String actualAddress = js1.getString("address");
	   System.out.println(actualAddress);
	   Assert.assertEquals(actualAddress, newAddress);
	   
	   
	  
	   
		

	}

}
