package getAPIS;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPIREquest_WithoutBDD {
	RequestSpecification request;

	@BeforeTest
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in";
		request = RestAssured.given();
		// request.header("Authrization", "bearer token val");
	}

	@Test
	public void getUserAPIRequest() {

		Response response = request.get("/api/users");

		// fetch status code
		int statusCode = response.statusCode();
		System.out.println(statusCode);

		// Verification point
		Assert.assertEquals(statusCode, 200);

		// Status message
		String statusMsg = response.statusLine();
		System.out.println(statusMsg);

		// Fetch body from the response
		response.prettyPrint();

		// Fetch response headers
		String contentType = response.header("Content-Type");
		System.out.println(contentType);

		// Fetch all headers
		List<Header> headerList = response.headers().asList();
		System.out.println(headerList.size());

		// Print all headers
		for (Header h : headerList) {
			System.out.println(h.getName() + "::" + h.getValue());
		}
	}

	@Test
	public void getUserAPIRequestwithQueryParam() {

		// query parameter
		request.queryParam("page", "1");
		request.queryParam("id", "1");

		// query parameters

		// request.header("Authrization", "bearer token val");
		Response response = request.get("/api/users");

		// fetch status code
		int statusCode = response.statusCode();
		System.out.println(statusCode);

		// Verification point
		Assert.assertEquals(statusCode, 200);

		// Status message
		String statusMsg = response.statusLine();
		System.out.println(statusMsg);

		// Fetch body from the response
		response.prettyPrint();

		// Fetch response headers
		String contentType = response.header("Content-Type");
		System.out.println(contentType);

		// Fetch all headers
		List<Header> headerList = response.headers().asList();
		System.out.println(headerList.size());

		// Print all headers
		for (Header h : headerList) {
			System.out.println(h.getName() + "::" + h.getValue());
		}
	}

	@Test
	public void getUserAPIRequestwithQueryParam_WithHashMapAPI() {

		// query parameters - always string
		Map<String, String> queryParamsMap = new HashedMap();
		queryParamsMap.put("page", "1");
		queryParamsMap.put("id", "2");
		request.queryParams(queryParamsMap);

		// request.header("Authrization", "bearer token val");
		Response response = request.get("/api/users");

		// fetch status code
		int statusCode = response.statusCode();
		System.out.println(statusCode);

		// Verification point
		Assert.assertEquals(statusCode, 200);

		// Status message
		String statusMsg = response.statusLine();
		System.out.println(statusMsg);

		// Fetch body from the response
		response.prettyPrint();

		// Fetch response headers
		String contentType = response.header("Content-Type");
		System.out.println(contentType);

		// Fetch all headers
		List<Header> headerList = response.headers().asList();
		System.out.println(headerList.size());

		// Print all headers
		for (Header h : headerList) {
			System.out.println(h.getName() + "::" + h.getValue());
		}
	}
}
