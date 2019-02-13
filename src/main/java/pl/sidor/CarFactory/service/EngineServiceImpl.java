package pl.sidor.CarFactory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sidor.CarFactory.dao.EngineDao;
import pl.sidor.CarFactory.model.Engine;

import java.util.List;

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
    public List<Engine> findAll() {
        return (List<Engine>) engineDao.findAll();
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
