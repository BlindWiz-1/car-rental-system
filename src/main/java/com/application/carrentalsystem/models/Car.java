package com.application.carrentalsystem.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "car")
public class Car {

    @Enumerated(EnumType.STRING)
    private CarType manufacturer;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String model;
    private int productionYear;
    private String plateNr;
    private String registrationNr;
    private Date insuranceExpiryDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private Date revisionDate;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    public Car() {
    }

    public CarType getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarType manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getPlateNr() {
        return plateNr;
    }

    public void setPlateNr(String plateNr) {
        this.plateNr = plateNr;
    }

    public String getRegistrationNr() {
        return registrationNr;
    }

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr;
    }

    public Date getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public void setInsuranceExpiryDate(Date insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public int getCarId() {
        return carId;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }
}
