package com.jeswin8801.ghibli_lib.entities.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieCardDto {
    private String name;
    private Integer year;
    private String poster;
    private Integer duration;
}
