package org.dummyapi.asserions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.requests.PostRequests;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class PostAssertions {

    public static ValidatableResponse assertGivenResponseStatusCode(Response response, int expectedValue){

        return response.then().statusCode(expectedValue);
    }

    public static ValidatableResponse assertGivenPostIsCreated(String id){
        Response response = PostRequests.getPostByID(id);
        return  assertGivenResponseStatusCode(response, 200);
    }

    public static ValidatableResponse assertGivenTextisEqualorLessThan50Char(String id){
        Response response = PostRequests.getPostByID(id);
        return response.then().body("text.size()", lessThanOrEqualTo(50));
    }
}
