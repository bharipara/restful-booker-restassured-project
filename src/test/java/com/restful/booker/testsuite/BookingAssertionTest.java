package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookingAssertionTest  {


        static ValidatableResponse response;

        @BeforeClass
        public static void inIt() {
            RestAssured.baseURI = "https://restful-booker.herokuapp.com";

            response = given()
                    .when()
                    .get("/booking/704")
                    .then().statusCode(200);
        }


        //1. Verify first name is "Josh"
        @Test
        public void test001() {

            response.body("firstname", equalTo("Josh"));
        }

        //2. Verify last name is "Allen"
        @Test
        public void test002() {

            response.body("lastname", equalTo("Allen"));
        }
        //3. Verify totalprice is 111
        @Test
        public void test003() {

            response.body("totalprice", equalTo(111));
        }
        //4. Verify depositpaid is true
        @Test
        public void test004() {

            response.body("depositpaid", equalTo(true));
        }
        //5. verify "checkin": "2018-01-01",
        @Test
        public void test005() {

            response.body("bookingdates.checkin", equalTo("2018-01-01"));
        }
        //6. verify "checkout": "2019-01-01",
        @Test
        public void test006() {

            response.body("bookingdates.checkout", equalTo("2019-01-01"));
        }
        //7. verify "additionalneeds": "superb owls"
        @Test
        public void test007() {

            response.body("additionalneeds", equalTo("super bowls"));
        }
    }

