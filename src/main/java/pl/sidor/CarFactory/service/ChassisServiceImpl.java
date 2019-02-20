package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.model.Chassis;

import java.util.Collections;
import java.util.List;

@Service
public class ChassisServiceImpl implements ChassisService {

    private RestTemplate template;
    private static final String AUTO_PARTS_URL = "http://localhost:8080/";

    @Autowired
    public ChassisServiceImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Chassis> findAll() {

        ResponseEntity<List<Chassis>> exchange1 = getChassisFromAutoParts();

        if (!exchange1.getBody().isEmpty()) {
            return exchange1.getBody();
        } else {
            return Collections.emptyList();
        }
    }

    private ResponseEntity<List<Chassis>> getChassisFromAutoParts() {
        return template.exchange(AUTO_PARTS_URL + "chassis", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Chassis>>() {
        });
    }

    @Override
    public Chassis findById(int id) {

        ResponseEntity<Chassis> exchange = getChassisByIdFromAutoParts(id);
        return exchange.getBody();
    }

    private ResponseEntity<Chassis> getChassisByIdFromAutoParts(int id) {
        return template.exchange(AUTO_PARTS_URL +"chassis/"+ id, HttpMethod.GET,
                null, new ParameterizedTypeReference<Chassis>() {
        });
    }
}
