package se.kth.iv1201.group6.recruitmentApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.kth.iv1201.group6.recruitmentApplication.enums.ApiErrorCode;

import static se.kth.iv1201.group6.recruitmentApplication.enums.ApiErrorCode.*;

/**
 * The exception that is used by controllers to display an error to a user of its API.
 *
 * The http status code given to the constructor will be shown to the user receiving the error.
 */
public class ApiException extends ResponseStatusException {
    private ApiErrorCode apiErrorCode = NOT_DEFINED;

    public ApiException(HttpStatus status) {
        super(status);
    }
    public ApiException(HttpStatus status, ApiErrorCode apiErrorCode) {
        super(status);
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public ApiException(HttpStatus status, String reason, ApiErrorCode apiErrorCode) {
        super(status, reason);
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    public ApiException(HttpStatus status, String reason, Throwable cause, ApiErrorCode apiErrorCode) {
        super(status, reason, cause);
        this.apiErrorCode = apiErrorCode;
    }

    public ApiException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public ApiException(int rawStatusCode, String reason, Throwable cause, ApiErrorCode apiErrorCode) {
        super(rawStatusCode, reason, cause);
        this.apiErrorCode = apiErrorCode;
    }

    public ApiErrorCode getApiErrorCode() {
        return apiErrorCode;
    }
}
