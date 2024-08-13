package com.jeswin8801.ghibli_lib.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document("movie-info")
public class MovieInfo {
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
    private Date releaseDate;
    private String type;
    private Double malScore;
    private Double imdbScore;
    private String synopsys;
    private List<String> images;
}
