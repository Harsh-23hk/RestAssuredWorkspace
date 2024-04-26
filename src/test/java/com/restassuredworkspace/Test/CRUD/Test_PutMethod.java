package com.restassuredworkspace.Test.CRUD;

import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PutMethod {

    @Test
    public void test04() {
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Harsh");
        jsonData.put("job", "Automation Tester");


        RestAssured.baseURI = "https://reqres.in/api/users/76";
        RestAssured.given()
                .contentType("application/json")
                .body(jsonData.toString())
                .when().put()
                .then().statusCode(200).log().all();
    }
}
