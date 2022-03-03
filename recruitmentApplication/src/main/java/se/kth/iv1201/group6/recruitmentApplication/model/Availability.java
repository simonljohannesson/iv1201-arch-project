package se.kth.iv1201.group6.recruitmentApplication.model;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "availability_id")
    public Long id;

    @Column(name = "person_id")
    public Long applicantId;
    @Column(name = "from_date")
    public LocalDate fromDate;
    @Column(name = "to_date")
    public LocalDate toDate;
}
