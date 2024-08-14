package com.jeswin8801.ghibli_lib.repository;

import com.jeswin8801.ghibli_lib.entities.concretes.MovieCardInfo;
import com.jeswin8801.ghibli_lib.repository.model.Movie;
import com.jeswin8801.ghibli_lib.entities.concretes.MovieTitle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GhibliLibRepository extends MongoRepository<Movie, String> {
    // provides common functionalities for easily plug in and use

    // SELECT name, year, duration, poster FROM table;
    @Query("""
            {},
            {
                'name': 1,
                'year': 1,
                'duration': 1,
                'poster': 1
            }
            """)
    List<MovieCardInfo> retrieveAllMovieCards();

    // SELECT name, year, duration, poster FROM table WHERE name LIKE regex(parameter 0) OR alternate-titles LIKE regex(parameter 0);
    @Query("""
            {
                $or: [{
                    'name': {
                        $regex: ?0
                    }
                },{
                    'alternate-titles': {
                        $regex: ?0
                    }
                }]
            },
            {
                'name':1,
                'year':1,
                'duration':1,
                'poster':1
            }
            """)
    List<MovieCardInfo> retrieveMovieCardsByName(String name);

    // SELECT name FROM table WHERE name LIKE regex(parameter 0) OR alternate-titles LIKE regex(parameter 0);
    @Query("""
            {
                $or: [{
                    'name': {
                        $regex: ?0
                    }
                },{
                    'alternate-titles': {
                        $regex: ?0
                    }
                }]
            },
            {
                'name':1
            }
            """)
    List<MovieTitle> retrieveMovieNamesLike(String name);
}
