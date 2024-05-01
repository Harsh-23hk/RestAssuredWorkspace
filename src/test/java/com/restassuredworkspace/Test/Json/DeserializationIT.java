package com.restassuredworkspace.Test.Json;

import com.restassuredworkspace.Pojo.JsonPostResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationIT {

    @Test
    public void createUser() {

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://reqres.in")
                .basePath("/api/users");

        JSONObject json = new JSONObject();
        json.put("name", "Bhavesh");
        json.put("job", "QA");


        request.contentType(ContentType.JSON);
        request.body(json.toJSONString());

        Response response = request.post();
        ResponseBody responseBody = response.getBody();

        JsonPostResponse jsonPostResponse = responseBody.as(JsonPostResponse.class);//Deserialization of JSON to Java POJO class (JsonPostResponse)

        Assert.assertEquals(jsonPostResponse.getName(), "Bhavesh", "Name is not matching");
        Assert.assertEquals(jsonPostResponse.getJob(), "QA", "Job is not matching");


    }


}
