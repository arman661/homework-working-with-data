package com.sample.carmarket.app;

import com.sample.carmarket.entity.Car;
import com.sample.carmarket.entity.StatusType;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Component
public class CarService {

    @Autowired
    private DataManager dataManager;

    public Integer calculateGasolineCars(String engineType) {
        return dataManager.loadValue("select count(model) from Model model" +
                        " where model.engineType = :engineType", Integer.class)
                .parameter("engineType", engineType).one();
    }

    public String markAsSold(UUID id) {
        Car car = dataManager.load(Car.class).id(id).one();
        if(StatusType.SOLD.equals(car.getStatus())) {
            return "Already Sold";
        }
        car.setStatus(StatusType.SOLD);
        car.setDateOfSale(LocalDate.now());
        dataManager.save(car);
        return "Done";
    }
}