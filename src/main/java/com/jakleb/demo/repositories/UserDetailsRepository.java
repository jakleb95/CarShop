package com.jakleb.demo.repositories;

import com.jakleb.demo.entities.UserDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
}