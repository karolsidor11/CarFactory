package pl.sidor.CarFactory.service;


import models.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car saveCar(Car car);

}
