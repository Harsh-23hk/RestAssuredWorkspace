package com.restassuredworkspace.Test.CRUD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_DeleteMethod {

    @Test
    public void Test05() {

        RestAssured.baseURI = "https://reqres.in/api/users/76";

        RestAssured.given()
                .when()
                .delete()
                .then()
                .statusCode(204)
                .log().all();

    }
}
