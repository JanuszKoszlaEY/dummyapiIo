package org.dummyapi.testPost;

import io.restassured.response.Response;
import org.dummyapi.asserions.PostAssertions;
import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.requests.PostRequests;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.PostTestData;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class PostTests {

    @Test
    public void testGetPostListPositive(){
        useRelaxedHTTPSValidation();
        Response response = PostRequests.getPost();

        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @Test
    public void createTestPost(){
        useRelaxedHTTPSValidation();

        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        String postID = response.as(PostDto.class).getId();

        PostAssertions.assertGivenPostIsCreated(postID);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(postID);
    }

    @Test
    public void checkIfTextHas50CharInTestPost(){
        useRelaxedHTTPSValidation();

        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        String postID = response.as(PostDto.class).getId();

        PostAssertions.assertGivenTextisEqualorLessThan50Char(postID);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(postID);
    }

    @Test
    public void getTestPostByID(){
        useRelaxedHTTPSValidation();

        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        String postID = response.as(PostDto.class).getId();

        response = PostRequests.getPostByID(postID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(postID);
    }

    @Test
    public void deleteTestPost(){
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        String postID = response.as(PostDto.class).getId();

        response = PostRequests.deletePost(postID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @Test
    public void updateCreatedTestPost(){
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        String postID = response.as(PostDto.class).getId();

        response = PostRequests.updatePost(postID, PostTestData.updatePostTestData(userDto));
        PostAssertions.assertGivenResponseStatusCode(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(postID);
    }

}
