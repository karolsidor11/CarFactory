package pl.sidor.CarFactory.service;

import models.Engine;

import java.util.List;

public interface EngineService {

    Engine findById(int id);

    List<Engine> findAll();

}
