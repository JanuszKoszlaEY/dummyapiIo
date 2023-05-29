package org.dummyapi.endpoints;

public interface CommentEndpoints {

    String comment = "comment";
    String commentByPost = "post/{id}/comment";
    String commentByUser = "user/{id}/comment";
    String commentCreate = "comment/create";
    String commentDelete = "comment/{id}";
}
