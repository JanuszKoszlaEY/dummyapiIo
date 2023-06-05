package org.dummyapi.testTag;

import io.restassured.response.Response;
import org.dummyapi.asserions.TagAssertions;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.endpoints.TagEndpoints;
import org.dummyapi.requests.TagRequests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TagTests {
    @Test
    public void testGetTags_Success() {
        Response response = TagRequests.tag();
        // Assertions
        TagAssertions.assertThanBodySizeGreaterThanZero(response);
        TagAssertions.assertThatResponseCodeIs(response, 200);
    }

    @Test
    public void testGetTags_Unauthorized() {
        Response response = given()
                .spec(RequestConfiguration.get())
                .header("app-id", "INVALID_API_KEY")
                .get(TagEndpoints.tag);

        // Assertions
        TagAssertions.assertThatResponseCodeIs(response, 403);
    }
}
