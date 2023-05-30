package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.PostDto;
import org.dummyapi.endpoints.PostEndpoints;

public class PostRequests {

    public static Response createPost (PostDto postDto){

        return RestAssured.given(RequestConfiguration.get().body(postDto), ResponseConfiguration.get())
                .get(PostEndpoints.postCreate);
    }

    public static Response updatePost (String postID, String bodyRequest){

        return RestAssured.given(RequestConfiguration.get().pathParam("id", postID).body(bodyRequest), ResponseConfiguration.get())
                .put(PostEndpoints.postByID);
    }

    public static Response getPost(){

        return RestAssured.given(RequestConfiguration.get(), ResponseConfiguration.get())
                .get(PostEndpoints.post);
    }

    public static Response getPostByUser(String userID){

        return RestAssured.given(RequestConfiguration.get().pathParam("id", userID), ResponseConfiguration.get())
                .get(PostEndpoints.postByUser);
    }

    public static Response getPostByTag(String tagID){

        return RestAssured.given(RequestConfiguration.get().pathParam("id", tagID), ResponseConfiguration.get())
                .get(PostEndpoints.postByTagID);
    }

    public static Response deletePost (String postID){

        return RestAssured.given(RequestConfiguration.get().pathParam("id", postID), ResponseConfiguration.get())
                .delete(PostEndpoints.postByID);
    }

}

