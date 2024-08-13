package com.jeswin8801.ghibli_lib.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieCardListDto {
    List<MovieCardDto> movies;
}
