package se.kth.iv1201.group6.recruitmentApplication.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.kth.iv1201.group6.recruitmentApplication.model.Person;
import se.kth.iv1201.group6.recruitmentApplication.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Iterable<Person> findAll() {
        
        var persons = repository.findAll();

        return persons;
    }

    public Person findById(long id){
        var person = repository.findById(id);
        if(person.isPresent()) return person.get();
        throw new IllegalArgumentException("Person does not exist.");
    }

    public Collection<Person> findAllRecruiters() {
        var opt_persons = repository.findAllRecruiters();
        if(opt_persons.isPresent()) return opt_persons.get();
        throw new IllegalArgumentException("No recruiters found");
    }
}
