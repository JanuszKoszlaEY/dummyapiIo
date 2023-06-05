package org.dummyapi.testTag;

import io.restassured.response.Response;
import org.dummyapi.asserions.TagAssertions;
import org.dummyapi.configuration.PropertiesManager;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.endpoints.TagEndpoints;
import org.dummyapi.requests.TagRequests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TagTests {
    @Test
    public void testGetTags_Success() {
        Response response = TagRequests.tag();
        // Assertions
        response.then()
                .body("data", hasSize(greaterThan(0)));
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
