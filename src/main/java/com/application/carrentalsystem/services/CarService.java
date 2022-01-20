package com.application.carrentalsystem.services;

import com.application.carrentalsystem.models.Car;
import com.application.carrentalsystem.models.CarType;
import com.application.carrentalsystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> saveCars(List<Car> cars) {
        return carRepository.saveAll(cars);
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsThatNeedInsuranceRenewalBefore(Date after) {
        return carRepository.findCarsByInsuranceExpiryDateBetween(new Date(System.currentTimeMillis()), after);
    }

    public List<Car> getCarsWithTypeThatNeedReviewBefore(Date after, CarType carType) {
        return carRepository.findCarsByRevisionDateBetweenAndManufacturer(new Date(System.currentTimeMillis()), after, carType);
    }

    public List<Car> getCarsThatNeedInsuranceRenewal() {
        return carRepository.findCarsByInsuranceExpiryDateBefore(new Date(System.currentTimeMillis()));
    }

    public List<Car> getCarsWithTypeThatNeedReview(CarType carType) {
        return carRepository.findCarsByRevisionDateBeforeAndManufacturer(new Date(System.currentTimeMillis()), carType);
    }


    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getCarId()).orElse(null);
        existingCar.setManufacturer(car.getManufacturer());
        existingCar.setCategory(car.getCategory());
        existingCar.setModel(car.getModel());
        existingCar.setProductionYear(car.getProductionYear());
        existingCar.setPlateNr(car.getPlateNr());
        existingCar.setRegistrationNr(car.getRegistrationNr());
        existingCar.setInsuranceExpiryDate(car.getInsuranceExpiryDate());
        existingCar.setRevisionDate(car.getRevisionDate());

        return carRepository.save(existingCar);
    }

    public String deleteCar(int id) {
        carRepository.deleteById(id);
        return "Car deleted " + id;
    }


}
