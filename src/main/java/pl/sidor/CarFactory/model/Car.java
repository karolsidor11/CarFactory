package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Samochody")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Marka")
    private String name;


    @Column(name = "Model")
    private String model;


    @OneToOne()
    @JoinColumn(name = "silnik_id")
    private Engine engine;

    @OneToOne
    @JoinColumn(name = "nadwozie_id")
    private Body body;

    @OneToOne
    @JoinColumn(name = "podwozie_id")
    private Chassis chassis;

    @Column(name = "Kolor")
    private String color;


}
