package se.kth.iv1201.group6.recruitmentApplication.exception;

import org.springframework.http.HttpStatus;

//@ResponseStatus(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
public class TestException extends StatusException {
    public TestException(HttpStatus status, int errorCode, String msg) {
        super(status, errorCode, msg);
    }
}
