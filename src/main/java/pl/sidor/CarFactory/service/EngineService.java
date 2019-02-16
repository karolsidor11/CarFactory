package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Engine;

import java.util.List;
import java.util.Optional;

public interface EngineService {

    Optional<List<Engine>> findAll();

    Engine findById(int id);

    List<Engine> findByPower(int power);

}
