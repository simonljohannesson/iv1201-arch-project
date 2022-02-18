package se.kth.iv1201.group6.recruitmentApplication.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import se.kth.iv1201.group6.recruitmentApplication.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE role_id = 1")
    Optional<Collection<Person>> findAllRecruiters();
    
    @Query("SELECT p FROM Person p WHERE p.username = :username")
    Person findByUsername(@Param("username") String username);
}
