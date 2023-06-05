package org.dummyapi.asserions;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TagAssertions {
    public static void assertThatResponseCodeIs(Response response, int expectedValue){
        response.then().statusCode(expectedValue);
    }

    public static void assertThanBodySizeGreaterThanZero(Response response) {
        response.then().body("data", hasSize(greaterThan(0)));
    }
}
