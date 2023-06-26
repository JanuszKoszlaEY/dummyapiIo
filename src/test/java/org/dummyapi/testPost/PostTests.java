package org.dummyapi.testPost;

import io.restassured.response.Response;
import org.dummyapi.asserions.PostAssertions;
import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.requests.PostRequests;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.PostTestData;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class PostTests {

    private String testPostID = null;
    private UserDto userDto = null;

    @BeforeTest
    public void createTestUserForTests(){
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        userDto = response.as(UserDto.class);
        System.out.println("User with ID: " + userDto.getId() + " has been created!");
    }

    @Test
    public void testGetPostListPositive(){
        Response response = PostRequests.getPost();
        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @Test
    public void createTestPost(){

        Response response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();
        PostAssertions.assertGivenPostIsCreated(testPostID);

    }

    @Test
    public void checkIfTextHas50CharInTestPost(){
        Response response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();
        PostAssertions.assertGivenTextisEqualorLessThan50Char(testPostID);
    }

    @Test
    public void checkIfTextHasMoreThan50CharInTestPost(){
        Response response = PostRequests.createPost(PostTestData.createIncorrectPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();
        PostAssertions.assertGivenTextisEqualorLessThan50Char(testPostID);
    }

    @Test
    public void getTestPostByID(){
        Response response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();

        response = PostRequests.getPostByID(testPostID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @Test
    public void deleteTestPost(){
        Response response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();

        response = PostRequests.deletePost(testPostID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @Test
    public void updateCreatedTestPost(){
        Response response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        testPostID = response.as(PostDto.class).getId();

        response = PostRequests.updatePost(testPostID, PostTestData.updatePostTestData(userDto));
        PostAssertions.assertGivenResponseStatusCode(response, 200);
    }

    @AfterTest
    public void cleanAfterTests(){
        UserRequests.deleteUser(userDto.getId());
        PostRequests.deletePost(testPostID);
        System.out.println("User with ID: " + userDto.getId() + " has been deleted!");
        System.out.println("Post with ID: " + testPostID + " has been deleted!");
    }
}
