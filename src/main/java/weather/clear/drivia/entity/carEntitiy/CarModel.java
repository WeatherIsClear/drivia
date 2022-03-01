package weather.clear.drivia.entity.carEntitiy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarModel {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_seater_id")
    private CarSeater carSeater;

    @ManyToOne
    @JoinColumn(name = "car_transmisson_id")
    private CarTransmission carTransmission;

    @ManyToOne
    @JoinColumn(name = "car_manufacturer_id")
    private CarManufacturer carManufacturer;

}
