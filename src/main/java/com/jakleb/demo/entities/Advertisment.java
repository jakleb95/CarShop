package com.jakleb.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertisment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UserDetails user;

    private LocalDate date;

    private Car car;
}
