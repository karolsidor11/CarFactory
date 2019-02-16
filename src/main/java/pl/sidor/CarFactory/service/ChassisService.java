package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Chassis;

import java.util.List;
import java.util.Optional;

public interface ChassisService {

    Optional<List<Chassis>> findAll();

    Optional<Chassis> findById(int id);
}
