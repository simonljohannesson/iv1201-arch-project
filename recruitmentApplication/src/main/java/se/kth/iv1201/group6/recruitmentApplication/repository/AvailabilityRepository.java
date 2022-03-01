package se.kth.iv1201.group6.recruitmentApplication.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.group6.recruitmentApplication.model.Availability;

/**
 * Simple CRUD repository for availability entity
 */
@Transactional
@Repository
public interface AvailabilityRepository extends CrudRepository<Availability, Long>{
    /**
     * Find all availability data of an applicant
     * @param applicantId
     * @return A collection of the availability data
     */
    @Query("SELECT a FROM Availability a WHERE a.applicantId = :applicantId")
    Collection<Availability> findAvailability(@Param("applicantId") Long applicantId);
}
