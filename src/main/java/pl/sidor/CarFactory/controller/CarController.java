package pl.sidor.CarFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sidor.CarFactory.dao.CarDao;
import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.BodyService;
import pl.sidor.CarFactory.service.ChassisService;
import pl.sidor.CarFactory.service.EngineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarDao carDao;
    private EngineService engineService;
    private BodyService bodyService;
    private ChassisService chassisService;

    @Autowired
    public CarController(CarDao carDao, EngineService engineService, BodyService bodyService, ChassisService chassisService) {
        this.carDao = carDao;
        this.engineService = engineService;
        this.bodyService = bodyService;
        this.chassisService = chassisService;
    }

    @GetMapping(value = "/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@PathVariable String name) {

        Optional<Car> byName = carDao.findByName(name);

        HttpStatus httpStatus = byName.get() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(byName.get(), httpStatus);
    }



    @RequestMapping(value = "listCar", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Car> getAllCars() {

        return (List<Car>) carDao.findAll();
    }



    @RequestMapping(value = "produce/{count}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> produce(@PathVariable int count) {

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Car car = new Car();
            car.setName("Audi");
            car.setEngine(engineService.findAll().get().get(1));
            car.setColor("Blue");
            car.setBody(bodyService.findById(2).get());
            car.setChassis(chassisService.findById(2).get());
            car.setId(i);
            car.setModel("A7");
            carList.add(car);

//            carDao.save(car);

        }

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }


}
