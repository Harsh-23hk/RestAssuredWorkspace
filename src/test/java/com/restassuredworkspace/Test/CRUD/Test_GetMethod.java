package com.restassuredworkspace.Test.CRUD;


import com.restassuredworkspace.Test.EndPoints.APIConstant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_GetMethod {

    SoftAssert softAssert;


    @Test
    public void BDDStyleTest1() {


        /*Response res = RestAssured.get("https://reqres.in/api/users?page=2");
            System.out.println(res.getStatusCode());
            System.out.println(res.asString());
           System.out.println(res.getHeaders());
            System.out.println(res.getTime());

            int status = res.getStatusCode();

            softAssert.assertEquals(status, 201);*/

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";
        RestAssured.given().queryParams("page", 2)
                .when().get()
                .then().statusCode(200);






    }

    @Test
    public void NonBDDStyleTest2() {
        RequestSpecification req = RestAssured.given();
        req.baseUri(APIConstant.BASE_URL);
        req.basePath(APIConstant.BASE_PATH);
        req.queryParam(APIConstant.QUERY_PARAM);
       Response response = req.when().get(); //response

       ValidatableResponse validatableResponse = response.then(); //validatable response
       validatableResponse.statusCode(200); //assertion






    }


}
