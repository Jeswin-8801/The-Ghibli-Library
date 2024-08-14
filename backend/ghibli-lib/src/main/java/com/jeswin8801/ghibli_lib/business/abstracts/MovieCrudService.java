package com.jeswin8801.ghibli_lib.business.abstracts;

import com.jeswin8801.ghibli_lib.entities.dtos.MovieInfoDto;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MovieCrudService {
    ResponseEntity<?> get(String name);
    Result add(MovieInfoDto movieInfoDto);
    Result update(MovieInfoDto movieInfoDto);
    Result delete(String name);
}
