package com.restassuredworkspace.Test.MockAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

public class DemoTest {

    @Test
    public void getTest() {
        //https://run.mocky.io/v3/f265cc29-7b9f-44ca-a411-1ba8658764a4

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://run.mocky.io/v3/6e4a2277-bcd8-4049-a5f5-4eabc6663bdf");
        Response response = requestSpecification.get();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void test2() {

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://run.mocky.io/v3/6e4a2277-bcd8-4049-a5f5-4eabc6663bdf");
        EMPojo emp = requestSpecification.get().as(EMPojo.class);

        System.out.println("-----------Print after JSON Object to Class Object------------");
        System.out.println("FirstName:" + emp.getFirstname());
        System.out.println("LastName:" + emp.getLastname());
        System.out.println("Gender:" + emp.getGender());
        System.out.println("Age:" + emp.getAge());
        System.out.println("Salary:" + emp.getSalary());
        System.out.println("Is Married:" + emp.isMarried());

        System.out.println("Hobbies:");




        // using for-each loop for iteration over array
        String[] hobbiesStr = emp.getHobbies();
        for (int i = 0; i < hobbiesStr.length; i++) {
            System.out.println(hobbiesStr[i]);
        }


        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String, String> entry : emp.getFamilyMembers().entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }


}


