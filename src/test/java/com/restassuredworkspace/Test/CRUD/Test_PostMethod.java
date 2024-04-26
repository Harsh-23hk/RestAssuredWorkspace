package com.restassuredworkspace.Test.CRUD;


import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Test_PostMethod {

    @Test
    public void test03(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "morpheus");
        jsonData.put("job", "zion resident");

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.given()
                .contentType("application/json")
                .body(jsonData.toString())
                .when().post("/api/users")
                .then().statusCode(201).log().all();



    }


}
