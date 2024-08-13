package com.jeswin8801.ghibli_lib.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class MovieInfoDto {
    @JsonProperty(required = true)
    String name;
    @JsonProperty("alternate-titles")
    List<String> alternateTitles;
    Integer year;
    String poster;
    @JsonProperty("background-image")
    String backgroundImage;
    String director;
    String producer;
    String music;
    Integer duration;
    @JsonProperty("release-date")
    String releaseDate;
    String type;
    @JsonProperty("mal-score")
    Double malScore;
    @JsonProperty("imdb-score")
    Double imdbScore;
    String synopsys;
    List<String> images;
}
