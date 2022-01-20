package com.application.carrentalsystem.repositories;

import com.application.carrentalsystem.models.Car;
import com.application.carrentalsystem.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findCarsByInsuranceExpiryDateBetween(Date lower, Date upper);
    List<Car> findCarsByRevisionDateBetweenAndManufacturer(Date lower, Date upper, CarType carType);
    List<Car> findCarsByRevisionDateBeforeAndManufacturer(Date date, CarType carType);
    List<Car> findCarsByInsuranceExpiryDateBefore(Date date);
    Car findCarByCarId(Integer id);
}
