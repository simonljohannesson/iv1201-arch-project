package se.kth.iv1201.group6.recruitmentApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.kth.iv1201.group6.recruitmentApplication.model.CreateApplicant;

import java.util.Collection;
import java.util.Optional;


/**
 * Repository used to create new applicants.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CreateApplicantRepository extends CrudRepository<CreateApplicant, Long>{
    @Query("SELECT u FROM CreateApplicant u WHERE u.username = :username OR u.pnr = :pnr OR u.email = :email")
    Optional<Collection<CreateApplicant>> findByUniqueFields(
            @Param("username")  String username,
            @Param("pnr")       String pnr,
            @Param("email")     String email);
}

