package se.kth.iv1201.group6.recruitmentApplication.dto;

import se.kth.iv1201.group6.recruitmentApplication.filter.PersonNumberValidation;

import javax.validation.constraints.*;

/**
 * DTO for receiving Applicant information during creation.
 */
public class CreateApplicantDto {

    @NotBlank
    @Size(max = 250)
    public String name;
    @NotBlank
    @Size(max = 250)
    public String surname;
    @NotBlank
    @PersonNumberValidation()
    public String pnr;
    @NotBlank
    @Email
    @Size(max = 250)
    public String email;
    @NotBlank
    @Size(min = 8)
    @Size(max = 250)
    public String password;
    @Size(min = 4)
    @Size(max = 250)
    public String username;

}
