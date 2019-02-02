package pl.sidor.CarFactory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.model.Car;

@RestController
public class CarController {

    @GetMapping(value = "/getCar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCar(@RequestBody String name) {

        Car car = new Car();
        car.setName("Audi");
        if (name.equals(car.getName())) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
