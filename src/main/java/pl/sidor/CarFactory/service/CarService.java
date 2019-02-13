package pl.sidor.CarFactory.service;


import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;

public interface CarService {

    List<Engine> findAll();

    Car createCar(int count);

}
