package org.dummyapi.testComment;

import io.restassured.response.Response;
import org.dummyapi.asserions.CommentAsertions;
import org.dummyapi.asserions.UserAsertions;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.endpoints.CommentEndpoints;
import org.dummyapi.requests.CommentRequests;
import org.dummyapi.requests.PostRequests;
import org.dummyapi.requests.UserRequests;
import org.dummyapi.testData.CommentTestData;
import org.dummyapi.testData.PostTestData;
import org.dummyapi.testData.UserTestData;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
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
        String idUser = response.as(UserDto.class).getId();

        response = PostRequests.createPost(PostTestData.getPostTestData());
        String idPost = response.as(PostDto.class).getId();

        response = CommentRequests.createComment(CommentTestData.commentPostData());
        String idComment = response.as(CommentDto.class).getId();
        CommentAsertions.assertThatResponseCodeIs(response, 200);

        CommentRequests.deleteComment(idComment);
        PostRequests.deletePost(idPost);
        UserRequests.deleteUser(idUser);
    }
    @Test
    public void getCommentFailed() {
        useRelaxedHTTPSValidation();
        Response response = given()
                .spec(RequestConfiguration.get())
                .header("app-id", "INVALID_API_KEY")
                .get(CommentEndpoints.comment);

        UserAsertions.assertThatResponseCodeIs(response, 403);
    }
}

