package se.kth.iv1201.group6.recruitmentApplication.dto;

import java.util.Collection;

import se.kth.iv1201.group6.recruitmentApplication.dao.AvailabilityDao;
import se.kth.iv1201.group6.recruitmentApplication.dao.CompetenceProfileDao;

public class ApplicantDataDto {
    public Collection<AvailabilityDao> availability;
    public Collection<CompetenceProfileDao> competence;

    public ApplicantDataDto(Collection<AvailabilityDao> availability, Collection<CompetenceProfileDao> competence) {
        this.availability = availability;
        this.competence = competence;
    }
}