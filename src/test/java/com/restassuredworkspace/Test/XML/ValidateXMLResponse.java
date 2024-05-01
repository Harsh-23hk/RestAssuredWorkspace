package com.restassuredworkspace.Test.XML;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateXMLResponse {


    @Test(enabled = false)
    public void addPet() {

        String xml_data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Pet>\n" +
                "\t<id>0</id>\n" +
                "\t<Category>\n" +
                "\t\t<id>0</id>\n" +
                "\t\t<name>string</name>\n" +
                "\t</Category>\n" +
                "\t<name>doggie</name>\n" +
                "\t<photoUrls>\n" +
                "\t\t<photoUrl>string</photoUrl>\n" +
                "\t</photoUrls>\n" +
                "\t<tags>\n" +
                "\t\t<Tag>\n" +
                "\t\t\t<id>0</id>\n" +
                "\t\t\t<name>string</name>\n" +
                "\t\t</Tag>\n" +
                "\t</tags>\n" +
                "\t<status>available</status>\n" +
                "</Pet>";



        String json_data = "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";


        RequestSpecification request = RestAssured.given();
        request.baseUri("https://petstore.swagger.io").basePath("v2/pet");


        request.header("accept", "application/xml");
        request.header("Content-Type", "application/xml");
        request.body(xml_data);

        Response response = request.post();
        response.prettyPrint();

//       ResponseBody body =response.getBody();
//        System.out.println(body.path("id").toString());

        Assert.assertEquals(response.getStatusCode(), 200);

        response.then().body("Pet.name", Matchers.equalTo("doggie"));

    }

    @Test
    public void gettraveller() {
        RequestSpecification requestSpec = RestAssured.given();

        //http://restapi.adequateshop.com/api/Traveler?page=1
        //specify url
        requestSpec.baseUri("http://restapi.adequateshop.com");
        requestSpec.basePath("/api/Traveler");

        //add query parameter
        requestSpec.queryParam("page", "1");

        //specify header
        requestSpec.header("accept","application/xml");

        //perform get request
        Response response = requestSpec.get();

        response.prettyPrint();


        //Approach 1
        //	response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name", Matchers.equalTo("vano"));

        XmlPath xmlPath = response.xmlPath();
        List listoftraveller =xmlPath.get("TravelerinformationResponse.travelers.Travelerinformation");




    }

}
