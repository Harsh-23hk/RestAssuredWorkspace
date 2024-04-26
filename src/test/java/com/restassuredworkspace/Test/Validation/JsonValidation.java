package com.restassuredworkspace.Test.Validation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonValidation {

    @Test()
    public void validateJson() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://reqres.in");
        request.basePath("/api/users?page=2");
        Response response = request.get();
        ResponseBody body = response.getBody();
        String Response_String = body.asString();
        //System.out.println(Response_String);

        //Assert.assertEquals(Response_String.contains("morpheus"),true,"Name not matched");


        //jsonpath view of responsebody
        JsonPath jsonPath = body.jsonPath();
        //x.data[4].first_name
        String first_name = jsonPath.get("data[0].first_name");
        Assert.assertEquals(first_name, "George", "Check for presence of first name george");

        String avatar = jsonPath.get("data[2].avatar");
        Assert.assertEquals(avatar, "https://reqres.in/img/faces/3-image.jpg", "Check for presence of avatar");


    }
}
