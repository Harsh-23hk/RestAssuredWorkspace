package com.restassuredworkspace.Test.Validation;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseHeader {
    RequestSpecification requestSpecification;


    @Test(description = "singleUser")
    public void singleUser() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("/api/users/2");

        Response response = requestSpecification.get();

        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8", "Content type is not matching");

        Headers headerlist = response.getHeaders();

        for (Header header : headerlist) // for each header in this header-list
        {
            System.out.println(header.getName() + " : " + header.getValue());
        }






    }





}
