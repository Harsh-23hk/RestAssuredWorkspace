package com.restassuredworkspace.Test.Authincation.Oauth;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class OAuth {
    static String accessToken = null;


    @Test(enabled = false)
    public void oauth() {

        RequestSpecification request = RestAssured.given();

        request.auth().preemptive().basic(client_Id, client_secret)
                .param("grant_type", "client_credentials");

        Response response = request.post();


        response.prettyPrint();

        accessToken = response.getBody().path("access_token");

        System.out.println(accessToken);
        System.out.println("-------------------------");

    }

    @Test(dependsOnMethods = "oauth")
    public void getAccessToken() {
        RequestSpecification request = RestAssured.given();

        Response response = request.auth().oauth2(accessToken)
                .queryParam("page", 3)
                .queryParam("page_size", 4)
                .queryParam("total_count_required", true)


        response.prettyPrint();


    }
}
