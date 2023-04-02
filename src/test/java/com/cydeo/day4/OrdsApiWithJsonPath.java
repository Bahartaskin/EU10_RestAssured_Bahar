package com.cydeo.day4;

import com.cydeo.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdsApiWithJsonPath extends HRTestBase {


    @DisplayName("GET request to Countries")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/countries");

        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);

        List<String> allCountryId = jsonPath.getList("items.country_id");
        System.out.println("allCountryId = " + allCountryId);

        //it-->each
        List<Object> countriesThatRegionIdIs2 = jsonPath.getList("items.findAll {it.region_id==2}.country_name");
        System.out.println("countriesThatRegionIdIs2 = " + countriesThatRegionIdIs2);


    }

    @DisplayName("GET requesto /employees with query param")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("limit", 107)
                .when().get("/employees");

        JsonPath jsonPath = response.jsonPath();

        List<String> emailsOfItProg = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
        System.out.println("emailsOfItProg = " + emailsOfItProg);

        List<String> employeeNames = jsonPath.getList("items.findAll {it.salary>10000}.first_name");
        System.out.println("employeeNames = " + employeeNames);

        String maxSalaryName = jsonPath.getString("items.max {it.salary}.first_name");
        System.out.println("maxSalaryName = " + maxSalaryName);



    }

}
