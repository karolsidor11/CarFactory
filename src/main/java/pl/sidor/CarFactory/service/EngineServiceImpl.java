package pl.sidor.CarFactory.service;

import models.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {

    private RestTemplate template;
    private static final String AUTO_PART_URL = "http://localhost:8080/";

    @Autowired
    public EngineServiceImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Engine> findAll() {

        ResponseEntity<List<Engine>> exchange = getListEngine();

        return !exchange.getBody().isEmpty() ? exchange.getBody() : Collections.emptyList();

    }

    private ResponseEntity<List<Engine>> getListEngine() {
        return template.exchange(AUTO_PART_URL + "engines", HttpMethod.GET, null, new ParameterizedTypeReference<List<Engine>>() {
        });
    }

    @Override
    public Engine findById(int id) {
        ResponseEntity<Engine> exchange1 = getEngineByID(id);

        return exchange1.getBody();
    }

    private ResponseEntity<Engine> getEngineByID(int id) {
        return template.exchange(AUTO_PART_URL + "engine/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Engine>() {
        });
    }
}
