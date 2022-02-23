package se.kth.iv1201.group6.recruitmentApplication.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.kth.iv1201.group6.recruitmentApplication.dao.AvailabilityDao;

@Repository
public interface AvailabilityRepository extends CrudRepository<AvailabilityDao, Long>{
    @Query("SELECT a FROM CompetenceProfileDao a LEFT JOIN a.competence c WHERE a.applicantId = :applicantId AND a.competenceId = c.id")
    Collection<AvailabilityDao> findAvailability(@Long applicantId);
}
