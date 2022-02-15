package se.kth.iv1201.group6.recruitmentApplication.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.enums.ReasonEnum;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApplicantConflictException;
import se.kth.iv1201.group6.recruitmentApplication.exception.TestException;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("/error-handling")
public class ErrorHandlingControllerTest {


    @GetMapping
    public void first() throws TestException {
        throw new TestException(HttpStatus.FAILED_DEPENDENCY, 7777, "shit went down");
    }

    @GetMapping("/1")
    public void html() throws ApplicantConflictException {
//        throw new ApplicantConflictException(ReasonEnum.DUPLICATE_PNR);
        throw  new NullPointerException();
    }

}
