package com.restassuredworkspace.Test.Authincation.BearerToken;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BearerToken {

    @Test
    public void bearerToken() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://gorest.co.in");
        request.basePath("/public/v2/users");
        JSONObject payload = new JSONObject();
        payload.put("name", "ABIONkumar");
        payload.put("gender", "male");
        payload.put("status", "active");
        payload.put("email", "ApF4S@example.com");
        String token = "Bearer 2a4e45bf207c20cc6f887baa6376dbbfc69e5d232118c6456ea7997fffc6af40";

        request.header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(payload.toJSONString());
        Response response = request.post();
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");


    }
}
