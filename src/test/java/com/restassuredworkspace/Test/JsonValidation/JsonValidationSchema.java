package com.restassuredworkspace.Test.JsonValidation;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class JsonValidationSchema {

    @Test
    public void testValidationSchema() {

        //https:restful-booker.herokuapp.com/auth

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType("application/json")
                .body(payload)
                .when().post()
                .then()
                .statusCode(200)
                .body("token", Matchers.notNullValue())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"))

                       // matchesJsonSchema(new File("C:\\Users\\Harsh\\Desktop\\schema.json")))
                ;







    }
}
