package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("ABC xyz");
        userPojo.setEmail("123abc@gmail.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given()
                        .header("Content-Type","application/json")
                        .header("Authorization", "Bearer 6c8869b06b7b02768418648115d359444252b9ba6428f17dd635d20e4f53a072")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void verifyUserUpdateSuccessfully(){

    }
    @Test
    public void getAllCustomersInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteUser() {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 6c8869b06b7b02768418648115d359444252b9ba6428f17dd635d20e4f53a072")

                .when()
                .delete("/users/3828");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
