package se.kth.iv1201.group6.recruitmentApplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.kth.iv1201.group6.recruitmentApplication.model.applicant.Applicant;

/**
 * @author Victor Pettersson last changed 2022-02-14
 */
@Repository
public interface ApplicantRepository extends PagingAndSortingRepository<Applicant, Long> {

    @Query("SELECT a FROM Applicant a WHERE role_id = 2")
    Page<Applicant> findAllApplicants(Pageable pageable);
}
