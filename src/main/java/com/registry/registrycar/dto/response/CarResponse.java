package com.registry.registrycar.dto.response;

import com.registry.registrycar.entity.Car;
import lombok.Data;

@Data
public class CarResponse {
    private Car car;
    private String message;
}
