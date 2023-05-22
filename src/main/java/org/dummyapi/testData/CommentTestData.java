package org.dummyapi.testData;

import org.dummyapi.dataModels.requestBody.CommentDto;

public class CommentTestData {
    public static CommentDto commentPostData(Integer userId, Integer postId){
        return CommentDto.builder()
                .message("Message Test Data")
                .owner(userId)
                .post(postId)
                .build();
    }

}
