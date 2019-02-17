package pl.sidor.CarFactory.service;

import org.junit.Test;
import pl.sidor.CarFactory.dao.ChassisDaoImit;
import pl.sidor.CarFactory.model.Chassis;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ChassisServiceTest {

    private Chassis chassis;
    private ChassisDaoImit chassisDaoImit;

    public ChassisServiceTest() {
        chassisDaoImit = new ChassisDaoImit();
    }


    @Test
    public void shouldGetSizeChassisList() {

        Optional<List<Chassis>> all = chassisDaoImit.findAll();

        assertEquals(4, all.get().size());

    }

    @Test
    public void shouldFindChassisByID() {

        Optional<Chassis> byId = chassisDaoImit.findById(1);

        assertEquals(1, byId.get().getId());
    }

    @Test
    public void shouldAddChassistoList() {

        chassis = new Chassis(5, "4Matic", "AVG", "Bilstein", "ATC");

        Optional<List<Chassis>> all = chassisDaoImit.findAll();
        all.get().add(chassis);

        assertEquals(5, all.get().size());
    }

    @Test
    public void shouldReturnDriveChassis(){

        Chassis chassis = chassisDaoImit.findById(2).get();

        assertEquals("Quattro", chassis.getDrive());
    }
}
