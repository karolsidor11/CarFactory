package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.BodyDao;
import pl.sidor.CarFactory.model.Body;
import pl.sidor.CarFactory.service.BodyService;

import java.util.List;
import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {

    private BodyDao bodyDao;
    private RestTemplate template;

    @Autowired
    public BodyServiceImpl(BodyDao bodyDao, RestTemplate template) {
        this.bodyDao = bodyDao;
        this.template = template;
    }

    @Override
    public Optional<List<Body>> findAll() {

//        template.exchange("http://localhost:8080/")

        return null;
    }

    @Override
    public Optional<Body> findById(int id) {

        ResponseEntity<Body> exchange = template.exchange("http://localhost:8080/chassis/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Body>() {
        });

        if (exchange.getBody() != null) {
            return Optional.ofNullable(exchange.getBody());
        } else {
            return Optional.empty();
        }


    }
}
