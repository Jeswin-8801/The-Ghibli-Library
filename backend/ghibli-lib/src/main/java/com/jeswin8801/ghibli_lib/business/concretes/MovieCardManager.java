package com.jeswin8801.ghibli_lib.business.concretes;

import com.jeswin8801.ghibli_lib.business.abstracts.MovieListService;
import com.jeswin8801.ghibli_lib.business.abstracts.ResponseService;
import com.jeswin8801.ghibli_lib.entities.concretes.MovieCardInfo;
import com.jeswin8801.ghibli_lib.entities.concretes.MovieTitle;
import com.jeswin8801.ghibli_lib.repository.GhibliLibRepository;
import com.jeswin8801.ghibli_lib.utilities.UtilFunctions;
import com.jeswin8801.ghibli_lib.utilities.results.ErrorResult;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import com.jeswin8801.ghibli_lib.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCardManager implements MovieListService {

    private final GhibliLibRepository repository;
    private final ResponseService responseService;

    @Autowired
    public MovieCardManager(GhibliLibRepository repository, ResponseService responseService) {
        this.repository = repository;
        this.responseService = responseService;
    }

    @Override
    public ResponseEntity<?> retrieveAllMovieCards() {
        List<MovieCardInfo> movieCardInfoList = repository.retrieveAllMovieCards();
        if (movieCardInfoList.isEmpty())
            return responseService.returnFailureResponse(new ErrorResult("Database EMPTY. No movies found."));
        else
            return responseService.returnDataResponseOnSuccess(
                    new SuccessDataResult<>(movieCardInfoList, "successfully retrieved all movie cards")
            );
    }

    @Override
    public ResponseEntity<?> retrieveAllMovieNamesLike(String name) {
        List<MovieTitle> movieNamesList = repository.retrieveMovieNamesLike(UtilFunctions.convertToRegex(name));
        if (movieNamesList.isEmpty())
            return responseService.returnFailureResponse(
                    new ErrorResult(
                            String.format("No movies found that matches [%s]", name)
                    )
            );
        else
            return responseService.returnDataResponseOnSuccess(
                    new SuccessDataResult<>(
                            movieNamesList,
                            String.format("successfully retrieved all movie names that match with [%s]", name)
                    )
            );
    }

    @Override
    public ResponseEntity<?> retrieveMovieCardsByName(String name) {
        List<MovieCardInfo> movieCardInfoList = repository.retrieveMovieCardsByName(UtilFunctions.convertToRegex(name));
        if (movieCardInfoList.isEmpty())
            return responseService.returnFailureResponse(
                    new ErrorResult(
                            String.format("No movie cards could be found that matches [%s]", name)
                    )
            );
        else
            return responseService.returnDataResponseOnSuccess(
                    new SuccessDataResult<>(
                            movieCardInfoList,
                            String.format("successfully retrieved all movie cards that match with [%s]", name)
                    )
            );
    }
}
