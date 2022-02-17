package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApplicantConflictException;
import se.kth.iv1201.group6.recruitmentApplication.model.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantService;

import javax.validation.Valid;

@Controller
@ResponseBody
@RequestMapping("users/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     * Get applicants paged
     * @param page page-number wanted, defaults to page 0
     * @param size size of page, defaults to 10
     * @return A page with users and paging info
     */
    @GetMapping
    @CrossOrigin
    public Page<Applicant> getApplicants(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable paging = PageRequest.of(page, size);
        return applicantService.findAll(paging);
    }
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
