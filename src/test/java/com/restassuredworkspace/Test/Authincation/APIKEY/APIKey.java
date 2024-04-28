package com.restassuredworkspace.Test.Authincation.APIKEY;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIKey {

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
