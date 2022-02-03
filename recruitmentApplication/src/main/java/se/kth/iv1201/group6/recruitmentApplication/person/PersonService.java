package se.kth.iv1201.group6.recruitmentApplication.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        
        var persons = (List<Person>) repository.findAll();

        return persons;
    }
}
