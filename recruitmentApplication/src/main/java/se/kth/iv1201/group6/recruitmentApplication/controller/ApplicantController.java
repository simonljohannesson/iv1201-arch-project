package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantConflictException;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     * Create a new applicant.
     * @param createApplicant new applicant to create
     * @throws ApplicantConflictException if username, pnr or email is already in use
     */
    @PostMapping
    public ResponseEntity<Void> createApplicant(@Valid @RequestBody CreateApplicantDto createApplicant) throws ApplicantConflictException {
        applicantService.createApplicant(createApplicant);
        return new ResponseEntity<>(HttpStatus.CREATED);
        // TODO: redirect
    }
}
