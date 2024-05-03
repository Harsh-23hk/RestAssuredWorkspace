package com.restassuredworkspace.Test.DeserallizeAndSeralize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassuredworkspace.Pojo.Employee;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializeSerialize {

    @Test
    public void createEmployee() throws JsonProcessingException {

        Employee employee=new Employee();
        employee.setName("Harsh");
        employee.setLastName("Kumar");
        employee.setGender("Male");
        employee.setAge(25);
        employee.setSalary(25000.00);


        ObjectMapper objectMapper=new ObjectMapper();
        String Employeejson =objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("http://httpbin.org/post");
        requestSpecification.contentType("application/json");
        requestSpecification.body(Employeejson);
        Response response = requestSpecification.post();

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);




        // convert json to object

       Employee employee1 = objectMapper.readValue(Employeejson, Employee.class); // response.body().as(Employee.class);









    }

}
