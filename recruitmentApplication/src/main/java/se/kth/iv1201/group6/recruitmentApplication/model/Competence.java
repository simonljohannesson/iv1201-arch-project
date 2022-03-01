package se.kth.iv1201.group6.recruitmentApplication.model;

import javax.persistence.*;


@Entity
@Table(name = "competence")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competence_id")
    public Long id;
    
    @Column(name = "name")
    public String name;
}
