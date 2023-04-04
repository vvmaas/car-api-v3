package com.car.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.api.models.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
    
}
