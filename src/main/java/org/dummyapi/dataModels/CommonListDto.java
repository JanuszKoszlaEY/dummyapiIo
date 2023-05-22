package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CommonListDto {
    private List<Object> data;
    private int total;
    private int page;
    private int limit;

}
