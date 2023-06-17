package org.dummyapi.testData;

import org.dummyapi.dataModels.CommentDto;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.dataModels.PostDto;
public class CommentTestData {
    public static CommentDto commentPostData(UserDto userDto, PostDto PostDto) {
        return CommentDto.builder()
                .message("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                .owner(userDto.getId())
                .post(PostDto.getId())
                .build();
    }

}