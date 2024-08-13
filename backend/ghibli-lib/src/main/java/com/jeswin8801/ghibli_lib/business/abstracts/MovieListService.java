package com.jeswin8801.ghibli_lib.business.abstracts;

import com.jeswin8801.ghibli_lib.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface MovieListService {
    Result retrieveAllMovieCards();
    Result retrieveAllMovieNamesLike(String name);
    Result retrieveMovieCardsByName(String name);
}
