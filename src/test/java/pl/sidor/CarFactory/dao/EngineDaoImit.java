//package pl.sidor.CarFactory.dao;
//
//import pl.sidor.CarFactory.model.Engine;
//import pl.sidor.CarFactory.service.EngineService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public class EngineDaoImit implements EngineService {
//
//    private  List<Engine> engines= new ArrayList<>();
//
//    public EngineDaoImit() {
//
//        engines.add(new Engine(1,2,120,210));
//        engines.add(new Engine(2,1,140,230));
//        engines.add(new Engine(3,2.5,220,240));
//        engines.add(new Engine(4,3,320,510));
//    }
//
//    @Override
//    public Optional<List<Engine>> findAll() {
//        return Optional.ofNullable(engines);
//    }
//
//    @Override
//    public Engine findById(int id) {
//        return engines.get(id);
//    }
//
//    @Override
//    public List<Engine> findByPower(int power) {
//        return engines.stream().filter(engine -> engine.getPower()==power).collect(Collectors.toList());
//    }
//}
