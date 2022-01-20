package com.application.carrentalsystem.repositories;

import com.application.carrentalsystem.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findAllByRentStartDateIsBefore(Date date);
}
