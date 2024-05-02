package com.restassuredworkspace.Test.FileUpload;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadIT {

    @Test
    public void fileUpload() {

        File file=new File("C:\\Users\\Harsh\\Desktop\\Hello.txt");

        RequestSpecification request = RestAssured.given();
        request.baseUri("http://httpbin.org/post");
        request.multiPart("file",file);
        request.contentType("multipart/form-data");
        Response response= request.post();
        response.prettyPrint();


        response.then().statusCode(Matchers.equalTo(200));

    }
    @Test
    public void imageUpload() {

        ///pet/{petId}/uploadImage
        File testFileUpload = new File("C:\\Users\\Harsh\\Downloads\\Capture.PNG");

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://petstore.swagger.io/v2/pet/160/uploadImage");
        request.multiPart("file",testFileUpload);
        request.contentType("multipart/form-data");
        Response response= request.post();
        response.prettyPrint();


    }
}
