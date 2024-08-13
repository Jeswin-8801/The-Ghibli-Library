package com.jeswin8801.ghibli_lib.entities.converters;

import com.jeswin8801.ghibli_lib.entities.dtos.MovieInfoDto;
import com.jeswin8801.ghibli_lib.repository.model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieInfoConverter {
    private final ModelMapper modelMapper;

    public MovieInfoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Movie registerMovieInfoDtoToMovieInfo(MovieInfoDto movieInfoDto) {
        Movie movieInfo = new Movie();
        this.modelMapper.map(movieInfoDto, movieInfo);
        return movieInfo;
    }
}
