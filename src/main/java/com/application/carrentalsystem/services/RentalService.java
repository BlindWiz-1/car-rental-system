package com.application.carrentalsystem.services;

import com.application.carrentalsystem.models.Car;
import com.application.carrentalsystem.models.Person;
import com.application.carrentalsystem.models.Rental;
import com.application.carrentalsystem.repositories.CarRepository;
import com.application.carrentalsystem.repositories.PersonRepository;
import com.application.carrentalsystem.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class RentalService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RentalRepository rentalRepository;

    public List<Car> getCarsRented(){
        LocalDate today = LocalDate.now();
        today = today.withDayOfMonth(today.getMonth().length(today.isLeapYear()));

        List<Car> cars = new ArrayList<>();
        List<Rental> rentals = rentalRepository.findAllByRentStartDateIsBefore(Date.valueOf(today));
        for (Rental rental : rentals){
            cars.add(carRepository.findCarByCarId(rental.getCar().getCarId()));
        }
        return cars;
    }

    public Set<Person> getCustomers(){
        Set<Person> customers = new LinkedHashSet<>();
        List<Rental> rentals = rentalRepository.findAll();

        for (Rental rental : rentals){
            customers.add(personRepository.findPersonByPersonalid(rental.getPerson().getPersonalId()));
        }
        return customers;
    }

}
