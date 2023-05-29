package org.dummyapi.endpoints;

public interface PostEndpoints {

    String post = "post";
    String postByUser = "user/{id}/post";
    String postByTagID = "tag/{id}/post";
    String postByID = "post/{id}";
    String postCreate = "post/create";
}
