package com.restassuredworkspace.Test.JsonArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassuredworkspace.Pojo.Employee;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;



public class JsonArrayObject {

    @Test
    public void createEmployeeJsonArray() throws JsonProcessingException {

        Employee employee = new Employee();
        employee.setName("Harsh");
        employee.setLastName("Kumar");
        employee.setGender("Male");
        employee.setAge(25);
        employee.setSalary(25000.00);

        Employee employee2 = new Employee();
        employee2.setName("Sunil");
        employee2.setLastName("Kumar");
        employee2.setGender("Male");
        employee2.setAge(30);
        employee2.setSalary(30000.00);

        Employee employee3 = new Employee();
        employee3.setName("Karin");
        employee3.setLastName("Sharma");
        employee3.setGender("Female");
        employee3.setAge(230);
        employee3.setSalary(40000.00);


        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(employee);
        employeeList.add(employee2);
        employeeList.add(employee3);







        ObjectMapper objectMapper = new ObjectMapper();

        String payload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);


       RequestSpecification requestSpecification= RestAssured.given().baseUri("https://httpbin.org/post");
        requestSpecification.contentType("application/json");
        requestSpecification.body(payload);
        Response response = requestSpecification.post();
        response.prettyPrint();


        Assert.assertEquals(response.getStatusCode(), 200);






        //Deserialization


        ResponseBody body = response.getBody();
        JsonPath jsonPath = body.jsonPath();
        List<Employee> allEmployees = jsonPath.getList("json", Employee.class);


        for(Employee emp:allEmployees){
            System.out.println(emp.getName());
            System.out.println(emp.getAge());
            System.out.println(emp.getSalary());

        }





    }
}
