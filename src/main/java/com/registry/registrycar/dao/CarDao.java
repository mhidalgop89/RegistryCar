package com.registry.registrycar.dao;

import com.registry.registrycar.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path="cars")
public interface CarDao extends PagingAndSortingRepository<Car,Long>, CrudRepository<Car,Long> {

    public Car findCarByPlate(String plate);
}
