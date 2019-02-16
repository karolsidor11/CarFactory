package pl.sidor.CarFactory.service;


import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Engine> findAll();

    Car createCar(int count);

    Optional<Car> findByName(String name);

    Optional<Car> saveCar(Car car);

}
