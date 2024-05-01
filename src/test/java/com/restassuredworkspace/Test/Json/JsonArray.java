package com.restassuredworkspace.Test.Json;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JsonArray {

    @Test
    public void createJsonArrayObj() {
        //create json obj  for user

        JSONObject user1 = new JSONObject();
        user1.put("name", "Ravi");
        user1.put("job", "Admin");
        user1.put("age", 25);

        JSONObject user2 = new JSONObject();
        user2.put("name", "deepak");
        user2.put("job", "HR");
        user2.put("age", 40);


        JSONObject user3 = new JSONObject();
        user3.put("name", "harsh");
        user3.put("job", "Developer");
        user3.put("age", 30);

        JSONArray payload = new JSONArray();
        payload.add(user1);
        payload.add(user2);
        payload.add(user3);

        RequestSpecification  requestSpec = RestAssured.given();
        requestSpec.baseUri("https://reqres.in/").basePath("/api/users");

        requestSpec.contentType("application/json");
        requestSpec.body(payload);
        Response response =requestSpec.post();
        response.prettyPrint();


        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.body().jsonPath().get("name[2]"), "harsh");








    }

}
