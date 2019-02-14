package pl.sidor.CarFactory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.CarFactory.model.Car;

import java.util.Optional;

@Repository
public interface CarDao extends CrudRepository<Car, Integer> {

//    List<Car> findByName(String name);

    Car findByModel(String name);

    Optional<Car> findByName(String name);
}
