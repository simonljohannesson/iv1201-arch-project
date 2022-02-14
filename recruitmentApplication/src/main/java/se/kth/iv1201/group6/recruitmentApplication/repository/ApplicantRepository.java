package se.kth.iv1201.group6.recruitmentApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.kth.iv1201.group6.recruitmentApplication.dao.CreateApplicantDao;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends CrudRepository<CreateApplicantDao, Long> {
    @Query("SELECT u FROM CreateApplicantDao u WHERE u.username = :username OR u.pnr = :pnr OR u.email = :email")
    Optional<Collection<CreateApplicantDao>> findByUniqueFields(
            @Param("username")  String username,
            @Param("pnr")       String pnr,
            @Param("email")     String email);

}

