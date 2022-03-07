package se.kth.iv1201.group6.recruitmentApplication.dto;

import java.util.Collection;

/**
 * A class to deliver an applicants application data
 */
public class ApplicantDataDto {
    public Collection<AvailabilityDto> availability;
    public Collection<CompetenceProfileDto> competence;

    /**
     * Create a new instance with availability and competence
     * @param availability Collection of availability data
     * @param competence Collection of competence data
     */
    public ApplicantDataDto(Collection<AvailabilityDto> availability, Collection<CompetenceProfileDto> competence) {
        this.availability = availability;
        this.competence = competence;
    }
}