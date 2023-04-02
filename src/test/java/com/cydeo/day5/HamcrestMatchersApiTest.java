package com.cydeo.day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

    @Test
    public void simpleTest1(){

       // MatcherAssert.assertThat(5+5, Matchers.is(10));
        //after static import
        assertThat(5+5, is(10));
        assertThat(5+5,equalTo(10));
        assertThat(5+5,is(equalTo(10)));

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(9))));

        assertThat(5+5,is(greaterThan(9)));



    }


    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){

        String text = "EU10 is learning Hamcrest";

        assertThat(text,is("EU10 is learning Hamcrest"));
        assertThat(text,equalTo("EU10 is learning Hamcrest"));
        assertThat(text,is(equalTo("EU10 is learning Hamcrest")));

        assertThat(text,startsWith("EU10"));
        assertThat(text,startsWithIgnoringCase("eu10"));
        assertThat(text,endsWith("rest"));
        assertThat(text,endsWithIgnoringCase("ReSt"));
        assertThat(text,containsString("learning"));
        assertThat(text,containsStringIgnoringCase("leARniNg"));

        String str = "  ";

        assertThat(str,blankString());
        assertThat(str.trim(),emptyString());



    }


    @DisplayName("Hamcrest for Collection")
    @Test
    public void testCollection(){

        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        //check size of the list
        assertThat(listOfNumbers,hasSize(10));
        //check if this list hasItem 77
        assertThat(listOfNumbers,hasItem(77));
        //check if this list hasItems 77,54,23
        assertThat(listOfNumbers,hasItems(77,54,23));

        //check if all numbers greater than 0
        assertThat(listOfNumbers,everyItem(greaterThan(0)));

    }


}
