package se.kth.iv1201.group6.recruitmentApplication.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This interface is used by JPA to fetch ApplicationUser from the database.
 *
 * Ultimately this repository exists to serve Spring-Security with users it should verify.
 */
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
    Optional<ApplicationUser> findById(long id);
}
