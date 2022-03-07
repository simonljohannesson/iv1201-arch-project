package se.kth.iv1201.group6.recruitmentApplication.model;

import javax.persistence.*;

@Entity
@Table(name = "competence_profile")
public class CompetenceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competence_profile_id")
    public Long id;
    
    @Column(name = "person_id")
    public Long applicantId;
    @Column(name = "competence_id")
    public Long competenceId;
    @Column(name = "years_of_experience")
    public Double yearsOfExperience;
}
