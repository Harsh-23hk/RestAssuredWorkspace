package com.restassuredworkspace.Test.Authincation.BasicAuth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class BasicAuth {

    @Test
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












}
