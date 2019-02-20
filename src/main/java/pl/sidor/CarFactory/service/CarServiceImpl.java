package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.CarDao;
import pl.sidor.CarFactory.model.Car;

import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static final String AUTO_PARTS_URL = "http://localhost:8080/";
    private RestTemplate restTemplate;

    @Autowired
    public CarServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Car> findAll() {

        ResponseEntity<List<Car>> exchange1 = getCarsFromAutoParts();

        if (!exchange1.getBody().isEmpty()) {
            return exchange1.getBody();
        } else {
            return Collections.emptyList();
        }
    }

    private ResponseEntity<List<Car>> getCarsFromAutoParts() {
        return getCars();
    }

    private ResponseEntity<List<Car>> getCars() {
        return restTemplate.exchange(AUTO_PARTS_URL + "cars", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Car>>() {
        });
    }

    @Override
    public Car saveCar(Car car) {

        return restTemplate.postForObject(AUTO_PARTS_URL + "save", car, Car.class);

    }

}
