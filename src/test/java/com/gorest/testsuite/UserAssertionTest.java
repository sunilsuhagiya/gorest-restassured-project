package com.gorest.testsuite;


import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

    // 1. Verify the if the total record is 20
    @Test
    public void test001() {
        response.body("id", equalTo(10));
    }

    // 2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
    @Test
    public void test002() {
        response.body("[2].name", equalTo("Shakti Prajapat CPA"));
    }

    // 3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003() {
        response.body("[4].name", equalTo("Mohinder Dutta"));
    }

    //  4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void test004() {
        response.body("[3].name", equalTo("Amish Mehrotra I"))
                .body("[0].name", equalTo("Bankim Saini Jr."))
                .body("[5].name", equalTo("Pres. Amrita Pothuvaal"));

    }

    //  5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005() {
        response.body("[7].email", equalTo("balgopal_verma@kiehn.biz"));
    }

    //  6. Verify the status is “Active” of user name is “Balgopal Verma”
    @Test
    public void test006() {
        response.body("[7].status", equalTo("active"));
    }

    //  7. Verify the Gender = male of user name is “Jagmeet Kaniyar"
    @Test
    public void test007() {
        response.body("[6].gender", equalTo("male"));
    }
}