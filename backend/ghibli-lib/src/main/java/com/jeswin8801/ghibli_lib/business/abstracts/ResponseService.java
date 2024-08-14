package com.jeswin8801.ghibli_lib.business.abstracts;

import com.jeswin8801.ghibli_lib.utilities.results.DataResult;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ResponseService {
    ResponseEntity<?> returnSuccessResponse(Result result);
    ResponseEntity<?> returnFailureResponse(Result result);
    ResponseEntity<?> returnDataResponseOnSuccess(DataResult<?> result);
}
