package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Engine;

import java.util.List;

public interface EngineService {

    List<Engine> findAll();

    Engine findById(int id);

    List<Engine> findByPower(int power);

}
