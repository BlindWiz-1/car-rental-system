package com.application.carrentalsystem.controllers;

import com.application.carrentalsystem.models.Car;
import com.application.carrentalsystem.models.CarType;
import com.application.carrentalsystem.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public Car addCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/cars")
    public List<Car> findAllCars(){
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    public Car findCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @GetMapping("/carsOfTypeNeedRevisionBefore/{date}/{type}")
    public List<Car> findCarsThatNeedRevisionBefore(@PathVariable String date, @PathVariable String type){
        return carService.getCarsWithTypeThatNeedReviewBefore( Date.valueOf(date), Enum.valueOf(CarType.class, type) );
    }

    @GetMapping("/carsNeedInsuranceBefore/{date}")
    public List<Car> findCarsThatNeedInsuranceBefore(@PathVariable String date){
        return carService.getCarsThatNeedInsuranceRenewalBefore(Date.valueOf(date));
    }

    @GetMapping("/carsOfTypeNeedRevision/{type}")
    public List<Car> findCarsThatNeedRevision(@PathVariable String type){
        return carService.getCarsWithTypeThatNeedReview(Enum.valueOf(CarType.class, type) );
    }

    @GetMapping("/carsNeedInsurance")
    public List<Car> findCarsThatNeedInsurance(){
        return carService.getCarsThatNeedInsuranceRenewal();
    }

}
