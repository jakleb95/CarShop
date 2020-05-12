package com.jakleb.demo.repository;

import com.jakleb.demo.entities.CarDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailsRepository extends CrudRepository<CarDetails, Long> {
}