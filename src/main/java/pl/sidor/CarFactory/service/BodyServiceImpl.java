package pl.sidor.CarFactory.service;

import models.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class BodyServiceImpl implements BodyService {

    private RestTemplate template;
    private static final String AUTO_PART_URL = "http://localhost:8080/";

    @Autowired
    public BodyServiceImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Body> findAll() {

        ResponseEntity<List<Body>> exchange = getAllBodyFromAutoParts();

        if (!exchange.getBody().isEmpty()) {
            return exchange.getBody();
        } else {
            return Collections.emptyList();
        }
    }

    private ResponseEntity<List<Body>> getAllBodyFromAutoParts() {
        return template.exchange(AUTO_PART_URL + "bodies", HttpMethod.GET, null, new ParameterizedTypeReference<List<Body>>() {
        });
    }

    @Override
    public Body findById(int id) {

        ResponseEntity<Body> exchange = getBodyFromAutoParts(AUTO_PART_URL + "body/" + id);

        return exchange.getBody();

    }

    private ResponseEntity<Body> getBodyFromAutoParts(String url) {
        return template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Body>() {
        });
    }

}

