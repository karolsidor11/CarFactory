package pl.sidor.CarFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.EngineService;

import java.util.List;
import java.util.Optional;

@RestController
public class EngineResourceController {


    private EngineService engineService;

    @Autowired
    public EngineResourceController(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping(value = "allEngine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Engine>> getAllEngine() {

        List<Engine> engines = engineService.findAll().get();

        HttpStatus httpStatus = engines != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(engines, httpStatus);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> getByID(@PathVariable int id) {

        Optional<Engine> first = engineService.findAll().get().stream().filter(engine -> engine.getId() == id).findFirst();

        HttpStatus httpStatus = first.get() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(first.get(), httpStatus);

    }
}
