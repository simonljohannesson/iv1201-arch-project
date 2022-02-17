package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.kth.iv1201.group6.recruitmentApplication.model.applicant.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantService;

import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

/**
 * @author Victor Pettersson last changed 2022-02-14
 */
@Controller
@ResponseBody
@RequestMapping("users/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    public Page<Applicant> getApplicants(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable paging = PageRequest.of(page, size);
        return applicantService.findAll(paging);
    }
}
