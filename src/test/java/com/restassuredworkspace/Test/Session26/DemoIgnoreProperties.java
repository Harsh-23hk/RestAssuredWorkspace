package com.restassuredworkspace.Test.Session26;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassuredworkspace.Test.session25.Employee;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemoIgnoreProperties {

    @Test
    public void test() throws IOException {

        String payload =
                "{\n" +
                        "  \"name\" : \"Himanshu\",\n" +
                        "  \"lastName\" : \"Sharma\",\n" +
                        "  \"gender\" : \"Male\",\n" +
                        "  \"age\" : 30,\n" +
                        "  \"salary\" : 50000.0,\n" +
                        "  \"fullname\" : \"Himanshu Sharma\",\n" +
                        "  \"married\" : true ,\n" +
                        "  \"phone\" : 86784684454\n" +
                        "}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Employee employee1 = objectMapper.readValue(payload, Employee.class);

        System.out.println(employee1.getName());
        System.out.println(employee1.getLastName());
        System.out.println(employee1.getFullname());
        System.out.println(employee1.getSalary());
        System.out.println(employee1.getGender());

        System.out.println(employee1.isMarried());


    }
}
