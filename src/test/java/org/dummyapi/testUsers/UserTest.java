package org.dummyapi.testUsers;

import io.restassured.response.Response;
import org.dummyapi.asserions.UserAsertions;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.endpoints.UserEndpoints;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;


public class UserTest {

    private String testUserId = null;
   @BeforeTest
   public void createTestUser(){
       Response response = UserRequests.createUser(UserTestData.getUserDeletableTestData());
       testUserId = response.as(UserDto.class).getId();
   }
   @Test
   public void createUsers(){
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        String id = response.as(UserDto.class).getId();
        UserAsertions.assertThatUserIsCreated(id);
    }
    @Test
    public void getUsers(){
        Response response = UserRequests.getUserList();
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
    Response response = UserRequests.updateUser(testUserId, UserTestData.updateUserTestData());
    UserAsertions.assertThatUserGenderIsMale(testUserId);
    }
    @Test
    public void deleteUser(){
       Response response = UserRequests.deleteUser(testUserId);
       UserAsertions.assertThatUserIsDeleted(testUserId)
    }
    @AfterTest
    public void deleteTestUser(){
        Response response = UserRequests.deleteUser(testUserId);

    }
}
