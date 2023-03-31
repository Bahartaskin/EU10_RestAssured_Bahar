package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {

    String baseUrl = "http://52.204.187.175:8000";

    @Test
    public void test1(){

//    Given accept type application/json
//    When user send GET request to api/spartans end point
//    Then status code must 200
//    And response Content Type must be application/json
//    And response body should include spartan result

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.contentType(),"application/json");

    }

    @DisplayName("GET one spartan /api/spartans/3 and verify")
    @Test
    public void test2(){

        /*
        Given accept header is application/json
        When users sends a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json
        and json body should contain Fidole
     */

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl + "/api/spartans/3");

        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.contentType(),"application/json");
        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }


    @DisplayName("GET request to /api/hello")
    @Test
    public void test3(){

        /*
        Given no headers provided
        When Users send GET request to /api/hello
        Then response status code should be 200
        And Content type header should be “text/plain;charset=UTF-8”
        And header should contain date
        And Content-Length should be 17
        And body should be “Hello from Sparta"
        */


        Response response = RestAssured.when().get(baseUrl + "/api/hello");
        Assertions.assertEquals(response.statusCode(),200);
        Assertions.assertEquals(response.contentType(),"text/plain;charset=UTF-8");
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        Assertions.assertEquals("17",response.header("Content-Length"));
        Assertions.assertEquals(response.body().asString(),"Hello from Sparta");


    }

}
//ctrl+click --> shortcut for see the method's details
