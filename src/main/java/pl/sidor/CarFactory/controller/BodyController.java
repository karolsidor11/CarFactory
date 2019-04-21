package pl.sidor.CarFactory.controller;

import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.service.BodyService;

import java.util.List;
import java.util.Optional;

@RestController
public class BodyController {

    private BodyService bodyService;

    @Autowired
    public BodyController(BodyService bodyService) {
        this.bodyService = bodyService;
    }

    @RequestMapping(value = "bodyList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Body>> findAllBody() {

        Optional<List<Body>> all = getBodies();

        HttpStatus httpStatus = HttpStatus.OK;

        return all.map(bodies -> new ResponseEntity<>(all.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    private Optional<List<Body>> getBodies() {
        return Optional.ofNullable(bodyService.findAll());
    }

    @RequestMapping(value = "body/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Body> getBodyByID(@PathVariable int id) {

        Optional<Body> byId = getBodyFromID(id);

        HttpStatus httpStatus = HttpStatus.OK;

        return byId.map(body -> new ResponseEntity<>(byId.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));
    }

    private Optional<Body> getBodyFromID(@PathVariable int id) {
        return Optional.ofNullable(bodyService.findById(id));
    }
}
