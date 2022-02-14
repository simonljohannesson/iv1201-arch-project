package se.kth.iv1201.group6.recruitmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import se.kth.iv1201.group6.recruitmentApplication.dao.CreateApplicantDao;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.enums.ReasonEnum;
import se.kth.iv1201.group6.recruitmentApplication.repository.ApplicantRepository;

import javax.transaction.Transactional;

/**
 * Service for handling Applicants
 */
@Service
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Create a new applicant.
     * @param applicant new applicant to create
     * @throws ApplicantConflictException Username, pnr, or email is already used.
     */
    @Transactional
    public void createApplicant(CreateApplicantDto applicant) throws ApplicantConflictException {
        var users
                = applicantRepository.findByUniqueFields(applicant.username, applicant.pnr, applicant.email).get();

        if(users.isEmpty()){
            var usr = new CreateApplicantDao(applicant);
            usr.password = passwordEncoder.encode(usr.password);
            applicantRepository.save(usr);
        } else {
            for(var user : users){
                if(user.email.equals(applicant.email))          throw new ApplicantConflictException(ReasonEnum.DUPLICATE_EMAIL, "Email already in use");
                if(user.username.equals(applicant.username))    throw new ApplicantConflictException(ReasonEnum.DUPLICATE_USERNAME, "Username already in use");
                if(user.pnr.equals(applicant.pnr))              throw new ApplicantConflictException(ReasonEnum.DUPLICATE_PNR, "Person number already in use");
            }
            throw new InternalError("An error occured.");
        }
    }

}
