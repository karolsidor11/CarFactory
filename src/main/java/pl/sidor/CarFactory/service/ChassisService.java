package pl.sidor.CarFactory.service;

import models.Chassis;

import java.util.List;

public interface ChassisService {

    List<Chassis> findAll();

    Chassis findById(int id);
}
