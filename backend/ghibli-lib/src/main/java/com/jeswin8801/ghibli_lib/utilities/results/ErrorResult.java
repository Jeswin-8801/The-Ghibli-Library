package com.jeswin8801.ghibli_lib.utilities.results;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }


    public ErrorResult(String message) {
        super(false, message);
    }
}
