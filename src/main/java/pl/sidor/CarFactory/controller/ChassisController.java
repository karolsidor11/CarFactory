package pl.sidor.CarFactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sidor.CarFactory.model.Chassis;
import pl.sidor.CarFactory.service.ChassisService;

import java.util.List;
import java.util.Optional;

@RestController
public class ChassisController {

    private ChassisService chassisService;

    @Autowired
    public ChassisController(ChassisService chassisService) {
        this.chassisService = chassisService;
    }

    @RequestMapping(value = "chassis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chassis>> getAllChassis() {
        Optional<List<Chassis>> all = getAllChassisFromAutoParts();

        HttpStatus httpStatus = HttpStatus.OK;

        return all.map(chassis -> new ResponseEntity<>(all.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));

    }

    private Optional<List<Chassis>> getAllChassisFromAutoParts() {

        return Optional.ofNullable(chassisService.findAll());
    }

    @RequestMapping(value = "chassis/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chassis> getChassisById(@PathVariable int id) {

        Optional<Chassis> byId = getChassisByIdFromAutoParts(id);

        HttpStatus httpStatus = HttpStatus.OK;

        return byId.map(chassis -> new ResponseEntity<>(byId.get(), httpStatus)).orElseGet(() -> new ResponseEntity<>(httpStatus));
    }

    private Optional<Chassis> getChassisByIdFromAutoParts(@PathVariable int id) {
        return Optional.ofNullable(chassisService.findById(id));
    }
}
