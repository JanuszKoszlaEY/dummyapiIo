package org.dummyapi.testComment;

import io.restassured.response.Response;
import org.dummyapi.asserions.CommentAsertions;
import org.dummyapi.asserions.PostAssertions;
import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.requests.CommentRequests;
import org.dummyapi.requests.PostRequests;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.CommentTestData;
import org.dummyapi.testData.PostTestData;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class CommentTests {
    @Test
    public void getCommentList() {
        useRelaxedHTTPSValidation();
        Response response = CommentRequests.getCommentList();
        CommentAsertions.assertThatResponseCodeIs(response, 200);
    }

    @Test
    public void createComment() {
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        PostDto PostDto = response.as(PostDto.class);

        response = CommentRequests.createComment(CommentTestData.commentPostData(userDto, PostDto));
        String idComment = response.as(CommentDto.class).getId();
        CommentAsertions.assertThatResponseCodeIs(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(PostDto.getId());
        response = CommentRequests.deleteComment(idComment);
    }

    @Test
    public void getCommentByPost() {
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        PostDto PostDto = response.as(PostDto.class);
        String postID = response.as(PostDto.class).getId();

        response = CommentRequests.createComment(CommentTestData.commentPostData(userDto, PostDto));
        String idComment = response.as(CommentDto.class).getId();

        response = CommentRequests.getCommentByPost(postID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(postID);
        response = CommentRequests.deleteComment(idComment);
    }

    @Test
    public void deleteComment() {
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        PostDto PostDto = response.as(PostDto.class);

        response = CommentRequests.createComment(CommentTestData.commentPostData(userDto, PostDto));
        String idComment = response.as(CommentDto.class).getId();
        response = CommentRequests.deleteComment(idComment);
        CommentAsertions.assertThatResponseCodeIs(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(PostDto.getId());


    }

    @Test
    public void checkIfTextIsLongerThen200() {
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);
        String UserID = response.as(UserDto.class).getId();

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        PostDto PostDto = response.as(PostDto.class);

        response = CommentRequests.createComment(CommentTestData.commentPostData(userDto, PostDto));
        String idComment = response.as(CommentDto.class).getId();
        CommentAsertions.assertGivenTextisLonger200Char(UserID);

        response = CommentRequests.deleteComment(idComment);
        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(PostDto.getId());

    }

    @Test
    public void getCommentByUser() {
        useRelaxedHTTPSValidation();
        Response response = UserRequests.createUser(UserTestData.getUserDefaultTestData());
        UserDto userDto = response.as(UserDto.class);
        String UserID = response.as(UserDto.class).getId();

        response = PostRequests.createPost(PostTestData.createPostTestData(userDto));
        PostDto PostDto = response.as(PostDto.class);

        response = CommentRequests.createComment(CommentTestData.commentPostData(userDto, PostDto));
        String idComment = response.as(CommentDto.class).getId();

        response = CommentRequests.getCommentByUser(UserID);
        PostAssertions.assertGivenResponseStatusCode(response, 200);

        response = UserRequests.deleteUser(userDto.getId());
        response = PostRequests.deletePost(UserID);
        response = CommentRequests.deleteComment(idComment);

    }
}