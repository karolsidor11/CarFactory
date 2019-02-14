package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.CarDao;
import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {


    private RestTemplate restTemplate;
    private CarDao carDao;

    @Autowired
    public CarServiceImpl(RestTemplate restTemplate, CarDao carDao) {
        this.restTemplate = restTemplate;
        this.carDao = carDao;
    }

    @Override
    public List<Engine> findAll() {

        ResponseEntity<List<Engine>> exchange = restTemplate.exchange("http://localhost:8080/allEngine", HttpMethod.GET, null, new ParameterizedTypeReference<List<Engine>>() {
        });


        return exchange.getBody();
    }

    @Override
    public Car createCar(int count) {

        Car car = new Car();

//        car.setEngine(engineService.getEngine());


        return null;
    }

    @Override
    public Optional<Car> findByName(String name) {
        Optional<Car> byName = carDao.findByName(name);

        return byName;
    }
}
