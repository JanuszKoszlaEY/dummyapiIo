package org.dummyapi.testUsers;

import com.google.gson.JsonParser;
import io.restassured.response.Response;
import org.dummyapi.asserions.UserAsertions;
import org.dummyapi.configuration.PropertiesManager;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.endpoints.UserEndpoints;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class UserTest {
    @BeforeTest
    public static void setup() {
        PropertiesManager.loadProperties();
    }
   @Test
   public void createUsers(){
        UserRequests userRequests = new UserRequests();
        Response response = userRequests.createUser(UserTestData.getUserTestData());

        JsonParser jsonParser = new JsonParser();
        String id = jsonParser.parseString(response.body().toString()).getAsJsonObject().get("id").getAsString();

        UserAsertions.assertThatUserIsCreated(id);
    }
    @Test
    public void getUsers(){
        UserRequests userRequests = new UserRequests();
        Response response = userRequests.getUserList();
        UserAsertions.assertThatResponseCodeIs(response, 200);
    }
    @Test
    public void getUsersFailed() {
        Response response = given()
                .spec(RequestConfiguration.get())
                .header("app-id", "INVALID_API_KEY")
                .get(UserEndpoints.user);

        UserAsertions.assertThatResponseCodeIs(response, 403);
    }
}
