package com.restassuredworkspace.Test.Authincation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Authincation {

    @Test(enabled = false, description = "basic auth", groups = "Auth")
    public void basicAuth() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://postman-echo.com");
        request.basePath("/basic-auth");

        //non-prempetive request
        //request.auth().basic("postman", "password");

        //prempetive request
        request.auth().preemptive().basic("postman", "password");
        Response response = request.get();

        System.out.println(response.getStatusLine());


    }

    @Test(enabled = false, description = "digest auth", groups = "Auth")
    public void digestAuth() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://httpbin.org");
        request.basePath("/digest-auth/undefined/harsh/path");


        Response response = request.auth().digest("harsh", "path").get();
        //Response response = request.get();

        Assert.assertEquals(response.getStatusCode(), 200);

//        System.out.println(response.getStatusLine());
//        System.out.println(response.body().asString());


    }

    @Test(enabled = false)
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

    @Test
    public void getWeather() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://api.openweathermap.org").basePath("/data/2.5/weather");
        request.queryParam("q", "New Delhi").queryParam("appid", "90bf8ee87653f96637096b6fc0e77811");
        Response response=request.get();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.body().asString());




    }






}
