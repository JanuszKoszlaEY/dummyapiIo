package org.dummyapi.requests;

import io.restassured.response.Response;
import org.dummyapi.configuration.RequestSpec;
import org.dummyapi.configuration.ResponseSpec;
import org.dummyapi.dataModels.endpoints.Post;
import org.dummyapi.dataModels.requestBody.PostDto;
import static io.restassured.RestAssured.given;

public class PostRequest {
    public static Response createPost(PostDto body) {
        return given(RequestSpec.get().body(body), ResponseSpec.get())
                .post(Post.postCreate);
    }

    public static Response updatePost(String id, PostDto body) {
        return given(RequestSpec.get().pathParam("id",id).body(body), ResponseSpec.get())
                .put(Post.postById);
    }

    public static Response deletePost(String id) {
        return given(RequestSpec.get().pathParam("id",id), ResponseSpec.get())
                .delete(Post.postById);
    }

    public static Response getPostById(String id) {
        return given(RequestSpec.get().pathParam("id",id), ResponseSpec.get())
                .get(Post.postById);
    }

    public static Response getPostList() {
        return given(RequestSpec.get(), ResponseSpec.get())
                .get(Post.post);
    }

}
