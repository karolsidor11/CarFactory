package pl.sidor.CarFactory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.CarFactory.model.Chassis;

@Repository
public interface ChassisDao extends CrudRepository<Chassis, Integer> {
}
