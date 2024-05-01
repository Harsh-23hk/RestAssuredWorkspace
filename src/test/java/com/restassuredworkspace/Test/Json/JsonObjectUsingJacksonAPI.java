package com.restassuredworkspace.Test.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class JsonObjectUsingJacksonAPI {

    @Test
    public void createUser() throws JsonProcessingException {

		/*{
   "firstName":"Prerna",
   "lastName":"Gupta",
   "age": 28,
   "salary": 10000.56,
   "IsMarried":true,
   "TechSkill":{
		"Programming language":"Java",
		"WebAutomation":"Selenium",
		"API testing" : "Rest Assured"
             }

 }*/
        //create objectMapper class instance
        ObjectMapper objectMapper = new ObjectMapper();

        //create object node i.e json node
        ObjectNode userDetails = objectMapper.createObjectNode();
        userDetails.put("firstName", "Prerna");
        userDetails.put("lastName", "Gupta");
        userDetails.put("age", 28);
        userDetails.put("salary", 10000.56);
        userDetails.put("IsMarried", true);

        //create hobbies array in json node and set values in it using object mapper class instance  convert(from value(),to value )
        userDetails.set("Hobbies", objectMapper.convertValue(Arrays.asList("Cricket", "Football"), JsonNode.class));

        ObjectNode techSkill = objectMapper.createObjectNode();
        techSkill.put("Programming language", "Java");
        techSkill.put("WebAutomation", "Selenium");
        techSkill.put("API testing", "Rest Assured");

        userDetails.replace("TechSkill", techSkill);


        String userDetailsJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(userDetails);
        System.out.println(userDetailsJson);


        //retrieve field value
        String firstName = userDetails.get("firstName").asText();
        Boolean isMarried = userDetails.get("IsMarried").asBoolean();

        String webAutomation = userDetails.get("TechSkill").get("WebAutomation").asText();


        //iterate field names
        Iterator<String> fieldNames = userDetails.fieldNames();
        while (fieldNames.hasNext()) {
            System.out.println(fieldNames.next());
        }

        System.out.println("\n");

        //iterate field Values

        Iterator<JsonNode> fieldValues = userDetails.elements();
        while (fieldValues.hasNext()) {
            System.out.println(fieldValues.next());
        }


        System.out.println("\n");


        //remove field value

        String removedField = userDetails.remove("IsMarried").asText();

        userDetails.put("lastName", "Sharma");

        userDetails.set("TechSkill", techSkill.put("Programming language", "C++"));

        System.out.println("\n");

        Iterator<Map.Entry<String, JsonNode>> fields = userDetails.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
        System.out.println("\n");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users");
        requestSpecification.contentType("application/json");
        requestSpecification.body(userDetails);
        Response response = requestSpecification.post();

        response.prettyPrint();


        //validate

        response.then().body("firstName", Matchers.equalTo("Prerna"));
        response.then().statusCode(Matchers.equalTo(201));


    }
}
