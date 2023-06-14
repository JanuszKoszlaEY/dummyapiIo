package org.dummyapi.testPost;

import io.restassured.response.Response;
import org.dummyapi.asserions.PostAssertions;
import org.dummyapi.requests.PostRequests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class PostTests {

    @Test
    public void testGetPostListPositive(){
        useRelaxedHTTPSValidation();
        Response response = PostRequests.getPost();

        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }
}
