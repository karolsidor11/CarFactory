package pl.sidor.CarFactory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.CarFactory.model.Body;

@Repository
public interface BodyDao extends CrudRepository<Body, Integer> {

    Body findById(int id);
}
