package com.jeswin8801.ghibli_lib.business.concretes;

import com.jeswin8801.ghibli_lib.business.abstracts.ResponseService;
import com.jeswin8801.ghibli_lib.utilities.UtilFunctions;
import com.jeswin8801.ghibli_lib.utilities.results.DataResult;
import com.jeswin8801.ghibli_lib.utilities.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResponseManager implements ResponseService {

    @Override
    public ResponseEntity<?> returnSuccessResponse(Result result) {
        log.info(UtilFunctions.prettyPrintObject(result));
        return new ResponseEntity<>(
                result,
                HttpStatusCode.valueOf(
                        result.getMessage().contains("added") ? 201 : 200
                )
        );
    }

    @Override
    public ResponseEntity<?> returnFailureResponse(Result result) {
        log.error(result.getMessage());
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    @Override
    public ResponseEntity<?> returnDataResponseOnSuccess(DataResult<?> result) {
        log.info(UtilFunctions.prettyPrintObject(result));
        return ResponseEntity.ok(result.getData());
    }
}
