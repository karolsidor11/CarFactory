package pl.sidor.CarFactory.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;

@Repository
public interface EngineDao extends CrudRepository<Engine, Integer> {

}
