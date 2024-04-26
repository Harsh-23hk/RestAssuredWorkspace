package com.restassuredworkspace.Test.Validation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckValidResponse {
    @Test(description = "Check Valid Response")
    public void test05() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        RequestSpecification request = RestAssured.given();

        Response response = request.get();

       int status = response.getStatusCode();

        SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(status, 200);



    }



    @Test(enabled = false, description = "Check Valid Response")
    public void test06() {

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        RequestSpecification request = RestAssured.given();

       Response response = request.get();

      ValidatableResponse validateResponse = response.then();
      validateResponse.statusCode(200);
        System.out.println("passed");
      validateResponse.statusLine("HTTP/1.1 200 OK");


    }

@Test(description = "Check Valid Response")
    public void test07BDDStyle() {
        RestAssured.given()
                .when().get("https://reqres.in/api/users/2")
                .then().statusLine("HTTP/1.1 200 OK");
    }

}
