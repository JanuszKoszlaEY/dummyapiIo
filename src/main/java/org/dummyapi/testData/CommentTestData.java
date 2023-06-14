package org.dummyapi.testData;

import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.UserDto;

public class CommentTestData {
    public static CommentDto commentPostData(UserDto userId, String postId) {
        return CommentDto.builder()
                .message("Test 123 message!")
                .owner(userId)
                .post(postId)
                .build();
    }
}

