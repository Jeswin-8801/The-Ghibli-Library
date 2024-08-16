package com.jeswin8801.ghibli_lib.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MovieInfoDto {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty("alternate-titles")
    private List<String> alternateTitles;
    private Integer year;
    private String poster;
    @JsonProperty("background-image")
    private String backgroundImage;
    private String director;
    private String producer;
    private String music;
    private Integer duration;
    @JsonProperty("release-date")
    private String releaseDate;
    private String type;
    @JsonProperty("mal-score")
    private Double malScore;
    @JsonProperty("imdb-score")
    private Double imdbScore;
    private String synopsis;
    private List<String> images;
}
