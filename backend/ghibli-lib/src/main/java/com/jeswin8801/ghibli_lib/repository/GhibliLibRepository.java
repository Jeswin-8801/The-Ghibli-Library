package com.jeswin8801.ghibli_lib.repository;

import com.jeswin8801.ghibli_lib.repository.model.MovieCardInfo;
import com.jeswin8801.ghibli_lib.repository.model.Movie;
import com.jeswin8801.ghibli_lib.repository.model.MovieTitle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GhibliLibRepository extends MongoRepository<Movie, String> {
    // provides common functionalities for easily plug in and use

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

    @Query("""
            {
                $or: [{
                    'name': /.*?0.*/
                },{
                    'alternate-titles': /.*?0.*/
                }]
            },
            {
                'name':1,
                'year':1,
                'duration':1,
                'poster':1
            }
            """)
    List<MovieCardInfo> retieveMovieCardsByName(String name);

    @Query("""
            {
                $or: [{
                    'name': /.*?0.*/
                },{
                    'alternate-titles': /.*?0.*/
                }]
            },
            {
                'name':1
            }
            """)
    List<MovieTitle> retrieveMovieNamesLike(String name);
}
