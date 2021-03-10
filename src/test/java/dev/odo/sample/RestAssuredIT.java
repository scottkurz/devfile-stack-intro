package dev.odo.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.RestAssured;

public class RestAssuredIT {

    Logger logger = LoggerFactory.getLogger(RestAssuredIT.class);
    private String expectedGreeting = "Hello! Welcome to Open Liberty";

    @BeforeAll
    public static void init() {
       RestAssured.baseURI = "http://localhost";
       RestAssured.port = 9080;
    }

    @AfterAll
    public static void destroy() throws Exception {
        RestAssured.reset();
    }

    @Test
    public void testRA() {
    	given().log().all().
        when().
        	get("/api/resource").
        then().
        	body(equalTo(expectedGreeting)).
        	statusCode(200);
    }
}
