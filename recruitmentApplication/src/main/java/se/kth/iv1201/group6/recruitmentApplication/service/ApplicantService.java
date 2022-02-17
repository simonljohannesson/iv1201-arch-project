package se.kth.iv1201.group6.recruitmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se.kth.iv1201.group6.recruitmentApplication.model.applicant.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.repository.ApplicantRepository;
import org.springframework.data.domain.Pageable;


/**
 * @author Victor Pettersson last changed 2022-02-14
 */
@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public Page<Applicant> findAll(Pageable page){
        return applicantRepository.findAllApplicants(page);
    }
}
