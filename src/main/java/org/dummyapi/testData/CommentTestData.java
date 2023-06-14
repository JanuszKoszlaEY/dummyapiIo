package org.dummyapi.testData;

import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.dataModels.PostDto;
public class CommentTestData {
    public static CommentDto commentPostData(String userId, String postId) {
        return CommentDto.builder()
                .message("Test 123 message!")
                .owner(UserDto.builder()
                        .id(userId)
                        .build()
                .post(PostDto.builder()
                        .id(postId)
                        .build()
                .build();

    }
}

