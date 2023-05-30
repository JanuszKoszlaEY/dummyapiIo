package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder

public class CommentDto {

    private String id;
    private String message;
    private UserDTO owner;
    private String publishDate;
    private String post;

}