package com.jakleb.demo.repositories;

import com.jakleb.demo.entities.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{
    
}