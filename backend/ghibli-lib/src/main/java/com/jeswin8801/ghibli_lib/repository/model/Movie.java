package com.jeswin8801.ghibli_lib.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document("Ghibli-Movies-Table")
public class Movie {
    @Id
    private String name;
    @Field("alternate-titles")
    private List<String> alternateTitles;
    private Integer year;
    private String poster;
    @Field("background-image")
    private String backgroundImage;
    private String director;
    private String producer;
    private String music;
    private Integer duration;
    @Field("release-date")
    private String releaseDate;
    private String type;
    @Field("mal-score")
    private Double malScore;
    @Field("imdb-score")
    private Double imdbScore;
    private String synopsys;
    private List<String> images;
}
