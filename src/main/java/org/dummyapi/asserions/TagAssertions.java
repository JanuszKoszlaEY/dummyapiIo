package org.dummyapi.asserions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.requests.TagRequests;

public class TagAssertions {
    public static ValidatableResponse assertThatResponseCodeIs(Response response, int expectedValue){
        return response.then().statusCode(expectedValue);
    }
}
