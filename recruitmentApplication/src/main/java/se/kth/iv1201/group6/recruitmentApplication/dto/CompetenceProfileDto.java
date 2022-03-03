package se.kth.iv1201.group6.recruitmentApplication.dto;

import se.kth.iv1201.group6.recruitmentApplication.model.CompetenceProfile;

/**
 * Data transfer object for competence profile data
 */
public class CompetenceProfileDto {
    public final long competenceId;
    public final double yearsOfExperience;

    /**
     * Create a new instance from the CompetenceProfile model class
     * @param competence Existing model object
     */
    public CompetenceProfileDto (CompetenceProfile competence) {
        this.competenceId = competence.competenceId;
        this.yearsOfExperience = competence.yearsOfExperience;
    }
}
