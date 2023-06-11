package org.dummyapi.testUsers;

import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.dummyapi.asserions.UserAsertions;
import org.dummyapi.configuration.PropertiesManager;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.endpoints.UserEndpoints;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;


public class UserTest {
    @BeforeTest
    public void
   @Test
   public void createUsers(){
        UserRequests userRequests = new UserRequests();
       RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        Response response = userRequests.createUser(UserTestData.getUserTestData());
        String id = response.as(UserDto.class).getId();
        UserAsertions.assertThatUserIsCreated(id);
    }
    @Test
    public void getUsers(){
        useRelaxedHTTPSValidation();
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
    @Test
    public void updateUser(){

    }
}
