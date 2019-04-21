package pl.sidor.CarFactory.service

import models.Chassis
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class ChassisServiceImplTest extends Specification {

    private RestTemplate restTemplate
    private ChassisService chassisService
    private static final String AUTO_PARTS_URL = "http://localhost:8080/"

    void setup() {
        restTemplate = Mock(RestTemplate)
        chassisService = new ChassisServiceImpl(restTemplate)
    }

    def "should return Chassis by ID"() {
        given:
        Integer id = 1
        Chassis chassis = new Chassis.ChassisBuilder().id(1).brakes("Brembo").drive("XDrive").build()
        restTemplate.exchange(AUTO_PARTS_URL + "chassis/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Chassis>() {
        }) >> new ResponseEntity<Chassis>(chassis, HttpStatus.OK)

        when:
        Chassis actualChassis = chassisService.findById(id)

        then:
        actualChassis != null
        actualChassis == chassis
    }

    def "should return Chassis List"() {
        given:
        List<Chassis> chassisList = new ArrayList<>()
        Chassis chassis1 = new Chassis.ChassisBuilder().id(1).brakes("Brembo").drive("Quattro").build()
        Chassis chassis2 = new Chassis.ChassisBuilder().id(2).brakes("AVG").drive("XDRIVE").build()
        Chassis chassis3 = new Chassis.ChassisBuilder().id(3).brakes("Brembo").drive("Quattro").build()
        Chassis chassis4 = new Chassis.ChassisBuilder().id(4).brakes("AVG").drive("4Matic").build()

        chassisList.add(chassis1)
        chassisList.add(chassis2)
        chassisList.add(chassis3)
        chassisList.add(chassis4)

        restTemplate.exchange(AUTO_PARTS_URL + "chassis", HttpMethod.GET, null, new ParameterizedTypeReference<List<Chassis>>() {
        }) >> ResponseEntity.ok(chassisList)

        when:
        List<Chassis> actualListChassis = chassisService.findAll()

        then:
        actualListChassis != null
        actualListChassis == chassisList
        actualListChassis.size() == 4
    }

    def "should return Empty Chassis List"() {
        given:
        restTemplate.exchange(AUTO_PARTS_URL + "chassis", HttpMethod.GET, null, new ParameterizedTypeReference<List<Chassis>>() {
        }) >> ResponseEntity.ok(Collections.emptyList())

        when:
        List<Chassis> actualChassisList = chassisService.findAll()

        then:
        actualChassisList.isEmpty()
    }
}
