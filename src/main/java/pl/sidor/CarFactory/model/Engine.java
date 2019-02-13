package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Silnik")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Pojemność")
    private double capacity;

    @Column(name = "Moc")
    private int power;

    @Column(name = "Moment_obrotowy")
    private int torque;
}
