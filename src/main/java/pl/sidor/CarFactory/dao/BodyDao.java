package pl.sidor.CarFactory.dao;

import models.Body;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyDao extends CrudRepository<Body, Integer> {

}
