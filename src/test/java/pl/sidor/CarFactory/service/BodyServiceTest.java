package pl.sidor.CarFactory.service;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.CarFactory.dao.BodyDaoImit;
import pl.sidor.CarFactory.model.Body;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class BodyServiceTest {

    private BodyDaoImit bodyDaoImit;
    private Body body;

    @Before
    public void before() {
        bodyDaoImit = new BodyDaoImit();
        body = new Body(5, "Avant", "Biały", 7);
    }

    @Test
    public void shouldCreateBody() {
        Body body = new Body(1, "Avant", "Czarny", 5);

        assertEquals(1, body.getId());
        assertEquals("Avant", body.getBodyCar());
        assertEquals("Czarny", body.getColor());

    }

    @Test
    public void shouldReturnSizeList() {

        Optional<List<Body>> all = bodyDaoImit.findAll();

        assertEquals(4, bodyDaoImit.findAll().get().size());
    }

    @Test
    public void shouldBodyCarFromId() {
        Optional<Body> byId = bodyDaoImit.findById(1);

        assertEquals("Avant", bodyDaoImit.findById(1).get().getBodyCar());
    }

    @Test
    public void shouldAddBodyToList(){

        Optional<List<Body>> all = bodyDaoImit.findAll();

        List<Body> bodies = all.get();
        bodies.add(body);

        assertEquals(5,bodyDaoImit.findAll().get().size() );

    }


}
