package com.jeswin8801.ghibli_lib.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GhibliLibContoller {

    @GetMapping("all-movies")
    public ResponseEntity<Object> fetchAllMovies() {
        return null;
    }
}
