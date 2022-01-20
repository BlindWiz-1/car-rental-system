package com.application.carrentalsystem.controllers;

import com.application.carrentalsystem.models.Person;
import com.application.carrentalsystem.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @PostMapping("/addPersons")
    public List<Person> addPersons(@RequestBody List<Person> persons){
        return personService.savePersons(persons);
    }

    @GetMapping("/persons")
    public List<Person> findAllPersons(){
        return personService.getPersons();
    }

    @GetMapping("/personById/{id}")
    public Person findPersonById(@PathVariable int id){
        return personService.getPersonById(id);
    }

    @GetMapping("/personByName/{name}")
    public Person findPersonByName(@PathVariable String name){
        return personService.getPersonByName(name);
    }

    @PutMapping ("/updatePerson")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping ("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id){
        return personService.deletePerson(id);
    }
}
