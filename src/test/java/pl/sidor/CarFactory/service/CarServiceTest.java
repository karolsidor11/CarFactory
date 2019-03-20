//package pl.sidor.CarFactory.service;
//
//import org.junit.Test;
//import pl.sidor.CarFactory.dao.CarDaoImit;
//import pl.sidor.CarFactory.models.Car;
//import pl.sidor.CarFactory.models.Engine;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class CarServiceTest {
//
//    private Car car;
//    private CarDaoImit carDaoImit;
//
//    public CarServiceTest() {
//        carDaoImit = new CarDaoImit();
//    }
//
//    @Test
//    public void shouldListEngine() {
//
//        List<Engine> all = carDaoImit.findAll();
//
//        assertEquals(4, all.size());
//    }
//
//    @Test
//    public void shouldFindCarList() {
//
//        Optional<List<Car>> allCars = carDaoImit.findAllCars();
//
//        assertNotNull(allCars.get());
//        assertEquals(2, allCars.get().size());
//    }
//
//    @Test
//    public void shouldCarByName() {
//
//        Optional<Car> audi = carDaoImit.findByName("Audi");
//
//        assertNotNull(audi);
//        assertEquals("Audi", audi.get().getName());
//    }
//
//    @Test
//    public void createCarInLoop() {
//
//        Car car = carDaoImit.createCar(2);
//
//        Optional<List<Car>> allCars = carDaoImit.findAllCars();
//
//        allCars.get().add(car);
//
//        assertEquals(5, carDaoImit.findAllCars().get().size());
//
//    }
//}
