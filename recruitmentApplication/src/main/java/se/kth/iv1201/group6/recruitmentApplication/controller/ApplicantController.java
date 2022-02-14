package se.kth.iv1201.group6.recruitmentApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import se.kth.iv1201.group6.recruitmentApplication.model.applicant.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.service.ApplicantService;

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

    @GetMapping
    public List<Applicant> getApplicants(){
        return applicantService.findAll();
    }
}
