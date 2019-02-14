package pl.sidor.CarFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sidor.CarFactory.dao.CarDao;
import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.EngineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private CarDao carDao;
    @Autowired
    private EngineService engineService;


    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
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
            car.setEngine(null);
            car.setColor("Blue");
            car.setBody(null);
            car.setChassis(null);
            car.setId(i);
            car.setModel("A7");
            carList.add(car);
            carDao.save(car);

        }

        return new ResponseEntity<>(carList, HttpStatus.OK);
    }


}
