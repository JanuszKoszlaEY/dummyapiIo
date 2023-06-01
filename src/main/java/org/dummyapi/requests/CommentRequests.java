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
    public static Response getCommentByPost (String id) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,id), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByPost);

    }
    public static Response getCommentByUser (String id) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,id), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByUser);

    }
    public static Response deleteComment (String id) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id", id), ResponseConfiguration.get())
                .delete(CommentEndpoints.commentDelete);

    }

}