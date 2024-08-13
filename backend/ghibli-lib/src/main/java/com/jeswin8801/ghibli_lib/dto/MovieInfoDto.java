package com.jeswin8801.ghibli_lib.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class MovieInfoDto {
    String name;
    List<String> alternateTitles;
    Integer year;
    String poster;
    String backgroundImage;
    String producer;
    Integer duration;
    Date releaseDate;
    String type;
    Double malScore;
    Double imdbScore;
    String synopsys;
    List<String> images;
}
