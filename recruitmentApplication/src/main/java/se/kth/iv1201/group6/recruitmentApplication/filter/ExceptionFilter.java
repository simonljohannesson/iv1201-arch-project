package se.kth.iv1201.group6.recruitmentApplication.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import se.kth.iv1201.group6.recruitmentApplication.dto.ApiError;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApiException;


/**
 * This is a RestControllerAdvice class which is used to define how uncaught exceptions should be handled.
 */
@RestControllerAdvice
@ConditionalOnProperty(name = "customerrorhandling",
                        havingValue = "true")
public class ExceptionFilter {

    /**
     * All exceptions thrown, that are not ApiExceptions are redacted and displayed as Internal server errors.
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleUnexpectedExceptions(Throwable throwable) throws Throwable {

        if(throwable instanceof ResponseStatusException rse){
            // TODO: Log bad use of ResponseStatusException
            var obj = new Object(){
                public int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                public String error = HttpStatus.INTERNAL_SERVER_ERROR.name();
                public String message = "No message available";
            };
            return new ResponseEntity<Object>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // TODO: Logging
        throw throwable;
    }

    /**
     * ApiExceptions are displayed to the API end users using their respective HTTP status code.
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiExceptions(ApiException e) {
        var error = new ApiError();
        error.status = e.getStatus().value();
        error.errorCode = e.getApiErrorCode().getValue();
        error.error = e.getStatus().name();
        error.message = e.getReason();
        return new ResponseEntity<>(error, e.getStatus());
    }
}
