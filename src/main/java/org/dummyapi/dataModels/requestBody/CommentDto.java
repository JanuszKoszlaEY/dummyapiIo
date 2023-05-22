package org.dummyapi.dataModels.requestBody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CommentDto {
    private String id;
    private String message;
    private Integer owner;
    private Integer post;
    private String publishDate;

}
