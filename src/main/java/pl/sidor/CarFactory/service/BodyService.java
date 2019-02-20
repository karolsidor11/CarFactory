package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Body;

import java.util.List;

public interface BodyService {

    List<Body> findAll();

    Body findById(int id);
}
