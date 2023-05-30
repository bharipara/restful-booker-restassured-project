package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingCRUDTest extends TestBase {

    static String firstname = "Sally" + TestUtils.getRandomValue();
    static String lastname = "Brown" +TestUtils.getRandomValue();
    static int totalprice = 111;
    static boolean depositpaid = true;
    static List<Integer> bookingdates;
//    static int checkin = 2013 - 02 - 23;
//    static int checkout = 2014 - 10 - 23;
    static String additionalneeds = "Breakfast";
    static String username = "admin";
    static String password = "password123";

    static int id;

    @Test
public void test001(){

            BookingPojo bookingPojo = new BookingPojo();
            bookingPojo.setUsername(username);
            bookingPojo.setPassword(password);
            Response response = given()
                    .header("Content-Type", "application/json")
                    .header("Connection", "keep-alive")
                    .when()
                    .body(bookingPojo)
                    .post("https://restful-booker.herokuapp.com/auth");
            response.then().log().all().statusCode(200);

        }

    @Test
    public void test002() {

        BookingPojo.Bookingdates date = new BookingPojo.Bookingdates();
        date.setCheckin("2023-10-05");
        date.setCheckout("2023-10-06");
        BookingPojo bookingPojo =new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setAdditionalneeds(additionalneeds);
        bookingPojo.setBookingdates(date);
        Response response = given()
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .auth().preemptive().basic("username", "password")
                .when()
                .body(bookingPojo)
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);

    }
    @Test
    public void test003() {
        String s1 = "findAll{it.firstname == '";
        String s2 = "'}.get(0)";
        Response response= given()
   //        HashMap<String, Object> productMap = given()
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .auth().preemptive().basic("username", "password")
                .when()
               // .pathParam("id", 487)
                .get("/booking/1833");
        response.then().statusCode(200);


    }

    @Test
    public void test004() {
        BookingPojo bookingPojo =new BookingPojo();
        bookingPojo.setTotalprice(200);
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Connection","keep-alive")
                .header("Cookie","token=abc123")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .body(bookingPojo)
                .patch("/booking/16");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void test005() {
        given()
                .header("Content-Type", "application/json")
                .header("Connection","keep-alive")
                .header("Cookie","token=abc123")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete("/booking/16")
                .then()
                .statusCode(201);



    }
}
