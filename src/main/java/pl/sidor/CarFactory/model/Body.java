package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "BodyCar")
    private String bodyCar;

    @Column(name = "Color")
    private String color;

    @Column(name = "Doors")
    private int door;

}
