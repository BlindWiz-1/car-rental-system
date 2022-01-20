package com.application.carrentalsystem.services;

import com.application.carrentalsystem.models.Person;
import com.application.carrentalsystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> savePeople(List<Person> people){
        return personRepository.saveAll(people);
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name){
        return personRepository.findByName(name);
    }


    public String deletePerson(int id){
        personRepository.deleteById(id);
        return "Person deleted " + id;
    }

    public Person updatePerson(Person person){

        Person existingPerson = personRepository.findById(person.getPersonalId()).orElse(null);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setBirthday(person.getBirthday());
        existingPerson.setPhoneNumber(person.getPhoneNumber());
        existingPerson.setEmailAddress(person.getEmailAddress());
        existingPerson.setIdCard(person.getIdCard());

        return personRepository.save(existingPerson);
    }

}
