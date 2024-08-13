package com.jeswin8801.ghibli_lib.repository;

import com.jeswin8801.ghibli_lib.model.MovieInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhibliLibRepository extends MongoRepository<MovieInfo, String> {
    // provides common functionalities for easily plug in and use
}