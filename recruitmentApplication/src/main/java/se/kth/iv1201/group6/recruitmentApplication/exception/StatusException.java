package se.kth.iv1201.group6.recruitmentApplication.exception;

import org.springframework.http.HttpStatus;

public abstract class StatusException extends Exception {
    private int errorCode = 0;
    private final HttpStatus status;

    public StatusException(HttpStatus status) {
        this.status = status;
    }

    public StatusException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public StatusException(HttpStatus status, int errorCode) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public StatusException(HttpStatus status, int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public int getErrorCode() {return errorCode;}

    public HttpStatus getStatus() {
        return status;
    }
}
