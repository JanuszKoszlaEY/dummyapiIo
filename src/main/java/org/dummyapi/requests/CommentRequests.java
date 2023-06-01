package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.endpoints.CommentEndpoints;

public class CommentRequests {
    public static Response createComment (CommentDto CommentDto) {
        return RestAssured.given(RequestConfiguration.get().body(CommentDto), ResponseConfiguration.get())
                .post(CommentEndpoints.commentCreate);

    }
    public static Response getCommentList (){
        return RestAssured.given(RequestConfiguration.get(), ResponseConfiguration.get())
                .get(CommentEndpoints.comment);

    }
    public static Response getCommentByPost (String postId) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,postId), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByPost);

    }
    public static Response getCommentByUser (String userId) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,userId), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByUser);

    }
    public static Response deleteComment (String commentId) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id", commentId), ResponseConfiguration.get())
                .delete(CommentEndpoints.commentDelete);

    }

}