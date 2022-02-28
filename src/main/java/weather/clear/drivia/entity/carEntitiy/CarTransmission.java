package weather.clear.drivia.entity.carEntitiy;

import javax.persistence.*;

@Entity
public class CarTransmission {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;
}
