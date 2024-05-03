package com.restassuredworkspace.Test.Annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoJsonInclude {



    @Test
    public void testMethod() throws JsonProcessingException {

        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("Himanshu");
//        employeePojo.setLastName("Sharma");
        employeePojo.setGender("Male");
        employeePojo.setAge(30);
//        employeePojo.setSalary(50000.00);
        employeePojo.setMarried(true);

        String hobbies[] = new String[2];
        hobbies[0] = "Cricket";
        hobbies[1] = "Football";
        employeePojo.setHobbies(hobbies);

        List<String> degrees = new ArrayList<String>();
        degrees.add("B.Tech");
        degrees.add("M.Tech");
        employeePojo.setDegrees(degrees);

        Map<String, String> familymembers = new HashMap<String, String>();
        familymembers.put("father", "Harsh");
        familymembers.put("mother", "Rashmi");
        familymembers.put("brother", "Himanshu");
        familymembers.put("sister", "Riya");
        employeePojo.setFamilymembers(familymembers);



        ObjectMapper objectMapper = new ObjectMapper();
        String EmployeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojo);

        System.out.println( EmployeeJson );


//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri();
//        requestSpecification.contentType("application/json");
//        requestSpecification.body(Employee);


    }

}
