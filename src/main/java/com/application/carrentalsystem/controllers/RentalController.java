package com.application.carrentalsystem.controllers;

import com.application.carrentalsystem.models.Car;
import com.application.carrentalsystem.models.Person;
import com.application.carrentalsystem.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/rentedCars")
    public List<Car> findRentedCars(){
        return rentalService.getCarsRented();
    }

    @GetMapping("/customers")
    public Set<Person> findCustomers(){
        return rentalService.getCustomers();
    }
}
