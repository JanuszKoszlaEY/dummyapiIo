package org.dummyapi.asserions;


import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.requests.CommentRequests;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class CommentAsertions {
    public static void assertThatResponseCodeIs(Response response, int expectedValue) {
        response.then().statusCode(expectedValue);
    }

    public static ValidatableResponse assertGivenTextisLonger200Char(String id){
        Response response = CommentRequests.getCommentByUser(id);
        return response.then().body("data[0].message.size()", lessThanOrEqualTo(200));
    }

}
