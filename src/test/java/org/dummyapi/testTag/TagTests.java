package org.dummyapi.testTag;

import io.restassured.response.Response;
import org.dummyapi.configuration.PropertiesManager;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.endpoints.TagEndpoints;
import org.dummyapi.requests.TagReq;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TagTests {

    @BeforeTest
    public static void setup() {
        PropertiesManager.loadProperties();
    }

    @Test
    public void testGetTags_Success() {
        Response response = TagReq.tag();
        // Assertions
        response.then()
                .statusCode(200)
                .body("data", hasSize(greaterThan(0)));
    }

    @Test
    public void testGetTags_Unauthorized() {
        Response response = given()
                .spec(RequestConfiguration.get())
                .header("app-id", "INVALID_API_KEY")
                .get(TagEndpoints.tag);

        // Assertions
        response.then()
                .statusCode(403);
    }
}
