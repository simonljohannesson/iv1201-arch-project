package se.kth.iv1201.group6.recruitmentApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.kth.iv1201.group6.recruitmentApplication.dao.CreateApplicantDao;
import se.kth.iv1201.group6.recruitmentApplication.dto.ApplicantDataDto;
import se.kth.iv1201.group6.recruitmentApplication.dto.AvailabilityDto;
import se.kth.iv1201.group6.recruitmentApplication.dto.CompetenceProfileDto;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;
import se.kth.iv1201.group6.recruitmentApplication.enums.ReasonEnum;
import se.kth.iv1201.group6.recruitmentApplication.exception.ApplicantConflictException;
import se.kth.iv1201.group6.recruitmentApplication.model.Applicant;
import se.kth.iv1201.group6.recruitmentApplication.model.Availability;
import se.kth.iv1201.group6.recruitmentApplication.model.CompetenceProfile;
import se.kth.iv1201.group6.recruitmentApplication.repository.ApplicantRepository;
import se.kth.iv1201.group6.recruitmentApplication.repository.AvailabilityRepository;
import se.kth.iv1201.group6.recruitmentApplication.repository.CompetenceRepository;
import se.kth.iv1201.group6.recruitmentApplication.repository.CreateApplicantRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

/**
 * Service for handling Applicants
 */
@Service
public class ApplicantService {

    @Autowired
    private CreateApplicantRepository createApplicantRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Finds all applicants on specified page
     * @param page Pageable object
     * @return A page object containing applicants
     */
    public Page<Applicant> findAll(Pageable page){
        return applicantRepository.findAllApplicants(page);
    }

    /**
     * Create a new applicant.
     * @param applicant new applicant to create
     * @throws ApplicantConflictException Username, pnr, or email is already used.
     */
    @Transactional
    public void createApplicant(CreateApplicantDto applicant) throws ApplicantConflictException {
        var users
                = createApplicantRepository.findByUniqueFields(applicant.username, applicant.pnr, applicant.email).get();

        if(users.isEmpty()){
            var usr = new CreateApplicantDao(applicant);
            usr.password = passwordEncoder.encode(usr.password);
            createApplicantRepository.save(usr);
        } else {
            for(var user : users){
                if(user.email.equals(applicant.email))          throw new ApplicantConflictException(ReasonEnum.DUPLICATE_EMAIL, "Email already in use");
                if(user.username.equals(applicant.username))    throw new ApplicantConflictException(ReasonEnum.DUPLICATE_USERNAME, "Username already in use");
                if(user.pnr.equals(applicant.pnr))              throw new ApplicantConflictException(ReasonEnum.DUPLICATE_PNR, "Person number already in use");
            }
            throw new InternalError("An error occured.");
        }
    }

    /**
     * Get an applicants data concerning an application
     * @param applicantId The id of the applicant
     * @return ApplicantDataDto competences and availability
     */
    @Transactional
    public ApplicantDataDto getApplicantData(Long applicantId) {
        var availability = availabilityRepository.findAvailability(applicantId);
        Collection<AvailabilityDto> availabilityDtos = availability.stream().map(a -> new AvailabilityDto(a)).collect(Collectors.toList());
        
        var competence = competenceRepository.findCompetence(applicantId);
        Collection<CompetenceProfileDto> competenceDtos = competence.stream().map(a -> new CompetenceProfileDto(a)).collect(Collectors.toList());
        
        return new ApplicantDataDto(availabilityDtos, competenceDtos);
    }
}
