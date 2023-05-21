package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@Builder
public class CommonListDto {
    private Arrays data;
    private int total;
    private int page;
    private int limit;

}
