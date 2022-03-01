package se.kth.iv1201.group6.recruitmentApplication.dto;

import java.util.Collection;

public class ApplicantDataDto {
    public Collection<AvailabilityDto> availability;
    public Collection<CompetenceProfileDto> competence;

    public ApplicantDataDto(Collection<AvailabilityDto> availability, Collection<CompetenceProfileDto> competence) {
        this.availability = availability;
        this.competence = competence;
    }
}