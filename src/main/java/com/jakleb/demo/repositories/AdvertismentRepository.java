package com.jakleb.demo.repositories;

import com.jakleb.demo.entities.Advertisment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertismentRepository extends CrudRepository<Advertisment, Long>{
}