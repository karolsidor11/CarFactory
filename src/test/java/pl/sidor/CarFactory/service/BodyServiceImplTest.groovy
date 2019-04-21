package pl.sidor.CarFactory.service

import models.Body
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class BodyServiceImplTest extends Specification {

    private RestTemplate restTemplate
    private BodyService bodyService
    private static final String AUTO_PART_URL = "http://localhost:8080/"

    void setup() {
        restTemplate = Mock(RestTemplate)
        bodyService = new BodyServiceImpl(restTemplate)
    }

    def "should  find Body by ID"() {
        given:
        Body body = new Body.BodyBuilder().id(1).bodyCar("Avant").build()
        restTemplate.exchange(AUTO_PART_URL + "body/1", HttpMethod.GET, null, new ParameterizedTypeReference<Body>() {
        }) >> ResponseEntity.ok(body)

        when:
        Body exchange = bodyService.findById(1)

        then:
        exchange != null
        exchange == body
    }

    def "should return list Body"() {
        given:
        List<Body> bodyList = new ArrayList<>()
        Body body1 = new Body.BodyBuilder().id(1).bodyCar("Avant").build()
        Body body2 = new Body.BodyBuilder().id(2).bodyCar("Hatchback").build()
        Body body3 = new Body.BodyBuilder().id(3).bodyCar("Back").build()
        bodyList.add(body1)
        bodyList.add(body2)
        bodyList.add(body3)

        restTemplate.exchange(AUTO_PART_URL + "bodies", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Body>>() {}) >> ResponseEntity.ok(bodyList)

        when:
        List<Body> actualBodyList = bodyService.findAll()
        then:
        actualBodyList != null
        actualBodyList.size() == 3
        actualBodyList == bodyList

    }

    def "should return  404 error"() {
        given:
        Integer id = -1

        restTemplate.exchange(AUTO_PART_URL + "body/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Body>() {
        }) >> new ResponseEntity<Body>(null, HttpStatus.NOT_FOUND)

        when:
        Body bodyActual = bodyService.findById(id)

        then:
        bodyActual == null
//        todo  jak sprawdzić status  HTTP 404
    }
}
