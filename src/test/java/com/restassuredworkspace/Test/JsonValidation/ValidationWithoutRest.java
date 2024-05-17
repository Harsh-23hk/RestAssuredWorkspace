package com.restassuredworkspace.Test.JsonValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidationWithoutRest {


    @Test
    public void testMethod(){

        String json = "{\r\n"
                + "        \"id\": 2,\r\n"
                + "        \"email\": \"janet.weaver@reqres.in\",\r\n"
                + "        \"first_name\": \"Janet\",\r\n"
                + "        \"last_name\": \"Weaver\"\r\n"
                + "}";

        MatcherAssert.assertThat(json, JsonSchemaValidator.matchesJsonSchemaInClasspath("EmpSchema.json"));





    }
}
