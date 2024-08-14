package com.jeswin8801.ghibli_lib.business.concretes;

import com.jeswin8801.ghibli_lib.business.abstracts.MovieCrudService;
import com.jeswin8801.ghibli_lib.business.abstracts.ResponseService;
import com.jeswin8801.ghibli_lib.entities.converters.MovieInfoConverter;
import com.jeswin8801.ghibli_lib.entities.dtos.MovieInfoDto;
import com.jeswin8801.ghibli_lib.repository.GhibliLibRepository;
import com.jeswin8801.ghibli_lib.repository.model.Movie;
import com.jeswin8801.ghibli_lib.utilities.results.ErrorResult;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import com.jeswin8801.ghibli_lib.utilities.results.SuccessDataResult;
import com.jeswin8801.ghibli_lib.utilities.results.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MovieManager implements MovieCrudService {

    @Autowired
    private GhibliLibRepository repository;

    @Autowired
    private ResponseService responseService;

    private final MovieInfoConverter movieInfoConverter;

    public MovieManager(MovieInfoConverter movieInfoConverter) {
        this.movieInfoConverter = movieInfoConverter;
    }

    @Override
    public ResponseEntity<?> get(String name) {
        Optional<Movie> movie = repository.findById(name);
        if (movie.isPresent())
            return responseService.returnDataResponseOnSuccess(
                    new SuccessDataResult<>(
                            movie.get(),
                            String.format("Movie with name [%s] found", name)
                    )
            );
        else
            return responseService.returnFailureResponse(new ErrorResult("Movie not found"));
    }

    @Override
    public Result add(MovieInfoDto movieInfoDto) {
        Movie movie = movieInfoConverter.registerMovieInfoDtoToMovieInfo(movieInfoDto);
        repository.save(movie);
        return new SuccessResult(String.format("Movie [%s] Added", movie.getName()));
    }

    @Override
    public Result update(MovieInfoDto movieInfoDto) {
        return null;
    }

    @Override
    public Result delete(String name) {
        return null;
    }
}
