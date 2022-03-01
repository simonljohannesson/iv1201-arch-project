package se.kth.iv1201.group6.recruitmentApplication.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.group6.recruitmentApplication.model.CompetenceProfile;

/**
 * Simple CRUD repository for competence entity
 */
@Repository
@Transactional
public interface CompetenceRepository extends CrudRepository<CompetenceProfile, Long>{
    /**
     * Find all competence data of an applicant
     * @param applicantId
     * @return A collection of the competence data
     */
    @Query("SELECT a FROM CompetenceProfile a WHERE a.applicantId = :applicantId")
    Collection<CompetenceProfile> findCompetence(Long applicantId);
}
