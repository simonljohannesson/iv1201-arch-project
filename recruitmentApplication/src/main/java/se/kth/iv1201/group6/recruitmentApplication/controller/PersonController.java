package se.kth.iv1201.group6.recruitmentApplication.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import se.kth.iv1201.group6.recruitmentApplication.model.Person;
import se.kth.iv1201.group6.recruitmentApplication.service.PersonService;

@Controller
@ResponseBody
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping
    public Iterable<Person> getPersons() {

        var persons = personService.findAll();

        return persons;
    }

    // try me with non existing id number like 555555
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable long id){
        var person = personService.findById(id);
        return person;
    }

    @GetMapping("/recruiters")
    public Collection<Person> getRecruiters(){
        var persons = personService.findAllRecruiters();
        return persons;
    }
}
