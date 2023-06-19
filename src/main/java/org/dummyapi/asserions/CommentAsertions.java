package org.dummyapi.asserions;


import io.restassured.response.Response;
import org.dummyapi.requests.CommentRequests;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class CommentAsertions {
    public static void assertThatResponseCodeIs(Response response, int expectedValue) {
        response.then().statusCode(expectedValue);
    }

    public static void assertGivenTextisLonger200Char(String id){
        Response response = CommentRequests.getCommentByUser(id);
        response.then().body("message.size()", lessThanOrEqualTo(200));
    }

}
