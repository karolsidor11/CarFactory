package pl.sidor.CarFactory.dao;

import pl.sidor.CarFactory.model.Body;
import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Chassis;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDaoImit implements CarService {


    private List<Car> carList = new ArrayList<>();
    private EngineDaoImit engineDaoImit;


    public CarDaoImit() {
        carList.add(new Car(1,"Audi","A6",new Engine(3,2.5,220,240),
                new Body(5, "Avant", "Biały", 7),
                new Chassis(2, "Quattro", "Derm", "Bilstein", "McPerson"),"Blue"));

        carList.add(new Car(2,"Bmw","M3",new Engine(3,2.5,220,240),
                new Body(5, "Touring", "Biały", 7),
                new Chassis(2, "XDrive", "Derm", "Bilstein", "McPerson"),"Blue"));
        engineDaoImit= new EngineDaoImit();
    }

    @Override
    public List<Engine> findAll() {
        return engineDaoImit.findAll().get();
    }

    @Override
    public Car createCar(int count) {

        for(int i=0; i<count;i++){
            carList.add(new Car(1,"Audi","A6",new Engine(3,2.5,220,240),
                    new Body(5, "Avant", "Biały", 7),
                    new Chassis(2, "Quattro", "Derm", "Bilstein", "McPerson"),"Blue"));
        }
        return null;
    }

    @Override
    public Optional<Car> findByName(String name) {
        return Optional.ofNullable(carList.stream().filter(car -> car.getName().equals(name)).findFirst().get());
    }

    @Override
    public Optional<Car> saveCar(Car car) {
        carList.add(car);
        return Optional.ofNullable(car);
    }

    @Override
    public Optional<List<Car>> findAllCars() {

        return Optional.ofNullable(carList);
    }
}
