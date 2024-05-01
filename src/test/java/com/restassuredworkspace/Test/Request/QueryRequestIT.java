package com.restassuredworkspace.Test.Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestIT {

    @Test
    public void createUser() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://reqres.in")
                .basePath("/api/users");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nitin");
        jsonObject.put("job", "SuperVisor");

        request.contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .post();


        //Query data from request specification
        QueryableRequestSpecification query =SpecificationQuerier.query(request);
        System.out.println(query.getBaseUri());

       Headers headers =query.getHeaders();
       for (Header header : headers) {
           System.out.println(header);
       }






    }
}
