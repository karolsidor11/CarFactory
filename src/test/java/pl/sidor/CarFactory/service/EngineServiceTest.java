//package pl.sidor.CarFactory.service;
//
//import org.junit.Test;
//import pl.sidor.CarFactory.dao.EngineDaoImit;
//import pl.sidor.CarFactory.model.Engine;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class EngineServiceTest {
//
//    private EngineDaoImit engineDaoImit;
//    private Engine engine;
//
//    public EngineServiceTest() {
//        engineDaoImit = new EngineDaoImit();
//        engine = new Engine(5, 3, 120, 200);
//
//    }
//
//    @Test
//    public void shouldGetEngineListSize() {
//        Optional<List<Engine>> all = engineDaoImit.findAll();
//
//        assertEquals(4, all.get().size());
//    }
//
//
//    @Test
//    public void shouldCheckList() {
//        Optional<List<Engine>> all = engineDaoImit.findAll();
//
//        assertNotNull(all.get());
//    }
//
//    @Test
//    public void shouldFindEngineByID() {
//
//        Engine byId = engineDaoImit.findById(0);
//
//        assertNotNull(byId);
//        assertEquals(1, byId.getId());
//    }
//
//    @Test
//    public void shouldFindByPower() {
//
//        List<Engine> byPower = engineDaoImit.findByPower(220);
//
//        assertNotNull(byPower);
//        assertEquals(220, byPower.get(0).getPower());
//    }
//
//}
