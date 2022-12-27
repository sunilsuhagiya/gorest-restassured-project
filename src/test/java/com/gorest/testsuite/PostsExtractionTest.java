package com.gorest.testsuite;

import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .get("https://gorest.co.in/public/v2/posts?page=1&per_page=25%27")
                .then()
                .statusCode(200);
    }

    //    1. Extract the title
    @Test
    public void test01() {
        List<String> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of title is : " + title);
        System.out.println("------------------End of Test---------------------------");

    }

    //    2. Extract the total number of record
    @Test
    public void test02() {
        List<Object> totalRecord = response.extract().path("record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + totalRecord.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //    3. Extract the body of 15th record
    @Test
    public void test03() {
        String body = response.extract().path("[14].body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The body of 15th record is : " + body);
        System.out.println("------------------End of Test---------------------------");
    }

    //    4. Extract the user_id of all the records
    @Test
    public void test04() {
        List<Object> userId = response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The user_id of all the records are : " + userId);
        System.out.println("------------------End of Test---------------------------");
    }

    //    5. Extract the title of all the records
    @Test
    public void test05() {
        List<String> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The title of all the records are : " + title);
        System.out.println("------------------End of Test---------------------------");
    }

    //    6. Extract the title of all records whose user_id = 5456
    @Test
    public void test06() {
        String id = response.extract().path("find{it.user_id == 5431}.title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The title of all the records whose user_id = 5456 are : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //    7. Extract the body of all records whose id = 2671
    @Test
    public void test07() {
        List<String> body = response.extract().path("findAll{it.id == 2731}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The body of all records whose id = 2614 are : " + body);
        System.out.println("------------------End of Test---------------------------");
    }

}
