package com.jeswin8801.ghibli_lib.business.abstracts;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MovieListService {
    ResponseEntity<?> retrieveAllMovieCards();
    ResponseEntity<?> retrieveAllMovieNamesLike(String name);
    ResponseEntity<?> retrieveMovieCardsByName(String name);
}
