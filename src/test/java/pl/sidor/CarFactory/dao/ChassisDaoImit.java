//package pl.sidor.CarFactory.dao;
//
//import pl.sidor.CarFactory.models.Chassis;
//import pl.sidor.CarFactory.service.ChassisService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ChassisDaoImit implements ChassisService {
//
//    private List<Chassis> chassisList = new ArrayList<>();
//
//    public ChassisDaoImit() {
//        chassisList.add(new Chassis(1, "XDrive", "Brembo", "Bilstein", "McPerson"));
//        chassisList.add(new Chassis(2, "Quattro", "Derm", "Bilstein", "McPerson"));
//        chassisList.add(new Chassis(3, "XDrive", "Brembo", "Bilstein", "McPerson"));
//        chassisList.add(new Chassis(4, "Quattro", "Derm", "Bilstein", "McPerson"));
//    }
//
//    @Override
//    public Optional<List<Chassis>> findAll() {
//        return Optional.ofNullable(chassisList);
//    }
//
//    @Override
//    public Optional<Chassis> findById(int id) {
//        return Optional.ofNullable(chassisList.stream().filter(chassis -> chassis.getId() == id).findFirst().get());
//    }
//}
