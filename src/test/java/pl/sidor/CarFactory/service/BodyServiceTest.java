package pl.sidor.CarFactory.service;

import models.Body;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BodyServiceTest {

    private static final String URL = "http://localhost:8080/";
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BodyService bodyService = new BodyServiceImpl(restTemplate);

    @Test
    public void givenBodyByIdFromAutoParts() {

        Body body = new Body(1, "Avant", "Red", 4);

        Mockito.
                when(restTemplate.exchange(URL + "body/1", HttpMethod.GET, null, new ParameterizedTypeReference<Body>() {
                })).thenReturn(new ResponseEntity<Body>(body, HttpStatus.OK));

        Body byId = bodyService.findById(1);

        Assert.assertEquals(body, byId);
    }

    @Test
    public void givenFindAllBody() {

        List<Body> bodies = new ArrayList<>();
        Mockito.
                when(restTemplate.exchange(URL + "bodies", HttpMethod.GET, null, new ParameterizedTypeReference<List<Body>>() {
                })).thenReturn(new ResponseEntity<List<Body>>(bodies, HttpStatus.OK));

        List<Body> all = bodyService.findAll();
        Assert.assertEquals(0, all.size());
    }


}
