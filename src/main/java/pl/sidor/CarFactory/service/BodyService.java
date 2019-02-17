package pl.sidor.CarFactory.service;

import pl.sidor.CarFactory.model.Body;

import java.util.List;
import java.util.Optional;

public interface BodyService {

    Optional<List<Body>> findAll();

    Optional<Body> findById(int id);
}
