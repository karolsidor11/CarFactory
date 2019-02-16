package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.ChassisDao;
import pl.sidor.CarFactory.model.Chassis;
import pl.sidor.CarFactory.service.ChassisService;

import java.util.List;
import java.util.Optional;

@Service
public class ChassisServiceImpl implements ChassisService {

    private ChassisDao chassisDao;
    private RestTemplate template;

    @Autowired
    public ChassisServiceImpl(ChassisDao chassisDao, RestTemplate template) {
        this.chassisDao = chassisDao;
        this.template = template;
    }

    @Override
    public Optional<List<Chassis>> findAll() {

        return null;
//        template.exchange("http://localhost:8080/")
    }


    @Override
    public Optional<Chassis> findById(int id) {

        ResponseEntity<Chassis> exchange = template.exchange("http://localhost:8080/chassis/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Chassis>() {
        });

       return Optional.ofNullable(exchange.getBody());
    }
}
