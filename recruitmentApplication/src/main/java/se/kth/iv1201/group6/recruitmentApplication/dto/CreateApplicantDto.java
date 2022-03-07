package se.kth.iv1201.group6.recruitmentApplication.dto;

import se.kth.iv1201.group6.recruitmentApplication.annotation.PersonNumberValidation;

import javax.validation.constraints.*;

/**
 * DTO for receiving Applicant information during creation.
 */
public class CreateApplicantDto {

    @NotBlank(message = "This field is required")
    @Size(max = 250, message = "Can't be more than 250 characters")
    public String name;
    @NotBlank(message = "This field is required")
    @Size(max = 250, message = "Can't be more than 250 characters")
    public String surname;
    @NotBlank(message = "This field is required")
    @PersonNumberValidation(message = "Must be a valid person number")
    public String pnr;
    @NotBlank(message = "This field is required")
    @Email(message = "This must be a valid email")
    @Size(max = 250, message = "Can't be more than 250 characters")
    public String email;
    @NotBlank(message = "This field is required")
    @Size(min = 8, max = 250, message = "Must be min 8 and max 250 characters.")
    public String password;
    @NotBlank(message = "This field is required")
    @Size(min = 4, max = 250, message = "Must be min 4 and max 250 characters.")
    public String username;

}
