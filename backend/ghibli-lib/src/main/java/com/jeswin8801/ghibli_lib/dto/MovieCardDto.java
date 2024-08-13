package com.jeswin8801.ghibli_lib.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieCardDto {
    String name;
    Integer year;
    String poster;
    Integer duration;
}
