package pl.sidor.CarFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.CarService;

import java.util.List;

@RestController
public class EngineResourceController {


    private CarService carService;

    @Autowired
    public EngineResourceController(CarService carService) {
        this.carService = carService;
    }


    @RequestMapping(value = "getEngine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> getAllEngine() {
        List<Engine> all = carService.findAll();

        all.stream().forEach(engine -> System.out.println(engine.getPower()));


        return new ResponseEntity<>(all, HttpStatus.OK);


    }
}
