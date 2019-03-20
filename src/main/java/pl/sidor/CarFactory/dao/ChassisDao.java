package pl.sidor.CarFactory.dao;

import models.Chassis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChassisDao extends CrudRepository<Chassis, Integer> {
}
