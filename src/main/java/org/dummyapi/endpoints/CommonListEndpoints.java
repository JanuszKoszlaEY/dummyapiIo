package org.dummyapi.endpoints;

public interface CommonListEndpoints {

    String listOfUsers = "/user";
    String listOfUserByID = "/user/:id";
    
    String listOfPosts = "/post";
    String listOfPostsByUser = "/user/:id/post";
    String listOfPostsByTag = "/user/:id/post";

    String commentList = "/comment";
    String commentListByPost = "/post/:id/comment";
    String commentListByUser = "/post/:id/comment";

}
