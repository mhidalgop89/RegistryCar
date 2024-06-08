package com.registry.registrycar.service;

import com.registry.registrycar.dao.CarDao;
import com.registry.registrycar.dto.response.CarResponse;
import com.registry.registrycar.entity.Car;
import com.registry.registrycar.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Calendar.*;

@Service
public class CarService {

    @Autowired
    CarDao carDao;

    private static String NOT_VALID = "No esta permitido";
    private static String VALID = "permitido";
    public List<Car> getAllCars(){
        return Streamable.of(carDao.findAll()).toList();//  IteratorUtils carDao.findAll().;
    }

    public CarResponse getInfo(String plate, String dateParam) throws ParseException {
        Util util = new Util();
        Date date = util.getLocalFormatEcDateToDate(dateParam);
        String lastDigit = plate.substring(plate.length()-1);

        CarResponse carResponse = new CarResponse();
        if(isAllowed(lastDigit,date)){
            carResponse.setMessage(VALID);
        }else{
            carResponse.setMessage(NOT_VALID);
        }
        Car car = carDao.findCarByPlate(plate);
        carResponse.setCar(car);

        return carResponse;
    }

    private boolean isAllowed(String lastDigit, Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Util util = new Util();
        boolean isAllowed = Boolean.TRUE;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if( (date.after(util.earlyMorningLimit(date)) && date.before(util.latestMorningLimit(date))) ||
                (date.after(util.earlyAfterNoonLimit(date)) && date.before(util.latestAfterNoonLimit(date))) ){
            if(util.getAllowedPlatesByDay(day).stream().anyMatch(digit -> digit.equals(lastDigit))){
                isAllowed = Boolean.FALSE;
            }
        }
        return isAllowed;
    }

}
