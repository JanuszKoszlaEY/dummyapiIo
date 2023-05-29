package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.endpoints.CommentEndpoints;

public class ReqComment {
    public static Response commentCreate (CommentDto commentCreate) {
        return RestAssured.given(RequestConfiguration.get().body(commentCreate), ResponseConfiguration.get())
                .post(CommentEndpoints.commentCreate);

    }
    public static Response comment (){
        return RestAssured.given(RequestConfiguration.get(), ResponseConfiguration.get())
                .get(CommentEndpoints.comment);

    }
    public static Response commentByPost (String commentByPost) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,commentByPost), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByPost);

    }
    public static Response commentByUser (String commentByUser) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id" ,commentByUser), ResponseConfiguration.get())
                .get(CommentEndpoints.commentByUser);

    }
    public static Response commentDelete (String commentDelete) {
        return RestAssured.given(RequestConfiguration.get().pathParams( "id", commentDelete), ResponseConfiguration.get())
                .delete(CommentEndpoints.commentDelete);

    }

}