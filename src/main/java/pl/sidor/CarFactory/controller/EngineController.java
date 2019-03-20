package pl.sidor.CarFactory.controller;

import models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.service.EngineService;

import java.util.List;
import java.util.Optional;

@RestController
public class EngineController {

    private EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(value = "allEngine", method = RequestMethod.GET, name = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> getAllEngines() {

        Optional<List<Engine>> all = getEnginesFromAutoParts();

        HttpStatus httpStatus = HttpStatus.OK;

        return all.map(engines -> new ResponseEntity<>(all.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    private Optional<List<Engine>> getEnginesFromAutoParts() {
        return Optional.ofNullable(engineService.findAll());
    }

    @RequestMapping(value = "engine/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> getEngineById(@PathVariable int id) {
        Optional<Engine> byId1 = getEngineByIdFromAutoParts(id);

        HttpStatus httpStatus = HttpStatus.OK;

        return byId1.map(engine -> new ResponseEntity<>(byId1.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    private Optional<Engine> getEngineByIdFromAutoParts(@PathVariable int id) {

        return Optional.ofNullable(engineService.findById(id));
    }
}
