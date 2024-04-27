package com.restassuredworkspace.Test.Validation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueryParameter {

    @Test
    public void filterData() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://reqres.in/");
        request.basePath("/api/users");
        request.queryParam( "page", "2").queryParam("id",10);
        Response response =request.get();

        String body = response.getBody().asString();

        System.out.println(body);

        JsonPath jsonPath = response.jsonPath();
        String first_name = jsonPath.get("data.first_name");
        Assert.assertEquals( first_name,"Byron","first name should be Byron");



    }
}
