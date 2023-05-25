package org.dummyapi.testUser;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.dummyapi.converter.JsonConverter;
import org.dummyapi.dataModels.common.CommonListDto;
import org.dummyapi.dataModels.endpoints.User;
import org.dummyapi.dataModels.requestBody.UserDto;
import org.dummyapi.requests.PostRequest;
import org.dummyapi.requests.UserRequest;
import org.dummyapi.testData.PostTestData;
import org.dummyapi.testData.UserTestData;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class UserTest {

    @Test()
    @Ignore
    public void EndToEndUserTest(){
        Response response = UserRequest.createUser(UserTestData.userPostData());
        String id = response.as(UserDto.class).getId();
        response = PostRequest.createPost(PostTestData.postPostData(id));

        response = UserRequest.getUserById((response.as(UserDto.class).getId()));

        Assert.assertFalse(response.getBody().as(UserDto.class).getId().isEmpty(),"Id for generated user is not found");
        response = UserRequest.updateUser(response.as(UserDto.class).getId(),UserTestData.userUpdateData());
        response = UserRequest.getUserById((response.as(UserDto.class).getId()));
        Assert.assertTrue(response.as(UserDto.class).getPicture().contains("change"),"Change is missing in picter field");
        response = UserRequest.deleteUser((response.as(UserDto.class).getId()));
        response = UserRequest.getUserById((response.as(UserDto.class).getId()));
        Integer toVerify = response.getStatusCode();
        Assert.assertFalse(toVerify.equals(HttpStatus.SC_OK),"Status should not be OK. User " + response.as(UserDto.class).getId() + " is not deleted");
    }

    @Test
    public void GetUserListTest(){
        Response response = UserRequest.getUserList();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        List<UserDto> userList = Arrays.asList(JsonConverter.convertFromJson(JsonConverter.convertToJson(response.as(CommonListDto.class).getData()),UserDto[].class));
        Assert.assertFalse(userList.get(0).getId().isEmpty(),"MissingID for first user");
    }
}