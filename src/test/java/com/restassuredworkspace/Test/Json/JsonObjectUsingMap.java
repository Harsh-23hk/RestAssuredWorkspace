package com.restassuredworkspace.Test.Json;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonObjectUsingMap {

    @Test
    public void getAuthToken() {
        //https://restful-booker.herokuapp.com/auth

        Map<String, String> AUTH_DATA= new HashMap<>();
        AUTH_DATA.put("username", "admin");
        AUTH_DATA.put("password", "password123");


        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://restful-booker.herokuapp.com");
        requestSpec.basePath("/auth");
        requestSpec.contentType("application/json");
        requestSpec.body(AUTH_DATA);
        Response response = requestSpec.post();
        ResponseBody body = response.getBody();
        String token = body.asString();

        System.out.println("token is "+token);






    }
}
