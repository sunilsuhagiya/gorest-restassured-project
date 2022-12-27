package com.gorest.utils;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

import java.util.Random;


public class TestUtils {


    public static String getRandomValue() {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
