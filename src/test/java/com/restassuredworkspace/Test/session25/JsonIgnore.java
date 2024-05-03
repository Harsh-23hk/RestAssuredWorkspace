package com.restassuredworkspace.Test.session25;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;


public class JsonIgnore {

    @Test
    public void testMethod() throws IOException {

        Employee employee = new Employee();
        employee.setName("Himanshu");
        employee.setLastName("Sharma");
        employee.setGender("Male");
        employee.setAge(30);
        employee.setSalary(50000.00);
        employee.setMarried(true);
        employee.setFullname("Himanshu Sharma");

        // conversion of object to JSON string (Serialization)
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);



        //Deserialization
        String payload =
                "{\n" +
                        "  \"name\" : \"Himanshu\",\n" +
                        "  \"lastName\" : \"Sharma\",\n" +
                        "  \"gender\" : \"Male\",\n" +
                        "  \"age\" : 30,\n" +
                        "  \"salary\" : 50000.0,\n" +
                        "  \"fullname\" : \"Himanshu Sharma\",\n" +
                        "  \"married\" : true, \n" +

                        "}";

        Employee employee1 = objectMapper.reader().readValue(payload, Employee.class);

        System.out.println(employee1.getName());
        System.out.println(employee1.getLastName()) ;
        System.out.println(employee1.getFullname());
        System.out.println(employee1.getSalary());
        System.out.println(employee1.getGender());

    }


}
