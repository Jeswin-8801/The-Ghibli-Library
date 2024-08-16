package com.jeswin8801.ghibli_lib.entities.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieCardListDto {
    private List<MovieCardDto> movies;
}
