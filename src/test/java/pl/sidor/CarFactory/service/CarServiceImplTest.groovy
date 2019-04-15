package pl.sidor.CarFactory.service

import models.Car
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class CarServiceImplTest extends Specification {

    private RestTemplate restTemplate
    private CarService carService
    private static final String AUTO_PARTS_URL = "http://localhost:8080/";


    void setup() {
        restTemplate = Mock(RestTemplate)
        carService = new CarServiceImpl(restTemplate)
    }

    def "should  find Engine List"() {

        given:
        List<Car> carList = new ArrayList<>()

        Car car1 = new Car.CarBuilder().id(1).name("Audi").build()
        Car car2 = new Car.CarBuilder().id(2).name("Audi").build()
        Car car3 = new Car.CarBuilder().id(3).name("Audi").build()
        Car car4 = new Car.CarBuilder().id(4).name("Audi").build()

        carList.add(car1)
        carList.add(car2)
        carList.add(car3)
        carList.add(car4)

        restTemplate.exchange(AUTO_PARTS_URL + "cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
        }) >> ResponseEntity.ok(carList)

        when:
        List<Car> actualCarList = carService.findAll()
        then:
        actualCarList != null
        actualCarList == carList
    }

    def "should save Car"() {
        given:
        Car car = new Car.CarBuilder().id(1).name("Audi").models("A6").build()

        restTemplate.postForObject(AUTO_PARTS_URL + "save", car, Car.class) >> car

        when:
        Car actualCar = carService.saveCar(car)

        then:
        actualCar!=null
        actualCar==car
    }
}
