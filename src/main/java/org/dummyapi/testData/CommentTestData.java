package org.dummyapi.testData;

import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.dataModels.PostDto;
public class CommentTestData {
    public static CommentDto commentPostData(UserDto userDto, PostDto PostDto) {
        return CommentDto.builder()
                .message("Lorem ipsum dolor sit amet.")
                .owner(userDto.getId())
                .post(PostDto.getId())
                .build();
    }

}