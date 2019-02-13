package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.model.Car;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private RestTemplate restTemplate;

    @Autowired
    public CarServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
}
