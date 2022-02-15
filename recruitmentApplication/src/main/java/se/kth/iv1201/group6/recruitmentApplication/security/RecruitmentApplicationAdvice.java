package se.kth.iv1201.group6.recruitmentApplication.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.kth.iv1201.group6.recruitmentApplication.exception.StatusException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ConditionalOnProperty(name = "customerrorhandling",
                        havingValue = "true")
public class RecruitmentApplicationAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleUncheckedExceptions(HttpServletRequest req, Exception e){
        // TODO: log unexpected error
        System.out.println("Runtime exception");
        // TODO: error return message?
//        return new Object(){
//            public String trace = e.getStackTrace().toString();
//            public int status = 500;
//            public String error = "Internal server error";
//            public String message = e.getMessage();
//            public String path = req.getPathInfo();
//        };


    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<Void> handleCheckedExceptions(HttpServletRequest req, StatusException e) {
//        req.
        // TODO: error return message

        return new ResponseEntity<>(e.getStatus());
    }
}
