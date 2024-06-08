package com.registry.registrycar.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plate;
    private String color;
    private String model;
    private String chassis;
    private String proprietary;
}
