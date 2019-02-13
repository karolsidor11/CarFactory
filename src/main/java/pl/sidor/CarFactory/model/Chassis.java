package pl.sidor.CarFactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Podwozie")
public class Chassis {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Naped")
    private String drive;

    @Column(name = "Hamulce")
    private String brakes;

    @Column(name = "Zawieszenie")
    private String suspension;

    @Column(name = "Układ_kierowniczy")
    private String steering;

}
