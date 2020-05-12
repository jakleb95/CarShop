package com.jakleb.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Car car;

    @NotNull
    private String voivodeship;

    @NotNull
    private String city;

    @NotNull
    private Integer mileage;

    @NotNull
    private Integer yearOfManufacture;

    @NotNull
    private String fuel;

    @NotNull
    private String kind;

    private String state;

    private String color;

    private Integer owner;

    private List<String> images;

}
