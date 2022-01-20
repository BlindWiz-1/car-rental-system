package com.application.carrentalsystem.repositories;

import com.application.carrentalsystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);
    Person findPersonByPersonalid(Integer id);
}
