package pl.sidor.CarFactory.dao;

import pl.sidor.CarFactory.model.Body;
import pl.sidor.CarFactory.service.BodyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BodyDaoImit implements BodyService {

    private List<Body> bodyList= new ArrayList<>();

    public BodyDaoImit() {

        bodyList.add(new Body(1,"Avant", "Black", 4));
        bodyList.add(new Body(2,"Avant", "Black", 5));
        bodyList.add(new Body(3,"Combi", "Black", 5));
        bodyList.add(new Body(4,"Hatchback", "Black", 4));
    }

    @Override
    public Optional<List<Body>> findAll() {

        return Optional.ofNullable(bodyList);
    }

    @Override
    public Optional<Body> findById(int id) {
        return Optional.ofNullable(bodyList.get(id));
    }
}
