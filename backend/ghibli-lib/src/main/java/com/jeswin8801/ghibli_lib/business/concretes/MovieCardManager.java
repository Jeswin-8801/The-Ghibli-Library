package com.jeswin8801.ghibli_lib.business.concretes;

import com.jeswin8801.ghibli_lib.business.abstracts.MovieListService;
import com.jeswin8801.ghibli_lib.repository.GhibliLibRepository;
import com.jeswin8801.ghibli_lib.repository.model.MovieCardInfo;
import com.jeswin8801.ghibli_lib.repository.model.MovieTitle;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import com.jeswin8801.ghibli_lib.utilities.results.SuccessDataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieCardManager implements MovieListService {

    private final GhibliLibRepository repository;

    @Autowired
    public MovieCardManager(GhibliLibRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result retrieveAllMovieCards() {
        List<MovieCardInfo> movieCardInfoList = repository.retrieveAllMovieCards();
        log.info(String.valueOf(movieCardInfoList));
        return new SuccessDataResult<>(movieCardInfoList, "successfully retrieved all movie cards");
    }

    @Override
    public Result retrieveAllMovieNamesLike(String name) {
        List<MovieTitle> movieNamesList = repository.retrieveMovieNamesLike(name);
        log.info(String.valueOf(movieNamesList));
        return new SuccessDataResult<>(movieNamesList, String.format("successfully retrieved all movie names that match with %s", name));
    }

    @Override
    public Result retrieveMovieCardsByName(String name) {
        List<MovieCardInfo> movieCardInfoList = repository.retieveMovieCardsByName(name);
        log.info(String.valueOf(movieCardInfoList));
        return new SuccessDataResult<>(movieCardInfoList, String.format("successfully retrieved all movie cards that match with %s", name));
    }
}
