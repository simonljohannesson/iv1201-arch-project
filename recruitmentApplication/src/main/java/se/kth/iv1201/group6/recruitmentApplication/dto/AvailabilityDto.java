package se.kth.iv1201.group6.recruitmentApplication.dto;
import java.time.LocalDate;

import se.kth.iv1201.group6.recruitmentApplication.model.Availability;

/**
 * Data transfer object for applicant availability
 */
public class AvailabilityDto {
    public LocalDate fromDate;
    public LocalDate toDate;

    /**
     * Create a new instance from model class
     * @param availability The model instance
     */
    public AvailabilityDto(Availability availability) {
        this.fromDate = availability.fromDate;
        this.toDate = availability.toDate;
    }
}
