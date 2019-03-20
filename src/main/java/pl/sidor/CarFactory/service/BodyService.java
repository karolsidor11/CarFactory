package pl.sidor.CarFactory.service;

import models.Body;

import java.util.List;

public interface BodyService {

    List<Body> findAll();

    Body findById(int id);
}
