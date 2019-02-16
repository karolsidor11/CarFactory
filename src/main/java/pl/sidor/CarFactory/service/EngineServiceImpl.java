package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.EngineDao;
import pl.sidor.CarFactory.model.Engine;
import pl.sidor.CarFactory.service.EngineService;

import java.util.List;
import java.util.Optional;

@Service
public class EngineServiceImpl implements EngineService {

    private EngineDao engineDao;
    private RestTemplate template;

    @Autowired
    public EngineServiceImpl(EngineDao engineDao, RestTemplate template) {
        this.engineDao = engineDao;
        this.template = template;
    }

    @Override
    public Optional<List<Engine>> findAll() {

        ResponseEntity<List<Engine>> exchange = template.exchange("http://localhost:8080/allEngine", HttpMethod.GET, null, new ParameterizedTypeReference<List<Engine>>() {
        });

        if (exchange.getBody() != null) {
            return Optional.of(exchange.getBody());
        } else {
            return Optional.empty();
        }


    }

    @Override
    public Engine findById(int id) {
        return engineDao.findById(id);
    }

    @Override
    public List<Engine> findByPower(int power) {

        ResponseEntity<List<Engine>> exchange = template.exchange("http://localhost:8080/moc/" + power, HttpMethod.GET, null, new ParameterizedTypeReference<List<Engine>>() {
        });
        return exchange.getBody();
    }
}
