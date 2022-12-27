package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UserExtractionTest {
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
    //    1. Extract  All the Ids
    @Test
    public void test01() {
        List<Object> ids = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " +ids );
        System.out.println("------------------End of Test---------------------------");

    }

    //    2. Extract the all Names
    @Test
    public void test02() {
        List<String> names = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of names are : " +names );
        System.out.println("------------------End of Test---------------------------");
    }

    //    3. Extract the name of 5th object
    @Test
    public void test03() {
        String name = response.extract().path("[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of 5th object is : " +name );
        System.out.println("------------------End of Test---------------------------");
    }

    //    4. Extract the names of all object whose status = inactive
    @Test
    public void test04() {
        List<String> inactiveNames = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Names that are inactive is : " +inactiveNames );
        System.out.println("------------------End of Test---------------------------");
    }

    //    5. Extract the gender of all the object whose status = active
    @Test
    public void test05() {
        List<String> gender = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Names that are inactive is : " +gender );
        System.out.println("------------------End of Test---------------------------");
    }

    //    6. Print the names of the object whose gender = female
    @Test
    public void test06() {
        List<String> female = response.extract().path("findAll{it.gender=='female'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Names of the object whose gender = female is : " +female );
        System.out.println("------------------End of Test---------------------------");
    }

    //    7. Get all the emails of the object where status = inactive
    @Test
    public void test07() {
        List<Object> email = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List all the emails of the object where status = inactive is : " +email );
        System.out.println("------------------End of Test---------------------------");
    }

    //    8. Get the ids of the object where gender = male
    @Test
    public void test08() {
        List<Object> allIds = response.extract().path("findAll{it.gender=='male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List all the emails of the object where status = inactive is : " +allIds );
        System.out.println("------------------End of Test---------------------------");
    }

    //    9. Get all the status
    @Test
    public void test09() {
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List all the status are : " +status );
        System.out.println("------------------End of Test---------------------------");
    }

    //    10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test10() {
        List<Object> getEmail = response.extract().path("findAll{it.name=='Mr. Kamalesh Jain'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get email of Mr. Kamalesh Jain is : " +getEmail );
        System.out.println("------------------End of Test---------------------------");
    }

    //    11. Get gender of id = 5471
    @Test
    public void test11() {
        List<?> getGender = response.extract().path("findAll{it.id=='5327'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get gender of id 5327 is : " +getGender );
        System.out.println("------------------End of Test---------------------------");
    }

}
