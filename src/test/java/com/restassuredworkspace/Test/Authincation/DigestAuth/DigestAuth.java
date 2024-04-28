package com.restassuredworkspace.Test.Authincation.DigestAuth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DigestAuth {

    @Test
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
}
