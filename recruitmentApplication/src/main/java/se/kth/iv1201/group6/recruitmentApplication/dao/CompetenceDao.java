package se.kth.iv1201.group6.recruitmentApplication.dao;

import javax.persistence.*;


@Entity
@Table(name = "competence")
public class CompetenceDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competence_id")
    public Long id;
    
    @Column(name = "name")
    public String name;
}
