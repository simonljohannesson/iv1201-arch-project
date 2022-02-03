package se.kth.iv1201.group6.recruitmentApplication.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() {

        var persons = personService.findAll();

        return persons;
    }
}
