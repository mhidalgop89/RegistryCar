package com.registry.registrycar.dto;

import lombok.Data;

@Data
public class Vehicle {
    private Long id;
    private String plate;
    private String color;
    private String model;
    private String chassis;
    private String proprietary;


}
