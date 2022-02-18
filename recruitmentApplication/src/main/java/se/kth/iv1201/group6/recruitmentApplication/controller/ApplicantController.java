package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.enums.ApiErrorCode;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApiException;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApplicantConflictException;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     * Create a new applicant.
     *
     * If username, pnr or email is already in use the new applicant will not be created.
     *
     * @param createApplicant new applicant to create
     */
    @PostMapping
    public ResponseEntity<Void> createApplicant(@Valid @RequestBody CreateApplicantDto createApplicant) {
        try {
            applicantService.createApplicant(createApplicant);
            return new ResponseEntity<>(HttpStatus.CREATED);
            // TODO: redirect to login?
        } catch (ApplicantConflictException e ) {
            ApiErrorCode errorCode;
            switch (e.getReason()){
                case DUPLICATE_EMAIL -> errorCode = ApiErrorCode.DUPLICATE_EMAIL;
                case DUPLICATE_USERNAME -> errorCode = ApiErrorCode.DUPLICATE_USERNAME;
                case DUPLICATE_PNR -> errorCode = ApiErrorCode.DUPLICATE_PNR;
                default -> errorCode = ApiErrorCode.NOT_DEFINED;
            }

            throw new ApiException(HttpStatus.CONFLICT, e.getMessage(), errorCode);
        }
    }
}
