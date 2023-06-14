package org.dummyapi.asserions;


import io.restassured.response.Response;

public class CommentAsertions {
    public static void assertThatResponseCodeIs(Response response, int expectedValue) {
        response.then().statusCode(expectedValue);
    }


}
