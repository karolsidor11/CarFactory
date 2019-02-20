package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Chassis;

import java.util.List;
import java.util.Optional;

public interface ChassisService {

    List<Chassis> findAll();

    Chassis findById(int id);
}
