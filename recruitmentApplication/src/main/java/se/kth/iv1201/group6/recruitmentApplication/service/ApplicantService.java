package se.kth.iv1201.group6.recruitmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.iv1201.group6.recruitmentApplication.model.applicant.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.repository.ApplicantRepository;

import java.util.List;

/**
 * @author Victor Pettersson last changed 2022-02-14
 */
@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> findAll(){
        return applicantRepository.findAllApplicants();
    }
}
