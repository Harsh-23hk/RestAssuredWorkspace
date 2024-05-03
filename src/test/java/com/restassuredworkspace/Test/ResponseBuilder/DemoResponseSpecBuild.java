package com.restassuredworkspace.Test.ResponseBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoResponseSpecBuild {


    ResponseSpecification responseSpec = null;
    RequestSpecification requestSpec;

    @BeforeClass
    public void createRequestSpec() {
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestSpec = requestBuilder.setBaseUri("https://restful-booker.herokuapp.com")
                .setBasePath("/booking")
                .build().log().headers();
    }

    @BeforeClass
    public void createResponseSpec() {

        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();

        responseBuilder.expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(3000L));



	/*	responseBuilder.expectStatusCode(200);
		responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectResponseTime(Matchers.lessThan(3000L));*/

        responseSpec = responseBuilder.build();
    }

    @Test
    public void getAllBookingIds() {
        RestAssured.given(requestSpec).get()
                .then()
                .spec(responseSpec)
                .body("size()", Matchers.greaterThan(0));

		/*	.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(3000L));*/


    }


    @Test
    public void getBookingByFirstName() {
        RestAssured.given(requestSpec)
                .queryParam("firstname", "sally")
                .get()
                .then()
                .spec(responseSpec);
			/*.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(3000L));*/


    }
}
