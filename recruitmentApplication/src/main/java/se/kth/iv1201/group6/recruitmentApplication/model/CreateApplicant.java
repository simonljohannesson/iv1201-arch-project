package se.kth.iv1201.group6.recruitmentApplication.model;

import se.kth.iv1201.group6.recruitmentApplication.enums.UserRole;
import se.kth.iv1201.group6.recruitmentApplication.dto.CreateApplicantDto;

import javax.persistence.*;

/**
 * Object for creating a new applicant.
 */
@Entity
@Table(name = "person")
public class CreateApplicant {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String surname;
    @Column(unique = true)
    public String pnr;
    @Column(unique = true)
    public String email;
    public String password;
    @Column(name = "username", unique = true)
    public String username;
    @Column(name = "role_id")
    public final int role = UserRole.APPLICANT.getValue();

    public CreateApplicant() {
    }

    public CreateApplicant(CreateApplicantDto createApplicantDto){
        name = createApplicantDto.name;
        surname = createApplicantDto.surname;
        pnr = createApplicantDto.pnr;
        email = createApplicantDto.email;
        password = createApplicantDto.password;
        username = createApplicantDto.username;
    }
}
