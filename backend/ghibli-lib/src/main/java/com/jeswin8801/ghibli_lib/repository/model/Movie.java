package com.jeswin8801.ghibli_lib.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document("movie-info")
public class Movie {
    @Id
    private String name;
    private List<String> alternateTitles;
    private Integer year;
    private String poster;
    private String backgroundImage;

    private String director;
    private String producer;
    private String music;

    private Integer duration;
    private String releaseDate;
    private String type;
    private Double malScore;
    private Double imdbScore;
    private String synopsys;
    private List<String> images;
}
