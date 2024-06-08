package com.registry.registrycar.controller;

import com.registry.registrycar.dto.response.CarResponse;
import com.registry.registrycar.entity.Car;
import com.registry.registrycar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/registry")
public class CarCreationController {

    @Autowired
    CarService carService;

    //@CrossOrigin(origins = "http://localhost:4200")
    //@CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/all-cars")
    public ResponseEntity<List<Car>> getAllCars(){

        return new ResponseEntity<>(
                carService.getAllCars(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/{plate}")
    public ResponseEntity<CarResponse> getInfo(@PathVariable String plate, @RequestParam(name = "date") String date)  {
        try {
            return new ResponseEntity<>(
                    carService.getInfo(plate, date),
                    HttpStatus.OK);
        } catch (ParseException e) {
            CarResponse carError = new CarResponse();
            carError.setMessage("Error interno");
            return new ResponseEntity<>(
                    carError,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
