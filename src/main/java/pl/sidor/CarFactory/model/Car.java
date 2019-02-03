package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Samochody")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "Marka")
    private String name;

    @Column(name = "Model")
    private String model;

    @Column(name = "Moc")
    private int power;

    @Column(name = "Pojemność")
    private double capacity;

    @Column(name = "Kolor")
    private String color;

    @Column(name = "Dlugość")
    private double length;

    @Column(name = "Szerokość")
    private double width;

}
