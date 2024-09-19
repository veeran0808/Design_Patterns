package getAPIS;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

public class GETAPIRQUEST_WithBDD {

	@Test
	public void getProducts() {
	    given().log().all()
	        .when().log().all()
	          .get("https://fakestoreapi.com/products")
	        .then().log().all()
	          .assertThat()
	          .statusCode(200)
	          .and()
	          .contentType(ContentType.JSON)
	          .and()
	          .header("Connection", "keep-alive")
	          .and()
	          //response body size
	          .body("size()", equalTo(20))  
	    //ID should not be null
	          .body("id", is(notNullValue()))
	          .body("title", hasItem("Mens Cotton Jacket"));
	}

		  
	
	
}
