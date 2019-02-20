package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Mark")
    private String name;

    @Column(name = "Model")
    private String model;

    @OneToOne()
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @OneToOne
    @JoinColumn(name = "body_id")
    private Body body;

    @OneToOne
    @JoinColumn(name = "chassis_id")
    private Chassis chassis;

    @Column(name = "Color")
    private String color;


}
