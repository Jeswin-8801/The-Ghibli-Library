package com.jeswin8801.ghibli_lib.api.controller;

import com.jeswin8801.ghibli_lib.business.abstracts.MovieCrudService;
import com.jeswin8801.ghibli_lib.business.abstracts.MovieListService;
import com.jeswin8801.ghibli_lib.entities.dtos.MovieInfoDto;
import com.jeswin8801.ghibli_lib.repository.GhibliLibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GhibliLibContoller {
    private final GhibliLibRepository repository;

    private final MovieCrudService movieCrudService;
    private final MovieListService movieListService;

    @Autowired
    public GhibliLibContoller(GhibliLibRepository repository, MovieCrudService movieCrudService, MovieListService movieListService) {
        this.repository = repository;
        this.movieCrudService = movieCrudService;
        this.movieListService = movieListService;
    }

    @GetMapping("fetch-all-movie-cards")
    public ResponseEntity<?> fetchAllMovieCards() {
        return movieListService.retrieveAllMovieCards();
    }

    @GetMapping("fetch-all-movie-names-like")
    public ResponseEntity<?> fetchAllMovieNamesLike(@RequestParam String name) {
        return movieListService.retrieveAllMovieNamesLike(name);
    }

    @GetMapping("fetch-all-movie-cards-like")
    public ResponseEntity<?> fetchAllMovieCardsLike(@RequestParam String name) {
        return movieListService.retrieveMovieCardsByName(name);
    }

    @GetMapping("fetch-movie-info")
    public ResponseEntity<?> fetchMovieInfo(@RequestParam String name) {
        return movieCrudService.get(name);
    }

    @PostMapping("add-movie")
    public ResponseEntity<?> addMovie(@RequestBody MovieInfoDto requestDto) {
        return ResponseEntity.ok(this.movieCrudService.add(requestDto));
    }
}
