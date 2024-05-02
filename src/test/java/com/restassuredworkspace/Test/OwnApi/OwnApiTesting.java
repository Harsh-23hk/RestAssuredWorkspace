package com.restassuredworkspace.Test.OwnApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OwnApiTesting {

    @BeforeTest
    public void setDefaultMethod() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://localhost:3000").basePath("/users");
        RestAssured.requestSpecification = requestSpecification;

    }

    @Test
    public void readUserData() {

        Response response = RestAssured.get();
        response.prettyPrint();
        response.then().body("name[0]", Matchers.equalTo("Harsh"));

    }


     @Test
    public void createUser() {

        JSONObject userdata = new JSONObject();
        userdata.put("name", "Namish");
        userdata.put("age", 18);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(userdata.toString())
                .post();

        response.prettyPrint();
        response.then().statusCode(Matchers
                .equalTo(201));

    }


}
