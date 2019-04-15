package pl.sidor.CarFactory.service

import models.Engine
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class EngineServiceImplTest extends Specification {

    private RestTemplate restTemplate
    private EngineService engineService
    private static final String AUTO_PART_URL = "http://localhost:8080/"

    void setup() {
        restTemplate = Mock(RestTemplate)
        engineService = new EngineServiceImpl(restTemplate)
    }

    def "should return Engine by ID"() {

        given:
        Integer id = 1
        Engine engine = new Engine.EngineBuilder().id(1).torque(22).capacity(200).build()

        restTemplate.exchange(AUTO_PART_URL + "engine/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Engine>() {
        }) >>
                ResponseEntity.ok(engine)

        when:
        Engine actualEngine = engineService.findById(id)

        then:
        actualEngine != null
        actualEngine == engine
    }

    def "should return Engine List"() {
        given:

        List<Engine> engineList = new ArrayList<>();
        Engine engine1 = new Engine.EngineBuilder().id(1).torque(22).capacity(120).build()
        Engine engine2 = new Engine.EngineBuilder().id(2).torque(222).capacity(110).build()
        Engine engine3 = new Engine.EngineBuilder().id(3).torque(232).capacity(130).build()
        Engine engine4 = new Engine.EngineBuilder().id(4).torque(224).capacity(140).build()

        engineList.add(engine1)
        engineList.add(engine2)
        engineList.add(engine3)
        engineList.add(engine4)

        restTemplate.exchange(AUTO_PART_URL + "engines", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Engine>>() {}) >> ResponseEntity.ok(engineList)

        when:
        List<Engine> actualEngines = engineService.findAll()

        then:
        actualEngines!=null
        actualEngines==engineList
        actualEngines.size()==4
    }
}
