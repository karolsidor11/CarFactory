package pl.sidor.CarFactory.controller;


import models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sidor.CarFactory.service.BodyService;
import pl.sidor.CarFactory.service.CarService;
import pl.sidor.CarFactory.service.ChassisService;
import pl.sidor.CarFactory.service.EngineService;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarService carService;
    private EngineService engineService;
    private BodyService bodyService;
    private ChassisService chassisService;

    @Autowired
    public CarController(CarService carService, EngineService engineService, BodyService bodyService, ChassisService chassisService) {
        this.carService = carService;
        this.engineService = engineService;
        this.bodyService = bodyService;
        this.chassisService = chassisService;
    }

    @GetMapping(value = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCarById(@PathVariable int id) {

        Optional<Car> first = findCarById(id);

        HttpStatus httpStatus = HttpStatus.OK;

        return first.map(car -> new ResponseEntity<>(car, httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    private Optional<Car> findCarById(@PathVariable int id) {
        return carService.findAll().stream().filter(car -> car.getId() == id).findFirst();
    }


    @RequestMapping(value = "listCar", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity getAllCars() {

        Optional<List<Car>> allCars = Optional.ofNullable(carService.findAll());

        HttpStatus httpStatus = HttpStatus.OK;

        return allCars.map(cars -> new ResponseEntity(allCars.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    @RequestMapping(value = "produce/{count}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity produce(@PathVariable int count) {

        Optional<List<Car>> all = Optional.ofNullable(carService.findAll());

        todoDoService(count, all);

        return all.map(cars -> new ResponseEntity(all, HttpStatus.OK)).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));

    }

    private void todoDoService(@PathVariable int count, Optional<List<Car>> all) {
        for (int i = 0; i < count; i++) {
            Car newCar = createNewCar();
            if (all.isPresent()) {
                all.get().add(newCar);
                carService.saveCar(newCar);
            }
        }
    }

    private Car createNewCar() {
        Car.CarBuilder builder = Car.builder();

        builder.id(1);
        Optional.ofNullable(bodyService.findById(1)).ifPresent(builder::body);
        Optional.ofNullable(engineService.findById(1)).ifPresent(builder::engine);
        Optional.ofNullable(chassisService.findById(1)).ifPresent(builder::chassis);
        builder.color("Red").models("S60").name("Volvo");

        return builder.build();
    }

    @RequestMapping(value = "produceCar/{mark}/{model}/{color}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> produce(@PathVariable String mark, @PathVariable String model, @PathVariable String color) {

        Car build = createCarByURL(model, mark, color);
        carService.saveCar(build);

        return new ResponseEntity<Car>(build, HttpStatus.OK);
    }

    private Car createCarByURL(String model, String mark, String color) {

        Car.CarBuilder builder = Car.builder();

        builder.id(8);
        builder.name(mark).models(model).color(color);
        Optional.ofNullable(engineService.findById(1)).ifPresent(builder::engine);
        Optional.ofNullable(bodyService.findById(1)).ifPresent(builder::body);
        Optional.ofNullable(chassisService.findById(1)).ifPresent(builder::chassis);

        return builder.build();
    }
}
