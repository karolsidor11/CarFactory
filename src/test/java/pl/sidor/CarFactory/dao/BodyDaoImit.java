//package pl.sidor.CarFactory.dao;
//
//import models.Body;
//import pl.sidor.CarFactory.service.BodyService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BodyDaoImit implements BodyService {
//
//    private List<Body> bodyList = new ArrayList<>();
//
//    public BodyDaoImit() {
//
//        bodyList.add(new Body(1, "Avant", "Black", 4));
//        bodyList.add(new Body(2, "Avant", "Black", 5));
//        bodyList.add(new Body(3, "Combi", "Black", 5));
//        bodyList.add(new Body(4, "Hatchback", "Black", 4));
//    }
//
//    @Override
//    public List<Body> findAll() {
//
//        return bodyList;
//    }
//
//    @Override
//    public Body findById(int id) {
//        return bodyList.stream().filter(body -> body.getId() == id).findFirst().get();
//    }
//}
