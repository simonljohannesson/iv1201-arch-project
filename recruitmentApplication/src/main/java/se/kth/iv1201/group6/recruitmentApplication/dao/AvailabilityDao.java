package se.kth.iv1201.group6.recruitmentApplication.dao;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "availability")
public class AvailabilityDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "availability_id")
    public Long id;

    @Column(name = "person_id")
    public Long personId;
    @Column(name = "from_date")
    public Date fromDate;
    @Column(name = "to_date")
    public Date toDate;
}
